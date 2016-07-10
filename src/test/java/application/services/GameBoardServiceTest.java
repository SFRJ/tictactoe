package application.services;

import application.model.GameBoard;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameBoardServiceTest {

    private SymbolResolver symbolResolver = new SymbolResolver();
    private BoardCleanup boardCleanup = mock(BoardCleanup.class);
    private ScoreResolver scoreResolver = mock(ScoreResolver.class);
    private SelectionValidator selectionValidator = mock(SelectionValidator.class);
    private GameSessionManger gameSessionManger = mock(GameSessionManger.class);
    private GameBoardService gameBoardService = new GameBoardService(selectionValidator, scoreResolver, boardCleanup, symbolResolver, gameSessionManger);
    private GameBoard result;
    private GameBoard gameBoard;

    @Test
    public void updatesBoard() throws Exception {
        givenAUserPlays();
        givenTheSessionManagerIsCalled();
        givenTheSelectionValidationIsChecked();

        whenTheBoardIsUpdated();

        thenTheResultIsUpdated();
    }

    private void givenAUserPlays() {
        gameBoard = new GameBoard();
        gameBoard.setSelection("top");
    }

    private void whenTheBoardIsUpdated() {
        result = gameBoardService.updateBoard(gameBoard);
    }

    private void givenTheSessionManagerIsCalled() {
        when(gameSessionManger.getCurrentGame(any(GameBoard.class))).thenReturn(gameBoard);
    }

    private void givenTheSelectionValidationIsChecked() {
        when(selectionValidator.alreadySelected(any(GameBoard.class))).thenReturn(false);
    }

    private void thenTheResultIsUpdated() {
        assertThat(result.getTop()).isNotEmpty();
    }
}