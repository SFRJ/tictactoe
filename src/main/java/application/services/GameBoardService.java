package application.services;

import application.model.GameBoard;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.valueOf;

@Component
public class GameBoardService {

    public static final String X = "x";
    public static final String O = "o";
    public static final String EMPTY = "";
    private String currentSymbol = "x";
    //TODO clean map everytime size reaches 100

    public GameBoardService() {
    }

    public GameBoard updateBoard(final GameBoard game) {
        GameBoard currentGame = games.get(game.getGameId());

        if(currentGame == null) {
            games.put(game.getGameId(), game);
        }

        currentGame = games.get(game.getGameId());
        currentGame.setSelection(game.getSelection());

        if(alreadySelected(currentGame)) {
            return currentGame;
        }
        resolvePosition(currentGame);
        resolveScore(currentGame);
        if(isFull(currentGame)) {
            empty(currentGame);
        }
        return currentGame;
    }

    public GameBoard updateBoard(String position) {
//        if(alreadySelected(position)) {
//            return gameBoard;
//        }
//        resolvePosition(position);
//        resolveScore();
//        if(isFull(gameBoard)) {
//            empty(gameBoard);
//        }
//        return gameBoard;
        return null;
    }

    private boolean alreadySelected(GameBoard currentGame) {
        switch (currentGame.getSelection()) {
            case "topleft": {return !currentGame.getTopleft().isEmpty();}
            case "topright": {return !currentGame.getTopright().isEmpty();}
            case "top": {return !currentGame.getTop().isEmpty();}
            case "left": {return !currentGame.getLeft().isEmpty();}
            case "middle": {return !currentGame.getMiddle().isEmpty();}
            case "right": {return !currentGame.getRight().isEmpty();}
            case "bottomleft": {return !currentGame.getBottomleft().isEmpty();}
            case "bottom": {return !currentGame.getBottom().isEmpty();}
            case "bottomright": {return !currentGame.getBottomright().isEmpty();}
            default:return true;
        }
    }

    private void resolveScore(GameBoard currentGame) {
        if(completedFirstRow(currentGame, X)) {
            increasePlayer1Score(currentGame);
            empty(currentGame);
        }
        else if(completedSecondRow(currentGame, X)) {
            increasePlayer1Score(currentGame);
            empty(currentGame);
        }
        else if(completedThirdRow(currentGame, X)) {
            increasePlayer1Score(currentGame);
            empty(currentGame);
        }
        else if(completedFirstColumn(currentGame, X)) {
            increasePlayer1Score(currentGame);
            empty(currentGame);
        }
        else if(completedSecondColumn(currentGame, X)) {
            increasePlayer1Score(currentGame);
            empty(currentGame);
        }
        else if(completedThirdColumn(currentGame, X)) {
            increasePlayer1Score(currentGame);
            empty(currentGame);
        }
        else if(completedFirstDiagonal(currentGame, X)) {
            increasePlayer1Score(currentGame);
            empty(currentGame);
        }
        else if(completedSecondDiagonal(currentGame, X)) {
            increasePlayer1Score(currentGame);
            empty(currentGame);
        }
        else if(completedFirstRow(currentGame, O)) {
            increasePlayer2Score(currentGame);
            empty(currentGame);
        }
        else if(completedSecondRow(currentGame, O)) {
            increasePlayer2Score(currentGame);
            empty(currentGame);
        }
        else if(completedThirdRow(currentGame, O)) {
            increasePlayer2Score(currentGame);
            empty(currentGame);
        }
        else if(completedFirstColumn(currentGame, O)) {
            increasePlayer2Score(currentGame);
            empty(currentGame);
        }
        else if(completedSecondColumn(currentGame, O)) {
            increasePlayer2Score(currentGame);
            empty(currentGame);
        }
        else if(completedThirdColumn(currentGame, O)) {
            increasePlayer2Score(currentGame);
            empty(currentGame);
        }
        else if(completedFirstDiagonal(currentGame, O)) {
            increasePlayer2Score(currentGame);
            empty(currentGame);
        }
        else if(completedSecondDiagonal(currentGame, O)) {
            increasePlayer2Score(currentGame);
            empty(currentGame);
        }
    }

