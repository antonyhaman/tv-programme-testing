package tvProgrammeTesting.service.helpers;

import org.testng.Assert;
import tvProgrammeTesting.pojo.currentlyRunningShow.CurrentlyRunningShow;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CurrentlyRunningShowHelper {

    private CurrentlyRunningShow currentlyRunningShow;

    public CurrentlyRunningShowHelper(CurrentlyRunningShow currentlyRunningShow) {
        this.currentlyRunningShow = currentlyRunningShow;
    }

    public CurrentlyRunningShow.Program getProgramData() {
        Assert.assertTrue(currentlyRunningShow.getData().size() == 1);
        Assert.assertTrue(currentlyRunningShow.getData().get(0).getPrograms().size() == 1);
        return currentlyRunningShow.getData().get(0).getPrograms().get(0);
    }
}
