package StoreInfo;

import base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.StartPageObjects;
import java.io.IOException;
import java.util.List;

public class StoreInfoTests extends Base {


    //Reports
    ExtentHtmlReporter htmlReporter = null;
    ExtentReports erExtent = null;
    ExtentTest etTestLogger = null;

    //Page Actions
    StartPageObjects oStartPageActions = null;

    @BeforeClass
    public void beforeClass() throws IOException {

        oStartPageActions = new StartPageObjects(myDriver);

        // start reporters
        htmlReporter = new ExtentHtmlReporter("./Reports/ChallengeTest.html");

        // create ExtentReports and attach reporter(s)
        erExtent = new ExtentReports();

        erExtent.attachReporter(htmlReporter);
    }

    @AfterClass
    public void afterClass() {
        erExtent.flush();
        //myDriver.quit();
    }

    @Test(groups = "Store")
    public void validateStoreInformation() {
        try {
            etTestLogger = erExtent.createTest("validateStoreInformation");

            //SCROLL TO BOTTOM
            etTestLogger.log(Status.INFO, "Start Test.");
            oStartPageActions.scrollToBottom();
            etTestLogger.log(Status.PASS, "Scroll to bottom.");

            //GET THE STORE INFORMATION
            List<String> sListOfResult = oStartPageActions.getStoreInfo();
            for (String sElement : sListOfResult) {
                System.out.println(sElement);
                etTestLogger.log(Status.INFO, "Validate: " + sElement);
                Assert.assertTrue(sElement.contains("Selenium Framework, Research Triangle Park, North Carolina, USA") || sElement.contains("Call us now: (347) 466-7432") || sElement.contains("Email: support@seleniumframework.com"));
                etTestLogger.log(Status.PASS, "Pass: " + sElement);
            }
        }catch (Exception eEx){
            etTestLogger.log(Status.FAIL,"Error: " + eEx);
            Assert.fail();
        }
    }
}