    private boolean completedSecondDiagonal(GameBoard currentGame, String symbol) {
        return currentGame.getTopright().equals(symbol) &&
                currentGame.getMiddle().equals(symbol) &&
                currentGame.getBottomleft().equals(symbol);
    }

    private boolean completedFirstDiagonal(GameBoard currentGame, String symbol) {
        return currentGame.getTopleft().equals(symbol) &&
                currentGame.getMiddle().equals(symbol) &&
                currentGame.getBottomright().equals(symbol);
    }

    private boolean completedThirdColumn(GameBoard currentGame, String symbol) {
        return currentGame.getTopright().equals(symbol) &&
                currentGame.getRight().equals(symbol) &&
                currentGame.getBottomright().equals(symbol);
    }

    private boolean completedSecondColumn(GameBoard currentGame, String symbol) {
        return currentGame.getTop().equals(symbol) &&
                currentGame.getMiddle().equals(symbol) &&
                currentGame.getBottom().equals(symbol);
    }

    private boolean completedFirstColumn(GameBoard currentGame, String symbol) {
        return currentGame.getTopleft().equals(symbol) &&
                currentGame.getLeft().equals(symbol) &&
                currentGame.getBottomleft().equals(symbol);
    }

    private boolean completedThirdRow(GameBoard currentGame,String symbol) {
        return currentGame.getBottomleft().equals(symbol) &&
                currentGame.getBottom().equals(symbol) &&
                currentGame.getBottomright().equals(symbol);
    }

    private boolean completedFirstRow(GameBoard currentGame, String symbol) {
        return currentGame.getTopleft().equals(symbol) &&
        currentGame.getTop().equals(symbol) &&
        currentGame.getTopright().equals(symbol);
    }

    private boolean completedSecondRow(GameBoard currentGame,String symbol) {
        return currentGame.getLeft().equals(symbol) &&
                currentGame.getMiddle().equals(symbol) &&
                currentGame.getRight().equals(symbol);
    }

    private void empty(GameBoard currentGame) {
        currentGame.setTopleft(EMPTY);
        currentGame.setTopright(EMPTY);
        currentGame.setTop(EMPTY);
        currentGame.setLeft(EMPTY);
        currentGame.setMiddle(EMPTY);
        currentGame.setRight(EMPTY);
        currentGame.setBottomleft(EMPTY);
        currentGame.setBottom(EMPTY);
        currentGame.setBottomright(EMPTY);
    }

    private boolean isFull(GameBoard currentGame) {
        return !currentGame.getTopleft().isEmpty() &&
               !currentGame.getTop().isEmpty() &&
               !currentGame.getTopright().isEmpty() &&
               !currentGame.getLeft().isEmpty() &&
               !currentGame.getMiddle().isEmpty() &&
               !currentGame.getRight().isEmpty() &&
               !currentGame.getBottomleft().isEmpty() &&
               !currentGame.getBottom().isEmpty() &&
               !currentGame.getBottomright().isEmpty();
    }

    private void resolvePosition(GameBoard currentGame) {
        switch (currentGame.getSelection()) {
            case "topleft": {currentGame.setTopleft(resolveSymbol());}break;
            case "topright": {currentGame.setTopright(resolveSymbol());}break;
            case "top": {currentGame.setTop(resolveSymbol());}break;
            case "left": {currentGame.setLeft(resolveSymbol());}break;
            case "middle": {currentGame.setMiddle(resolveSymbol());}break;
            case "right": {currentGame.setRight(resolveSymbol());}break;
            case "bottomleft": {currentGame.setBottomleft(resolveSymbol());}break;
            case "bottom": {currentGame.setBottom(resolveSymbol());}break;
            case "bottomright": {currentGame.setBottomright(resolveSymbol());}break;
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

    private void increasePlayer1Score(GameBoard currentGame) {
        currentGame.setPlayer1((valueOf(currentGame.getPlayer1()) + 1) + EMPTY);
    }

    private void increasePlayer2Score(GameBoard currentGame) {
        currentGame.setPlayer2((valueOf(currentGame.getPlayer2()) + 1) + EMPTY);
    }

    private Map<String,GameBoard> games = new HashMap<>();
}
