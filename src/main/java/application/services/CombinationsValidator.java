package application.services;

import application.model.GameBoard;
import org.springframework.stereotype.Component;

@Component
public class CombinationsValidator {

    public CombinationsValidator() {
    }

    public boolean completedSecondDiagonal(GameBoard currentGame, String symbol) {
        return currentGame.getTopright().equals(symbol) &&
                currentGame.getMiddle().equals(symbol) &&
                currentGame.getBottomleft().equals(symbol);
    }

    public boolean completedFirstDiagonal(GameBoard currentGame, String symbol) {
        return currentGame.getTopleft().equals(symbol) &&
                currentGame.getMiddle().equals(symbol) &&
                currentGame.getBottomright().equals(symbol);
    }

    public boolean completedThirdColumn(GameBoard currentGame, String symbol) {
        return currentGame.getTopright().equals(symbol) &&
                currentGame.getRight().equals(symbol) &&
                currentGame.getBottomright().equals(symbol);
    }

    public boolean completedSecondColumn(GameBoard currentGame, String symbol) {
        return currentGame.getTop().equals(symbol) &&
                currentGame.getMiddle().equals(symbol) &&
                currentGame.getBottom().equals(symbol);
    }

    public boolean completedFirstColumn(GameBoard currentGame, String symbol) {
        return currentGame.getTopleft().equals(symbol) &&
                currentGame.getLeft().equals(symbol) &&
                currentGame.getBottomleft().equals(symbol);
    }

    public boolean completedThirdRow(GameBoard currentGame,String symbol) {
        return currentGame.getBottomleft().equals(symbol) &&
                currentGame.getBottom().equals(symbol) &&
                currentGame.getBottomright().equals(symbol);
    }

    public boolean completedFirstRow(GameBoard currentGame, String symbol) {
        return currentGame.getTopleft().equals(symbol) &&
                currentGame.getTop().equals(symbol) &&
                currentGame.getTopright().equals(symbol);
    }

    public boolean completedSecondRow(GameBoard currentGame,String symbol) {
        return currentGame.getLeft().equals(symbol) &&
                currentGame.getMiddle().equals(symbol) &&
                currentGame.getRight().equals(symbol);
    }

}
