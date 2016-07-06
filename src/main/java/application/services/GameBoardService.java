package application.services;

import application.model.GameBoard;
import org.springframework.stereotype.Component;

import static java.lang.Integer.valueOf;

@Component
public class GameBoardService {

    public static final String X = "x";
    public static final String O = "o";
    public static final String EMPTY = "";
    private String currentSymbol = "x";
    private GameBoard gameBoard;

    public GameBoardService() {
        gameBoard = new GameBoard();
    }

    public GameBoard updateBoard(String position) {
        if(alreadySelected(position)) {
            return gameBoard;
        }
        resolvePosition(position);
        resolveScore();
        if(isFull(gameBoard)) {
            empty(gameBoard);
        }
        return gameBoard;
    }

    private boolean alreadySelected(String position) {
        switch (position) {
            case "topleft": {return !gameBoard.getTopleft().isEmpty();}
            case "topright": {return !gameBoard.getTopright().isEmpty();}
            case "top": {return !gameBoard.getTop().isEmpty();}
            case "left": {return !gameBoard.getLeft().isEmpty();}
            case "middle": {return !gameBoard.getMiddle().isEmpty();}
            case "right": {return !gameBoard.getRight().isEmpty();}
            case "bottomleft": {return !gameBoard.getBottomleft().isEmpty();}
            case "bottom": {return !gameBoard.getBottom().isEmpty();}
            case "bottomright": {return !gameBoard.getBottomright().isEmpty();}
            default:return true;
        }
    }

    private void resolveScore() {
        if(completedFirstRow(X))
            increasePlayer1Score();
        else if(completedSecondRow(X))
            increasePlayer1Score();
        else if(completedThirdRow(X))
            increasePlayer1Score();
        else if(completedFirstColumn(X))
            increasePlayer1Score();
        else if(completedSecondColumn(X))
            increasePlayer1Score();
        else if(completedThirdColumn(X))
            increasePlayer1Score();
        else if(completedFirstDiagonal(X))
            increasePlayer1Score();
        else if(completedSecondDiagonal(X))
            increasePlayer1Score();
        else if(completedFirstRow(O))
            increasePlayer2Score();
        else if(completedSecondRow(O))
            increasePlayer2Score();
        else if(completedThirdRow(O))
            increasePlayer2Score();
        else if(completedFirstColumn(O))
            increasePlayer2Score();
        else if(completedSecondColumn(O))
            increasePlayer2Score();
        else if(completedThirdColumn(O))
            increasePlayer2Score();
        else if(completedFirstDiagonal(O))
            increasePlayer2Score();
        else if(completedSecondDiagonal(O))
            increasePlayer2Score();
    }

    private boolean completedSecondDiagonal(String symbol) {
        return gameBoard.getTopright().equals(symbol) &&
                gameBoard.getMiddle().equals(symbol) &&
                gameBoard.getBottomleft().equals(symbol);
    }

    private boolean completedFirstDiagonal(String symbol) {
        return gameBoard.getTopleft().equals(symbol) &&
                gameBoard.getMiddle().equals(symbol) &&
                gameBoard.getBottomright().equals(symbol);
    }

    private boolean completedThirdColumn(String symbol) {
        return gameBoard.getTopright().equals(symbol) &&
                gameBoard.getRight().equals(symbol) &&
                gameBoard.getBottomright().equals(symbol);
    }

    private boolean completedSecondColumn(String symbol) {
        return gameBoard.getTop().equals(symbol) &&
                gameBoard.getMiddle().equals(symbol) &&
                gameBoard.getBottom().equals(symbol);
    }

    private boolean completedFirstColumn(String symbol) {
        return gameBoard.getTopleft().equals(symbol) &&
                gameBoard.getLeft().equals(symbol) &&
                gameBoard.getBottomleft().equals(symbol);
    }

    private boolean completedThirdRow(String symbol) {
        return gameBoard.getBottomleft().equals(symbol) &&
                gameBoard.getBottom().equals(symbol) &&
                gameBoard.getBottomright().equals(symbol);
    }

    private boolean completedFirstRow(String symbol) {
        return gameBoard.getTopleft().equals(symbol) &&
        gameBoard.getTop().equals(symbol) &&
        gameBoard.getTopright().equals(symbol);
    }

    private boolean completedSecondRow(String symbol) {
        return gameBoard.getLeft().equals(symbol) &&
                gameBoard.getMiddle().equals(symbol) &&
                gameBoard.getRight().equals(symbol);
    }

    private void empty(GameBoard gameBoard) {
        gameBoard.setTopleft(EMPTY);
        gameBoard.setTopright(EMPTY);
        gameBoard.setTop(EMPTY);
        gameBoard.setLeft(EMPTY);
        gameBoard.setMiddle(EMPTY);
        gameBoard.setRight(EMPTY);
        gameBoard.setBottomleft(EMPTY);
        gameBoard.setBottom(EMPTY);
        gameBoard.setBottomright(EMPTY);
    }

    private boolean isFull(GameBoard gameBoard) {
        return !gameBoard.getTopleft().isEmpty() &&
               !gameBoard.getTop().isEmpty() &&
               !gameBoard.getTopright().isEmpty() &&
               !gameBoard.getLeft().isEmpty() &&
               !gameBoard.getMiddle().isEmpty() &&
               !gameBoard.getRight().isEmpty() &&
               !gameBoard.getBottomleft().isEmpty() &&
               !gameBoard.getBottom().isEmpty() &&
               !gameBoard.getBottomright().isEmpty();
    }

    private void resolvePosition(String position) {
        switch (position) {
            case "topleft": {gameBoard.setTopleft(resolveSymbol());}break;
            case "topright": {gameBoard.setTopright(resolveSymbol());}break;
            case "top": {gameBoard.setTop(resolveSymbol());}break;
            case "left": {gameBoard.setLeft(resolveSymbol());}break;
            case "middle": {gameBoard.setMiddle(resolveSymbol());}break;
            case "right": {gameBoard.setRight(resolveSymbol());}break;
            case "bottomleft": {gameBoard.setBottomleft(resolveSymbol());}break;
            case "bottom": {gameBoard.setBottom(resolveSymbol());}break;
            case "bottomright": {gameBoard.setBottomright(resolveSymbol());}break;
        }
    }

    private String resolveSymbol() {
        String output = currentSymbol;
        if (currentSymbol.equals("x"))
            currentSymbol = "o";
        else
            currentSymbol = "x";
        return output;
    }

    private void increasePlayer1Score() {
        gameBoard.setPlayer1((valueOf(gameBoard.getPlayer1()) + 1) + EMPTY);
    }

    private void increasePlayer2Score() {
        gameBoard.setPlayer2((valueOf(gameBoard.getPlayer2()) + 1) + EMPTY);
    }
}
