package application.services;

import application.model.GameBoard;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardCleanupTest {

    private GameBoard gameBoard = new GameBoard();
    private BoardCleanup boardCleanup = new BoardCleanup();
    private boolean isEmpty;

    @Test
    public void cleansUpBoard() throws Exception {
        givenANonEmptyBoard();
        whenWeCallEmpty();
        thenTheBoardIsEmpty();
    }

    @Test
    public void boardIsFull() throws Exception {
        givenAFullBoard();
        whenWeCheckIfBoardIsFull();
        thenTheBoardIsFull();
    }

    //givens
    private void givenANonEmptyBoard() {
        gameBoard.setBottom("X");
    }

    private void givenAFullBoard() {
        gameBoard.setTopleft("X");
        gameBoard.setTop("X");
        gameBoard.setRight("X");

        gameBoard.setLeft("X");
        gameBoard.setMiddle("X");
        gameBoard.setRight("X");

        gameBoard.setBottomleft("X");
        gameBoard.setBottom("X");
        gameBoard.setBottomright("X");
    }

    //whens
    private void whenWeCheckIfBoardIsFull() {
        isEmpty = boardCleanup.isFull(gameBoard);
    }


    private void whenWeCallEmpty() {
        boardCleanup.empty(gameBoard);
    }

    //thens
    private void thenTheBoardIsEmpty() {
        assertThat(gameBoard.getBottom()).isEmpty();
    }

    private void thenTheBoardIsFull() {
        assertThat(isEmpty).isFalse();
    }
}