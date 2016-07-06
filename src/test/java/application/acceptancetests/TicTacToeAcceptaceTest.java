package application.acceptancetests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import yatspecscreencapturesupport.GuiSeleniumAndYatspecTest;
import yatspecscreencapturesupport.ScreenshootHolder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.id;

/*
Make sure you are running the app, before running the acceptance test(gradle bootRun)
 */
public class TicTacToeAcceptaceTest extends GuiSeleniumAndYatspecTest {

    public static final String EMPTY = "";

    @Test
    public void theBoardIsEmpty() throws Exception {
        givenUserIsAtTheGamePage();
        whenThePlayerLooksAtTheBoard();
        thenTheBoardIsEmpty();
    }

    @Test
    public void player1SelectsPossition() throws Exception {
        givenUserIsAtTheGamePage();
        whenTheUserSelectsAPosition();
        thenJustTheSelectedPositionRemainsSelected();
    }

    //givens
    private void givenUserIsAtTheGamePage() throws Exception {
        navigateToGame();
    }

    //whens
    private void whenThePlayerLooksAtTheBoard() throws Exception {
        takeScreenshoot("Board");
    }

    private void whenTheUserSelectsAPosition() throws InterruptedException {
        String position = "top-left";
        interestingGivens.add("Selected Position", position);
        WebElement element = driver.findElement(id(position));
        element.click();
    }

    //thens
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
    }

    private void thenJustTheSelectedPositionRemainsSelected() throws Exception {
        takeScreenshoot("Board after player selects position");
        assertThat(driver.findElement(id("top-left")).getText()).isEqualTo("x");
        assertThat(driver.findElement(id("top")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("top-right")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("middle")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("right")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom-left")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom")).getText()).isEqualTo(EMPTY);
        assertThat(driver.findElement(id("bottom-right")).getText()).isEqualTo(EMPTY);
    }

    private void navigateToGame() throws Exception {
        driver.get("http://localhost:8080");
        takeScreenshoot("Board");
    }
}
