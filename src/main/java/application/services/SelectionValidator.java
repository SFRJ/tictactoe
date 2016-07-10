package application.services;

import application.model.GameBoard;
import org.springframework.stereotype.Component;

@Component
public class SelectionValidator {

    public SelectionValidator() {
    }

    public boolean alreadySelected(GameBoard currentGame) {
        switch (currentGame.getSelection()) {
            case "topleft": {return !currentGame.getTopleft().isEmpty();}
            case "topright": {return !currentGame.getTopright().isEmpty();}
            case "top": {return !currentGame.getTop().isEmpty();}
            case "left": {return !currentGame.getLeft().isEmpty();}
            case "middle": {return !currentGame.getMiddle().isEmpty();}
            case "right": {return !currentGame.getRight().isEmpty();}
            case "bottomleft": {return !currentGame.getBottomleft().isEmpty();}
            case "bottom": {return !currentGame.getBottom().isEmpty();}
            case "bottomright": {return !currentGame.getBottomright().isEmpty();}
            default:return true;
        }
    }
}
