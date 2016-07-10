package application.services;

import application.model.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SessionCleaner {

    public static final String X = "x";
    public static final String O = "o";
    private CombinationsValidator combinationsValidator;
    private BoardCleanup boardCleanup;

    public SessionCleaner() {
    }

    @Autowired
    public SessionCleaner(CombinationsValidator combinationsValidator, BoardCleanup boardCleanup) {
        this.combinationsValidator = combinationsValidator;
        this.boardCleanup = boardCleanup;
    }

    public void cleanIfNeeded(Map<String, GameBoard> games) {
        for (Map.Entry<String, GameBoard> entry : games.entrySet()) {
            boolean isGameOver = isGameOver(entry.getValue());
            if (isGameOver)
                games.remove(entry.getValue().getGameId());
        }
    }

    private boolean isGameOver(GameBoard gameBoard) {
        return
                combinationsValidator.completedFirstRow(gameBoard, X) ||
                        combinationsValidator.completedSecondRow(gameBoard, X) ||
                        combinationsValidator.completedThirdRow(gameBoard, X) ||
                        combinationsValidator.completedFirstColumn(gameBoard, X) ||
                        combinationsValidator.completedSecondRow(gameBoard, X) ||
                        combinationsValidator.completedThirdColumn(gameBoard, X) ||
                        combinationsValidator.completedFirstDiagonal(gameBoard, X) ||
                        combinationsValidator.completedSecondDiagonal(gameBoard, X) ||

                        combinationsValidator.completedFirstRow(gameBoard, O) ||
                        combinationsValidator.completedSecondRow(gameBoard, O) ||
                        combinationsValidator.completedThirdRow(gameBoard, O) ||
                        combinationsValidator.completedFirstColumn(gameBoard, O) ||
                        combinationsValidator.completedSecondRow(gameBoard, O) ||
                        combinationsValidator.completedThirdColumn(gameBoard, O) ||
                        combinationsValidator.completedFirstDiagonal(gameBoard, O) ||
                        combinationsValidator.completedSecondDiagonal(gameBoard, O) ||

                        boardCleanup.isFull(gameBoard);
    }
}
