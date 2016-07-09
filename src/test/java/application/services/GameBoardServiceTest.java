package application.services;

import application.model.GameBoard;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class GameBoardServiceTest {

    public static final String TOPLEFT = "topleft";
    public static final String TOPRIGHT = "topright";
    public static final String RIGHT = "right";
    public static final String MIDDLE = "middle";
    public static final String LEFT = "left";
    public static final String TOP = "top";
    public static final String BOTTOMRIGHT = "bottomright";
    public static final String BOTTOM = "bottom";
    public static final String BOTTOMLEFT = "bottomleft";
    private GameBoardService gameBoardService = new GameBoardService();
    private GameBoard gameBoard;
    private GameBoard result;

    @Before
    public void setUp() throws Exception {
        gameBoard = new GameBoard();
    }

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
        play(TOPLEFT);
    }

    private void givenFirstPlayerSelectsPosition() {
        play(TOPLEFT);
    }

    private void givenPlayer2Has2OinSecondDiagonal() {
        play(TOPLEFT);
        play(TOPRIGHT);
        play(RIGHT);
        play(MIDDLE);
        play(LEFT);
    }

    private void givenPlayer2Has2OinFirstDiagonal() {
        play(TOPRIGHT);
        play(TOPLEFT);
        play(RIGHT);
        play(MIDDLE);
        play(LEFT);
    }

    private void givenPlayer2Has2OinThirdColumn() {
        play(TOPLEFT);
        play(TOPRIGHT);
        play(MIDDLE);
        play(RIGHT);
        play(LEFT);
    }

    private void givenPlayer2Has2OinSecondColumn() {
        play(TOPLEFT);
        play(TOP);
        play(LEFT);
        play(MIDDLE);
        play(BOTTOMRIGHT);
    }

    private void givenPlayer2Has2OinFirstColumn() {
        play(MIDDLE);
        play(TOPLEFT);
        play(BOTTOM);
        play(LEFT);
        play(TOPRIGHT);
    }

    private void givenPlayer2Has2OinThirdRow() {
        play(TOPLEFT);
        play(BOTTOMLEFT);
        play(LEFT);
        play(BOTTOM);
        play(MIDDLE);
    }

    private void givenPlayer2Has2OinSecondRow() {
        play(TOPLEFT);
        play(LEFT);
        play(TOP);
        play(MIDDLE);
        play(BOTTOM);
    }

    private void givenPlayer2Has2OInFirstRow() {
        play(LEFT);
        play(TOPLEFT);
        play(MIDDLE);
        play(TOP);
        play(BOTTOM);
    }

    private void givenPlayer1Has2XinFirstDiagonal() {
        play(TOPLEFT);
        play(LEFT);
        play(MIDDLE);
        play(BOTTOM);
    }

    private void givenPlayer1Has2XinSecondDiagonal() {
        play(TOPRIGHT);
        play(LEFT);
        play(MIDDLE);
        play(BOTTOM);
    }

    private void givenPlayer1Has2XinThirdColumn() {
        play(TOPRIGHT);
        play(LEFT);
        play(RIGHT);
        play(MIDDLE);
    }

    private void givenPlayer1Has2XinSecondColumn() {
        play(TOP);
        play(LEFT);
        play(MIDDLE);
        play(RIGHT);
    }

    private void givenPlayer1Has2XinFirstColumn() {
        play(TOPLEFT);
        play(BOTTOM);
        play(LEFT);
        play(MIDDLE);
    }

    private void givenPlayer1Has2XinThirdRow() {
        play(BOTTOMLEFT);
        play(LEFT);
        play(BOTTOM);
        play(MIDDLE);
    }

    private void givenPlayer1Has2XInFirstRow() {
        play(TOPLEFT);
        play(LEFT);
        play(TOP);
        play(MIDDLE);
    }

    private void givenPlayer1Has2XinSecondRow() {
        play(LEFT);
        play(TOPLEFT);
        play(MIDDLE);
        play(TOP);
    }

    private void givenFirstTwoMoveAreAlreadyDone() {
        play(TOPLEFT);
        play(TOP);
    }


    private void givenUserSelectsTopLeftPosition() {
        gameBoard.setSelection(TOPLEFT);
    }


    private void givenAllPositionsButOneAreSelected() {
            play(BOTTOMRIGHT);
            play(BOTTOM);
            play(BOTTOMLEFT);

            play(RIGHT);
            play(MIDDLE);
            play(LEFT);

            play(TOP);
            play(TOPRIGHT);
    }

    //whens
    private void whenBoardIsUpdated() {
        result = gameBoardService.updateBoard(gameBoard);
    }

    private void whenSecondPlayerSelectsSamePosition() {
        result = play(TOPLEFT);
    }

    private void whenPlayer2Makes3rdOInFirstDiagonal() {
        result = play(BOTTOMRIGHT);
    }

    private void whenPlayer2Makes3rdOInSecondDiagonal() {
        result = play(BOTTOMLEFT);
    }

    private void whenPlayer2Makes3rdOInThirdColumn() {
        result = play(BOTTOMRIGHT);
    }

    private void whenPlayer2Makes3rdOInFirstColumn() {
        result = play(BOTTOMLEFT);
    }

    private void whenPlayer2Makes3rdOInSecondColumn() {
        result = play(BOTTOM);
    }

    private void whenPlayer2Makes3rdOInThirdRow() {
        result = play(BOTTOMRIGHT);
    }

    private void whenPlayer1Makes3rdXInSecondDiagonal() {
        result = play(BOTTOMLEFT);
    }

    private void whenPlayer2Makes3rdOInFirstRow() {
        result = play(TOPRIGHT);
    }

    private void whenPlayer1Makes3rdXInFirstDiagonal() {
        result = play(BOTTOMRIGHT);
    }

    private void whenPlayer1Makes3rdXInSecondColumn() {
        result = play(BOTTOM);
    }

    private void whenPlayer1Makes3rdXInThirdColumn() {
        result = play(BOTTOMRIGHT);
    }


    private void whenPlayer1Makes3rdXInFirstColumn() {
        result = play(BOTTOMLEFT);
    }

    private void whenPlayer1Makes3rdXInSecondRow() {
        result = play(RIGHT);
    }

    private void whenAPlayerSelectsTheLastPosition() {
        result = play(TOPLEFT);
    }

    private void whenPlayer1Makes3rdXInThirdRow() {
        result = play(BOTTOMRIGHT);
    }

    private void whenSecondMoveHappens() {
        result = play(TOPRIGHT);
    }

    private void whenThirdMoveHappens() {
        result = play(TOPRIGHT);
    }

    private void whenPlayer1Makes3rdXInFirstRow() {
        result = play(TOPRIGHT);
    }

    private void whenPlayer2Makes3rdOInSecondRow() {
        result = play(RIGHT);
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

    private GameBoard play(String selection) {
        gameBoard.setSelection(selection);
        return gameBoardService.updateBoard(gameBoard);
    }
}