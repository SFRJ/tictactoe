package application.controllers;

import application.model.GameBoard;
import application.services.GameResolvingService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

public class TicTacToeControllerTest {

    public static final String RESPONSE_JSON = "response json";
    private GameResolvingService gameResolvingService = mock(GameResolvingService.class);
    private TicTacToeController controller = new TicTacToeController(gameResolvingService);
    private String position;
    private ResponseEntity<String> responseFromController;

    @Test
    public void sendsBackJsonWithBoardStatus() throws Exception {
        givenUserSelectsPosition("top-left");
        whenControlerReceivesPosition();
        thenTheBoardHasThePossitionSelected();
    }

    //givens
    private void givenUserSelectsPosition(String position) {
        this.position = position;
        GameBoard gameBoard =  new GameBoard();
        gameBoard.setSelection("top-left");
        when(gameResolvingService.resolve(gameBoard)).thenReturn(RESPONSE_JSON);
    }

    //whens
    private void whenControlerReceivesPosition() {
        responseFromController = controller.play(mock(HttpSession.class),position);
    }

    //thens
    private void thenTheBoardHasThePossitionSelected() {
        assertThat(responseFromController.getStatusCode()).isEqualTo(OK);
        assertThat(responseFromController.getBody()).isEqualTo(RESPONSE_JSON);
    }
}