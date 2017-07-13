package tvProgrammeTesting;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tvProgrammeTesting.pojo.currentlyRunningShow.CurrentlyRunningShow;
import tvProgrammeTesting.pojo.weeklyChannelProgramme.ChannelProgramme;
import tvProgrammeTesting.service.helpers.CurrentlyRunningShowHelper;
import tvProgrammeTesting.service.http.SimpleHttpClient;
import tvProgrammeTesting.utils.http.HttpUtils;
import tvProgrammeTesting.utils.json.JsonUtils;
import tvProgrammeTesting.utils.logger.LoggerUtils;
import tvProgrammeTesting.utils.xml.XmlUtils;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class OnePlusOneTestSuite {

    private Logger logger = LoggerUtils.getLogger(OnePlusOneTestSuite.class.getSimpleName());
    private SimpleHttpClient httpClient = new SimpleHttpClient();
    private ChannelProgramme.Programme showInChannelProgramme;
    private CurrentlyRunningShow.Program onePlusOneCurrentlyRunningShow;

    @DataProvider(name = "channelPrograms")
    public Object[][] createTestData() {
        String onePlusOneProgrammeXml = HttpUtils.getResponseBodyString(
                httpClient.get("http://www.vsetv.com/export/megogo/epg/3.xml"));
        ChannelProgramme onePlusOneProgrammeData = XmlUtils.mapXmlOnObject(
                XmlUtils.removeXmlDeclarationAndDocType(onePlusOneProgrammeXml), ChannelProgramme.class);

        String onePlusOneCurrentlyRunningShowJson =
                HttpUtils.getResponseBodyString(httpClient.get("http://epg.megogo.net/channel/now?external_id=295"));
        CurrentlyRunningShow onePlusOneCurrentlyRunningShowData =
                JsonUtils.mapJsonOnObject(onePlusOneCurrentlyRunningShowJson, CurrentlyRunningShow.class);

        Assert.assertNotNull(onePlusOneProgrammeData);
        Assert.assertNotNull(onePlusOneCurrentlyRunningShowData);

        return new Object[][]{
                {onePlusOneProgrammeData, onePlusOneCurrentlyRunningShowData},
        };
    }

    @Test(dataProvider = "channelPrograms")
    public void checkOnePlusOneDataConsistency(ChannelProgramme onePlusOneProgramme, CurrentlyRunningShow onePlusOneCurrentlyRunningShowData) {
        logger.log(Level.INFO, "CURRENTLY RUNNING SHOW LIST: " + onePlusOneCurrentlyRunningShowData.toString());

        onePlusOneCurrentlyRunningShow =
                new CurrentlyRunningShowHelper(onePlusOneCurrentlyRunningShowData).getProgramData();

        List<ChannelProgramme.Programme> filteredShowList = onePlusOneProgramme.getProgramme().stream()
                .filter(programme -> programme.getStart().equals(onePlusOneCurrentlyRunningShow.getStart())
                        && programme.getStop().equals(onePlusOneCurrentlyRunningShow.getEnd()))
                .collect(Collectors.toList());

        filteredShowList.forEach(sl -> logger.log(Level.INFO, "FILTERED FROM WEEKLY CHANNEL PROGRAMME SHOW LIST: " + sl.toString()));

        assertFalse(filteredShowList.size() == 0,
                "No any shows were found in the channel programme with a such start/stop time");
        assertTrue(filteredShowList.size() == 1,
                "More than one show were found for the specified start/stop time in the channel programme");

        showInChannelProgramme = filteredShowList.get(0);
        assertNotNull(showInChannelProgramme.getTitle(), "Show title in channel programme is null");
        assertNotNull(showInChannelProgramme.getGenre(), "Show genre in channel programme is null");
        assertNotNull(showInChannelProgramme.getProductionYear(), "Show year in channel programme is null");
        assertNotNull(onePlusOneCurrentlyRunningShow.getTitle(), "Show title in currently running is null");
        assertNotNull(onePlusOneCurrentlyRunningShow.getGenre(), "Show genre in currently running is null");
        assertNotNull(onePlusOneCurrentlyRunningShow.getYear(), "Show year in currently running is null");
    }

    @Test(dependsOnMethods = {"checkOnePlusOneDataConsistency"}, dataProvider = "channelPrograms")
    public void checkOnePlusOneCurrentlyRunningShow(ChannelProgramme onePlusOneProgramme, CurrentlyRunningShow.Program onePlusOneCurrentlyRunningShow) {
        assertEquals(onePlusOneCurrentlyRunningShow.getTitle(), showInChannelProgramme.getTitle().getValue(),
                "Currently running show title not as expected");
        assertEquals(onePlusOneCurrentlyRunningShow.getGenre().getTitle(), showInChannelProgramme.getGenre().getValue(),
                "Currently running show genre not as expected");
        assertEquals(onePlusOneCurrentlyRunningShow.getYear(), showInChannelProgramme.getProductionYear(),
                "Currently running show genre not as expected");
    }
}
