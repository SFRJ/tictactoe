package application.controllers;

import application.model.GameBoard;
import application.services.GameResolvingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
public class TicTacToeController {

    private GameResolvingService gameResolvingService;

    public TicTacToeController() {
    }

    @Autowired
    public TicTacToeController(GameResolvingService gameResolvingService) {
        this.gameResolvingService = gameResolvingService;
    }


    @RequestMapping(value = {"/","tictactoe"}, method = RequestMethod.GET)
    public String welcomeToTicTacToe() {
        return "tictactoe";
    }

    @RequestMapping(value = {"play"}, consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> play(HttpSession httpSession, @RequestBody String selection) {
        String json = gameResolvingService.resolve(game(httpSession.getId(),selection));
        return new ResponseEntity<>(json, OK);
    }

    private GameBoard game(String gameId, String selection) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.setGameId(gameId);
        gameBoard.setSelection(selection);
        return gameBoard;
    }

}
