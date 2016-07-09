package application.services;

import application.model.GameBoard;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GameBoardServiceTest {

    private String selectedPosition;
    private GameBoardService gameBoardService = new GameBoardService();
    private GameBoard result;
    private List<String> positions = asList("top", "topright", "left",
            "middle", "right", "bottomleft",
            "bottom","bottomright");

    @Test
    public void firstArrivingPositionIsAlwaysAnX() throws Exception {
        givenUserSelectsTopLeftPosition();
        whenBoardIsUpdated();
        thenTopLeftContains("x");
    }

    @Test
    public void secondArrivingPositionIsAlwaysAnY() throws Exception {
        givenFirstMoveAlreadyDone();
        whenSecondMoveHappens();
        thenTheBoardContainsTheValuesOfBothMoves();
    }

    @Test
    public void thirdArrivingPositionIsAlwaysAnX() throws Exception {
        givenFirstTwoMoveAreAlreadyDone();
        whenThirdMoveHappens();
        thenTheBoardContainsTheValuesOfAllThreeMoves();
    }

    @Test
    public void returnsEmptyBoardWhenAllPositionsAreSelected() throws Exception {
        givenAllPositionsButOneAreSelected();
        whenAPlayerSelectsTheLastPosition();
        thenTheBoardReturnsEmpty();
    }

    //game rules start
    @Test
    public void increasesPlayer1CounterWhen3HorizontalXInFirstRow() throws Exception {
        givenPlayer1Has2XInFirstRow();
        whenPlayer1Makes3rdXInFirstRow();
        thenTheScoreForPlayer1IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer1CounterWhen3HorizontalXInSecondRow() throws Exception {
        givenPlayer1Has2XinSecondRow();
        whenPlayer1Makes3rdXInSecondRow();
        thenTheScoreForPlayer1IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer1CounterWhen3HorizontalXInThirdRow() throws Exception {
        givenPlayer1Has2XinThirdRow();
        whenPlayer1Makes3rdXInThirdRow();
        thenTheScoreForPlayer1IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer1CounterWhen3VericalXInFirstColumn() throws Exception {
        givenPlayer1Has2XinFirstColumn();
        whenPlayer1Makes3rdXInFirstColumn();
        thenTheScoreForPlayer1IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer1CounterWhen3VericalXInSecondColumn() throws Exception {
        givenPlayer1Has2XinSecondColumn();
        whenPlayer1Makes3rdXInSecondColumn();
        thenTheScoreForPlayer1IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer1CounterWhen3VericalXInThirdColumn() throws Exception {
        givenPlayer1Has2XinThirdColumn();
        whenPlayer1Makes3rdXInThirdColumn();
        thenTheScoreForPlayer1IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer1CounterWhen3XInFirstDiagonal() throws Exception {
        givenPlayer1Has2XinFirstDiagonal();
        whenPlayer1Makes3rdXInFirstDiagonal();
        thenTheScoreForPlayer1IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer1CounterWhen3XInSecondDiagonal() throws Exception {
        givenPlayer1Has2XinSecondDiagonal();
        whenPlayer1Makes3rdXInSecondDiagonal();
        thenTheScoreForPlayer1IsIncreased();
        thenTheBoardReturnsEmpty();
    }


    @Test
    public void increasesPlayer2CounterWhen3HorizontalOInFirstRow() throws Exception {
        givenPlayer2Has2OInFirstRow();
        whenPlayer2Makes3rdOInFirstRow();
        thenTheScoreForPlayer2IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer2CounterWhen3HorizontalOInSecondRow() throws Exception {
        givenPlayer2Has2OinSecondRow();
        whenPlayer2Makes3rdOInSecondRow();
        thenTheScoreForPlayer2IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer2CounterWhen3HorizontalOInThirdRow() throws Exception {
        givenPlayer2Has2OinThirdRow();
        whenPlayer2Makes3rdOInThirdRow();
        thenTheScoreForPlayer2IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer2CounterWhen3VericalOInFirstColumn() throws Exception {
        givenPlayer2Has2OinFirstColumn();
        whenPlayer2Makes3rdOInFirstColumn();
        thenTheScoreForPlayer2IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer2CounterWhen3VericalOInSecondColumn() throws Exception {
        givenPlayer2Has2OinSecondColumn();
        whenPlayer2Makes3rdOInSecondColumn();
        thenTheScoreForPlayer2IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer2CounterWhen3VericalOInThirdColumn() throws Exception {
        givenPlayer2Has2OinThirdColumn();
        whenPlayer2Makes3rdOInThirdColumn();
        thenTheScoreForPlayer2IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer2CounterWhen3OInFirstDiagonal() throws Exception {
        givenPlayer2Has2OinFirstDiagonal();
        whenPlayer2Makes3rdOInFirstDiagonal();
        thenTheScoreForPlayer2IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    @Test
    public void increasesPlayer2CounterWhen3OInSecondDiagonal() throws Exception {
        givenPlayer2Has2OinSecondDiagonal();
        whenPlayer2Makes3rdOInSecondDiagonal();
        thenTheScoreForPlayer2IsIncreased();
        thenTheBoardReturnsEmpty();
    }

    //game rules end

    @Test
    public void cantSelectAnAlreadySelectedPosition() throws Exception {
        givenFirstPlayerSelectsPosition();
        whenSecondPlayerSelectsSamePosition();
        thenTheBoardIsNotUpdated();
    }

    //givens
    private void givenFirstMoveAlreadyDone() {
        gameBoardService.updateBoard("topleft");
    }

    private void givenFirstPlayerSelectsPosition() {
        gameBoardService.updateBoard("topleft");
    }

    private void givenPlayer2Has2OinSecondDiagonal() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("topright");
        gameBoardService.updateBoard("right");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("left");
    }

    private void givenPlayer2Has2OinFirstDiagonal() {
        gameBoardService.updateBoard("topright");
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("right");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("left");
    }

    private void givenPlayer2Has2OinThirdColumn() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("topright");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("right");
        gameBoardService.updateBoard("left");
    }

    private void givenPlayer2Has2OinSecondColumn() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("top");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("bottomright");
    }

    private void givenPlayer2Has2OinFirstColumn() {
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("bottom");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("topright");
    }

    private void givenPlayer2Has2OinThirdRow() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("bottomleft");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("bottom");
        gameBoardService.updateBoard("middle");
    }

    private void givenPlayer2Has2OinSecondRow() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("top");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("bottom");
    }

    private void givenPlayer2Has2OInFirstRow() {
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("top");
        gameBoardService.updateBoard("bottom");
    }

    private void givenPlayer1Has2XinFirstDiagonal() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("bottom");
    }

    private void givenPlayer1Has2XinSecondDiagonal() {
        gameBoardService.updateBoard("topright");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("bottom");
    }

    private void givenPlayer1Has2XinThirdColumn() {
        gameBoardService.updateBoard("topright");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("right");
        gameBoardService.updateBoard("middle");
    }

    private void givenPlayer1Has2XinSecondColumn() {
        gameBoardService.updateBoard("top");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("right");
    }

    private void givenPlayer1Has2XinFirstColumn() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("bottom");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("middle");
    }

    private void givenPlayer1Has2XinThirdRow() {
        gameBoardService.updateBoard("bottomleft");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("bottom");
        gameBoardService.updateBoard("middle");
    }

    private void givenPlayer1Has2XInFirstRow() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("top");
        gameBoardService.updateBoard("middle");
    }

    private void givenPlayer1Has2XinSecondRow() {
        gameBoardService.updateBoard("left");
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("middle");
        gameBoardService.updateBoard("top");
    }


    private void givenFirstTwoMoveAreAlreadyDone() {
        gameBoardService.updateBoard("topleft");
        gameBoardService.updateBoard("top");
    }


    private void givenUserSelectsTopLeftPosition() {
        this.selectedPosition = "topleft";
    }

    private void givenAllPositionsButOneAreSelected() {
            gameBoardService.updateBoard("bottomright");
            gameBoardService.updateBoard("bottom");
            gameBoardService.updateBoard("bottomleft");

            gameBoardService.updateBoard("right");
            gameBoardService.updateBoard("middle");
            gameBoardService.updateBoard("left");

            gameBoardService.updateBoard("top");
            gameBoardService.updateBoard("topright");
    }

    //whens
    private void whenBoardIsUpdated() {
        result = gameBoardService.updateBoard(selectedPosition);
    }

    private void whenSecondPlayerSelectsSamePosition() {
        result = gameBoardService.updateBoard("topleft");
    }

    private void whenPlayer2Makes3rdOInFirstDiagonal() {
        result = gameBoardService.updateBoard("bottomright");
    }

    private void whenPlayer2Makes3rdOInSecondDiagonal() {
        result = gameBoardService.updateBoard("bottomleft");
    }

    private void whenPlayer2Makes3rdOInThirdColumn() {
        result = gameBoardService.updateBoard("bottomright");
    }

    private void whenPlayer2Makes3rdOInFirstColumn() {
        result = gameBoardService.updateBoard("bottomleft");
    }

    private void whenPlayer2Makes3rdOInSecondColumn() {
        result = gameBoardService.updateBoard("bottom");
    }

    private void whenPlayer2Makes3rdOInThirdRow() {
        result = gameBoardService.updateBoard("bottomright");
    }

    private void whenPlayer1Makes3rdXInSecondDiagonal() {
        result = gameBoardService.updateBoard("bottomleft");
    }

    private void whenPlayer2Makes3rdOInFirstRow() {
        result = gameBoardService.updateBoard("topright");
    }

    private void whenPlayer1Makes3rdXInFirstDiagonal() {
        result = gameBoardService.updateBoard("bottomright");
    }

    private void whenPlayer1Makes3rdXInSecondColumn() {
        result = gameBoardService.updateBoard("bottom");
    }


    private void whenPlayer1Makes3rdXInThirdColumn() {
        result = gameBoardService.updateBoard("bottomright");
    }

    private void whenPlayer1Makes3rdXInFirstColumn() {
        result = gameBoardService.updateBoard("bottomleft");
    }

    private void whenPlayer1Makes3rdXInSecondRow() {
        result = gameBoardService.updateBoard("right");
    }

    private void whenAPlayerSelectsTheLastPosition() {
        result = gameBoardService.updateBoard("topleft");
    }

    private void whenPlayer1Makes3rdXInThirdRow() {
        result = gameBoardService.updateBoard("bottomright");
    }

    private void whenSecondMoveHappens() {
        result = gameBoardService.updateBoard("topright");
    }

    private void whenThirdMoveHappens() {
        result = gameBoardService.updateBoard("topright");
    }

    private void whenPlayer1Makes3rdXInFirstRow() {
        result = gameBoardService.updateBoard("topright");
    }

    private void whenPlayer2Makes3rdOInSecondRow() {
        result = gameBoardService.updateBoard("right");
    }

    //thens
    private void thenTopLeftContains(String symbol) {
        assertThat(result.getTopleft()).isEqualTo(symbol);
    }

    private void thenTheBoardContainsTheValuesOfBothMoves() {
        assertThat(result.getTopleft()).isEqualTo("x");
        assertThat(result.getTopright()).isEqualTo("o");
    }

    private void thenTheBoardContainsTheValuesOfAllThreeMoves() {
        assertThat(result.getTopleft()).isEqualTo("x");
        assertThat(result.getTop()).isEqualTo("o");
        assertThat(result.getTopright()).isEqualTo("x");
    }

    private void thenTheScoreForPlayer2IsIncreased() {
        assertThat(result.getPlayer2()).isEqualTo("1");
    }

    private void thenTheScoreForPlayer1IsIncreased() {
        assertThat(result.getPlayer1()).isEqualTo("1");
    }

    private void thenTheBoardReturnsEmpty() {
        assertThat(result.getTop()).isEqualTo("");
        assertThat(result.getTopright()).isEqualTo("");

        assertThat(result.getLeft()).isEqualTo("");
        assertThat(result.getMiddle()).isEqualTo("");
        assertThat(result.getRight()).isEqualTo("");

        assertThat(result.getBottomleft()).isEqualTo("");
        assertThat(result.getBottom()).isEqualTo("");
        assertThat(result.getBottomright()).isEqualTo("");
        assertThat(result.getTopleft()).isEqualTo("");

    }

    private void thenTheBoardIsNotUpdated() {
        assertThat(result.getTopleft()).isEqualTo("x");
        assertThat(result.getTop()).isEqualTo("");
        assertThat(result.getTopright()).isEqualTo("");

        assertThat(result.getLeft()).isEqualTo("");
        assertThat(result.getMiddle()).isEqualTo("");
        assertThat(result.getRight()).isEqualTo("");

        assertThat(result.getBottomleft()).isEqualTo("");
        assertThat(result.getBottom()).isEqualTo("");
        assertThat(result.getBottomright()).isEqualTo("");
    }
}