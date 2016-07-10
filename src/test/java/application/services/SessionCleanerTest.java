package application.services;

import application.model.GameBoard;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionCleanerTest {

    private Map<String, GameBoard> session = new HashMap<>();

    private CombinationsValidator combinationsValidator = mock(CombinationsValidator.class);
    private BoardCleanup boardCleanup = mock(BoardCleanup.class);
    private SessionCleaner sessionCleaner = new SessionCleaner(combinationsValidator,boardCleanup);

    @Test
    public void cleansFinishedGamesFromSession() throws Exception {
        givenAFinishedGameIsInTheSession();
        whenTheSessionIsCleaned();
        thenTheSessionNoLongerContainsThatGame();
    }

    private void givenAFinishedGameIsInTheSession() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.setGameId("1");
        gameBoard.setTopleft("x");
        gameBoard.setTop("x");
        gameBoard.setTopright("x");
        session.put(gameBoard.getGameId(),gameBoard);
        when(combinationsValidator.completedFirstRow(any(GameBoard.class),anyString())).thenReturn(true);
    }

    private void whenTheSessionIsCleaned() {
        sessionCleaner.cleanIfNeeded(session);
    }

    private void thenTheSessionNoLongerContainsThatGame() {
        assertThat(session.get("1")).isNull();
    }
}