package application.services;

import application.model.GameBoard;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CombinationsValidatorTest {

    public static final String X = "x";
    public static final String Y = "y";
    private GameBoard gameBoard =  new GameBoard();
    private CombinationsValidator combinationsValidator = new CombinationsValidator();
    private boolean result;


    @Test
    public void player1WinsInFirstRow() throws Exception {
        gameBoard.setTopleft(X);
        gameBoard.setTop(X);
        gameBoard.setTopright(X);
        result = combinationsValidator.completedFirstRow(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    public void player1WinsInSecondRow() throws Exception {
        gameBoard.setLeft(X);
        gameBoard.setMiddle(X);
        gameBoard.setRight(X);
        result = combinationsValidator.completedSecondRow(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    public void player1WinsInThirdRow() throws Exception {
        gameBoard.setBottomleft(X);
        gameBoard.setBottom(X);
        gameBoard.setBottomright(X);
        result = combinationsValidator.completedThirdRow(gameBoard, X);
        assertThat(result).isTrue();

    }

    @Test
    public void player1WinsInFirstColumn() throws Exception {
        gameBoard.setTopleft(X);
        gameBoard.setLeft(X);
        gameBoard.setBottomleft(X);
        result = combinationsValidator.completedFirstColumn(gameBoard, X);
        assertThat(result).isTrue();

    }

    @Test
    public void player1WinsInSecondColumn() throws Exception {
        gameBoard.setTop(X);
        gameBoard.setMiddle(X);
        gameBoard.setBottom(X);
        result = combinationsValidator.completedSecondColumn(gameBoard, X);
        assertThat(result).isTrue();

    }

    @Test
    public void player1WinsInThirdColumn() throws Exception {
        gameBoard.setTopright(X);
        gameBoard.setRight(X);
        gameBoard.setBottomright(X);
        result = combinationsValidator.completedThirdColumn(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    public void player1WinsInFirstDiagonal() throws Exception {
        gameBoard.setTopleft(X);
        gameBoard.setMiddle(X);
        gameBoard.setBottomright(X);
        result = combinationsValidator.completedFirstDiagonal(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    public void player1WinsInSecondDiagonal() throws Exception {
        gameBoard.setTopright(X);
        gameBoard.setMiddle(X);
        gameBoard.setBottomleft(X);
        result = combinationsValidator.completedSecondDiagonal(gameBoard, X);
        assertThat(result).isTrue();
    }

    @Test
    public void player2WinsInFirstRow() throws Exception {
        gameBoard.setTopleft(Y);
        gameBoard.setTop(Y);
        gameBoard.setTopright(Y);
        result = combinationsValidator.completedFirstRow(gameBoard, Y);
        assertThat(result).isTrue();
    }

    @Test
    public void player2WinsInSecondRow() throws Exception {
        gameBoard.setLeft(Y);
        gameBoard.setMiddle(Y);
        gameBoard.setRight(Y);
        result = combinationsValidator.completedSecondRow(gameBoard, Y);
        assertThat(result).isTrue();
    }

    @Test
    public void player2WinsInThirdRow() throws Exception {
        gameBoard.setBottomleft(Y);
        gameBoard.setBottom(Y);
        gameBoard.setBottomright(Y);
        result = combinationsValidator.completedThirdRow(gameBoard, Y);
        assertThat(result).isTrue();

    }

    @Test
    public void player2WinsInFirstColumn() throws Exception {
        gameBoard.setTopleft(Y);
        gameBoard.setLeft(Y);
        gameBoard.setBottomleft(Y);
        result = combinationsValidator.completedFirstColumn(gameBoard, Y);
        assertThat(result).isTrue();

    }

    @Test
    public void player2WinsInSecondColumn() throws Exception {
        gameBoard.setTop(Y);
        gameBoard.setMiddle(Y);
        gameBoard.setBottom(Y);
        result = combinationsValidator.completedSecondColumn(gameBoard, Y);
        assertThat(result).isTrue();

    }

    @Test
    public void player2WinsInThirdColumn() throws Exception {
        gameBoard.setTopright(Y);
        gameBoard.setRight(Y);
        gameBoard.setBottomright(Y);
        result = combinationsValidator.completedThirdColumn(gameBoard, Y);
        assertThat(result).isTrue();
    }

    @Test
    public void player2WinsInFirstDiagonal() throws Exception {
        gameBoard.setTopleft(Y);
        gameBoard.setMiddle(Y);
        gameBoard.setBottomright(Y);
        result = combinationsValidator.completedFirstDiagonal(gameBoard, Y);
        assertThat(result).isTrue();
    }

    @Test
    public void player2WinsInSecondDiagonal() throws Exception {
        gameBoard.setTopright(Y);
        gameBoard.setMiddle(Y);
        gameBoard.setBottomleft(Y);
        result = combinationsValidator.completedSecondDiagonal(gameBoard, Y);
        assertThat(result).isTrue();
    }

}