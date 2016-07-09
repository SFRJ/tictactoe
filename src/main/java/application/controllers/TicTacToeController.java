package application.controllers;

import application.services.GameResolvingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.UUID;

import static java.util.UUID.randomUUID;
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
    public @ResponseBody ResponseEntity<String> play(HttpSession session, @RequestBody String selection) {
        createUserSession(session);
        String json = gameResolvingService.resolve(selection);
        return new ResponseEntity<>(json, OK);
    }

    private void createUserSession(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if(uid == null) {
            uid = randomUUID();
        }
        session.setAttribute("uid",uid);
    }

}
