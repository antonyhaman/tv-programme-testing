package com.github.kotvertolet.tvprogrammetesting;

import com.github.kotvertolet.tvprogrammetesting.pojo.currentlyRunningShow.CurrentlyRunningShow;
import com.github.kotvertolet.tvprogrammetesting.pojo.channelProgramme.WeeklyChannelProgramme;
import com.github.kotvertolet.tvprogrammetesting.service.helpers.CurrentlyRunningShowHelper;
import com.github.kotvertolet.tvprogrammetesting.service.http.SimpleHttpClient;
import com.github.kotvertolet.tvprogrammetesting.utils.http.HttpUtils;
import com.github.kotvertolet.tvprogrammetesting.utils.json.JsonUtils;
import com.github.kotvertolet.tvprogrammetesting.utils.logger.LoggerUtils;
import com.github.kotvertolet.tvprogrammetesting.utils.xml.XmlUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class OnePlusOneTest {

    private Logger logger = LoggerUtils.getLogger(OnePlusOneTest.class.getSimpleName());
    private SimpleHttpClient httpClient = new SimpleHttpClient();
    private WeeklyChannelProgramme.Programme showInChannelProgramme;
    private CurrentlyRunningShow.Program onePlusOneCurrentlyRunningShow;

    @DataProvider(name = "channelPrograms")
    public Object[][] createTestData() {
        String onePlusOneProgrammeXml = HttpUtils.getResponseBodyString(
                httpClient.get("http://www.vsetv.com/export/megogo/epg/3.xml"));
        WeeklyChannelProgramme onePlusOneProgrammeData = XmlUtils.mapXmlOnObject(
                XmlUtils.removeXmlDeclarationAndDocType(onePlusOneProgrammeXml), WeeklyChannelProgramme.class);

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
    public void checkOnePlusOneDataConsistency(WeeklyChannelProgramme onePlusOneProgramme, CurrentlyRunningShow onePlusOneCurrentlyRunningShowData) {
        logger.log(Level.INFO, "CURRENTLY RUNNING SHOW LIST: " + onePlusOneCurrentlyRunningShowData.toString());

        onePlusOneCurrentlyRunningShow =
                new CurrentlyRunningShowHelper(onePlusOneCurrentlyRunningShowData).getProgramData();

        List<WeeklyChannelProgramme.Programme> filteredShowList = onePlusOneProgramme.getProgramme().stream()
                .filter(programme -> programme.getStart().equals(onePlusOneCurrentlyRunningShow.getStart())
                        && programme.getStop().equals(onePlusOneCurrentlyRunningShow.getEnd()))
                .collect(Collectors.toList());

        filteredShowList.forEach(sl -> logger.log(Level.INFO, "FILTERED FROM WEEKLY CHANNEL PROGRAMME SHOW LIST: " + sl.toString()));

        assertFalse(filteredShowList.size() == 0,
                "No any shows were found in the channel programme with a such start/stop time");
        assertTrue(filteredShowList.size() == 1,
                "More than one show were found for the specified start/stop time in the channel programme");

        showInChannelProgramme = filteredShowList.get(0);
        assertNotNull(showInChannelProgramme.getTitle(), "Show's Title in channel programme is null");
        assertNotNull(showInChannelProgramme.getGenre(), "Show's Genre in channel programme is null");
        assertNotNull(showInChannelProgramme.getProductionYear(), "Show's Year in channel programme is null");
        assertNotNull(onePlusOneCurrentlyRunningShow.getTitle(), "Show's Title in currently running is null");
        assertNotNull(onePlusOneCurrentlyRunningShow.getGenre(), "Show's Genre in currently running is null");
        assertNotNull(onePlusOneCurrentlyRunningShow.getYear(), "Show's Year in currently running is null");
    }

    @Test(dependsOnMethods = {"checkOnePlusOneDataConsistency"}, dataProvider = "channelPrograms")
    public void checkOnePlusOneCurrentlyRunningShow(WeeklyChannelProgramme onePlusOneProgramme, CurrentlyRunningShow onePlusOneCurrentlyRunningShowData) {
        assertEquals(onePlusOneCurrentlyRunningShow.getTitle(), showInChannelProgramme.getTitle().getValue(),
                "Currently running show's Title is not as expected");
        assertEquals(onePlusOneCurrentlyRunningShow.getGenre().getId(), showInChannelProgramme.getGenreId(),
                "Currently running show's Genre_Id is not as expected");
        assertEquals(onePlusOneCurrentlyRunningShow.getYear(), showInChannelProgramme.getProductionYear(),
                "Currently running show's Year is not as expected");
    }
}
