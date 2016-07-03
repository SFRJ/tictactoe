package application.controllers;

import application.controllers.dtos.GameBoardDto;
import com.cedarsoftware.util.io.JsonWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import static com.cedarsoftware.util.io.JsonWriter.formatJson;
import static com.cedarsoftware.util.io.JsonWriter.objectToJson;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
public class TicTacToeController {

    @RequestMapping(value = {"/","tictactoe"}, method = RequestMethod.GET)
    public String welcomeToTicTacToe() {
        return "tictactoe";
    }

    @RequestMapping(value = {"play"}, consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> play(@RequestBody String selection) {
        GameBoardDto gameBoardDto = new GameBoardDto("1","2","x","o","x","o","x","o","x","o","x");
        String json = stripClassType(formatJson(objectToJson(gameBoardDto)));
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    private String stripClassType(String json) {
        String obJectTypeInformation = "\"@.*\",";
        return json.replaceAll(obJectTypeInformation,"");
    }

}
