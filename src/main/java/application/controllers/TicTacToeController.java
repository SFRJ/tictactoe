package application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TicTacToeController {

    @RequestMapping(value = {"/","tictactoe"}, method = RequestMethod.GET)
    public String welcomeToTicTacToe(Model model) {
        return "tictactoe";
    }
}
