package yatspecscreencapturesupport;

import com.googlecode.yatspec.junit.SpecResultListener;
import com.googlecode.yatspec.junit.SpecRunner;
import com.googlecode.yatspec.junit.WithCustomResultListeners;
import com.googlecode.yatspec.state.givenwhenthen.TestState;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
//IMPORTANT: Selenium 2.48.0 is supported for Firefox from 24 to 41 only(If you have newer versions of firefox this may not work)
@RunWith(SpecRunner.class)
public class GuiSeleniumAndYatspecTest extends TestState implements WithCustomResultListeners {

    private static final String START_URL = "http://www.google.com";
    protected WebDriver driver;
    protected static WebDriverBackedSelenium selenium;

    @Before
    public void setupSelenium() throws InterruptedException {
        driver = new FirefoxDriver();
        selenium = new WebDriverBackedSelenium(driver, START_URL);
    }

    @After
    public void closeSelenium() throws Exception {
        selenium.stop();
    }

    public void takeScreenshoot(String screenshootTitle) throws Exception {
        String imageData = selenium.captureScreenshotToString();
        this.capturedInputAndOutputs.add(screenshootTitle, new ScreenshootHolder(imageData));
        System.out.println("Captured screen shoot");
    }


    @Override
    public Iterable<SpecResultListener> getResultListeners() throws Exception {
        String testName = this.getClass().getSimpleName();
        return Arrays.asList((SpecResultListener) new HtmlWithScreenshootResultListener(testName));
    }

    @Test
    public void stabilityTest() throws Exception {
        //This empty test avoids no runnable methods exception(You cannot use Spec runner, and have no tests in the class)
    }
}
