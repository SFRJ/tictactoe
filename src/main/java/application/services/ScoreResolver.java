package application.services;

import application.model.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.Integer.valueOf;

@Component
public class ScoreResolver {

    public static final String X = "x";
    public static final String O = "o";
    public static final String EMPTY = "";
    
    private CombinationsValidator combinationsValidator;

    public ScoreResolver() {
    }

    @Autowired
    public ScoreResolver(CombinationsValidator combinationsValidator) {
        this.combinationsValidator = combinationsValidator;
    }

    public boolean winnerFound(GameBoard currentGame) {
        boolean thereIsAWinner = false;
        if(combinationsValidator.completedFirstRow(currentGame, X)) {
            increasePlayer1Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedSecondRow(currentGame, X)) {
            increasePlayer1Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedThirdRow(currentGame, X)) {
            increasePlayer1Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedFirstColumn(currentGame, X)) {
            increasePlayer1Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedSecondColumn(currentGame, X)) {
            increasePlayer1Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedThirdColumn(currentGame, X)) {
            increasePlayer1Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedFirstDiagonal(currentGame, X)) {
            increasePlayer1Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedSecondDiagonal(currentGame, X)) {
            increasePlayer1Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedFirstRow(currentGame, O)) {
            increasePlayer2Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedSecondRow(currentGame, O)) {
            increasePlayer2Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedThirdRow(currentGame, O)) {
            increasePlayer2Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedFirstColumn(currentGame, O)) {
            increasePlayer2Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedSecondColumn(currentGame, O)) {
            increasePlayer2Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedThirdColumn(currentGame, O)) {
            increasePlayer2Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedFirstDiagonal(currentGame, O)) {
            increasePlayer2Score(currentGame);
            thereIsAWinner = true;
        }
        else if(combinationsValidator.completedSecondDiagonal(currentGame, O)) {
            increasePlayer2Score(currentGame);
            thereIsAWinner = true;
        }
        return thereIsAWinner;
    }

    private void increasePlayer1Score(GameBoard currentGame) {
        currentGame.setPlayer1((valueOf(currentGame.getPlayer1()) + 1) + EMPTY);
    }

    private void increasePlayer2Score(GameBoard currentGame) {
        currentGame.setPlayer2((valueOf(currentGame.getPlayer2()) + 1) + EMPTY);
    }
}
