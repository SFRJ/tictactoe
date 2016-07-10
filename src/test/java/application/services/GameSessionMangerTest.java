package application.services;

import application.model.GameBoard;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class GameSessionMangerTest {

    private SessionCleaner sessionCleaner = mock(SessionCleaner.class);
    private GameSessionManger gameSessionManger = new GameSessionManger(sessionCleaner);
    private GameBoard currentGame;

    @Test
    public void returnsTheCorrectGame() throws Exception {
        givenMultipleGames();
        whenAskedForAParticularGame();
        thenTheRightGameIsReturned();
    }

    private void givenMultipleGames() {
        for (int gameId = 0; gameId < 3; gameId++) {
            GameBoard gameBoard = new GameBoard();
            gameBoard.setGameId(gameId + "");
            gameSessionManger.getCurrentGame(gameBoard);
        }
    }

    private void whenAskedForAParticularGame() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.setGameId("1");
        currentGame = gameSessionManger.getCurrentGame(gameBoard);
    }

    private void thenTheRightGameIsReturned() {
        assertThat(currentGame.getGameId()).isEqualTo("1");
    }
}