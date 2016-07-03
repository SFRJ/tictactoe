package application.acceptancetests;

import application.Application;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import yatspecscreencapturesupport.GuiSeleniumAndYatspecTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

/*
Make sure you are running the app, before running the acceptance test(gradle bootRun)
 */
public class TicTacToeAcceptaceTest extends GuiSeleniumAndYatspecTest {

    public static final String EMPTY = "";

    @Test
    public void theBoardIsEmpty() throws Exception {
        givenTheUserWantsToPlayTicTacToe();
        whenTheUserArrivesToTicTacToe();
        thenTheBoardIsEmpty();
    }

    private void givenTheUserWantsToPlayTicTacToe() throws Exception {
        takeScreenshoot();
    }

    private void whenTheUserArrivesToTicTacToe() {
        driver.get("http://localhost:8080");
    }

    private void thenTheBoardIsEmpty() throws Exception {
        assertThat(driver.findElement(id("top-left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("top")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("top-right")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("middle")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("right")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom-left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom-right")).getText()).isEqualTo(EMPTY);
        takeScreenshoot();
    }
}
