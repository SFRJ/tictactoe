package application.services;

import application.model.GameBoard;
import org.springframework.stereotype.Component;

@Component
public class BoardCleanup {

    private final String EMPTY = "";

    public BoardCleanup() {
    }

    public void empty(GameBoard currentGame) {
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

    public boolean isFull(GameBoard currentGame) {
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
}
