package application.services;

import application.model.GameBoard;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameResolvingServiceTest {

    private GameBoardService gameBoardService = mock(GameBoardService.class);
    private ModelToJsonConversionService modelToJsonConversionService = mock(ModelToJsonConversionService.class);
    private GameResolvingService gameResolvingService = new GameResolvingService(gameBoardService, modelToJsonConversionService);

    @Test
    public void shouldResolveGameBoardToJson() throws Exception {
        givenTheGameBoardServiceReturnsAGameBoard();
        whenTheResolverIsCalled();
        thenTheConverterReceivesAGameBoard();
    }

    private void givenTheGameBoardServiceReturnsAGameBoard() {
        Mockito.when(gameBoardService.updateBoard(any(GameBoard.class))).thenReturn(new GameBoard());
    }

    private void whenTheResolverIsCalled() {
        gameResolvingService.resolve(new GameBoard());
    }

    private void thenTheConverterReceivesAGameBoard() {
        verify(modelToJsonConversionService).convertToJson(any(GameBoard.class));
    }
}