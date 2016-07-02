package application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class AppStatusController {

    public AppStatusController() {
    }

    @RequestMapping(value = "/status", produces = TEXT_PLAIN_VALUE)
    public ResponseEntity<String> probe() {
        return new ResponseEntity<String>("alive!", OK);
    }

}
