package application.services;

import application.model.GameBoard;
import org.springframework.stereotype.Component;

@Component
public class SymbolResolver {

    public static final String X = "x";
    public static final String O = "o";
    private String currentSymbol = "x";

    public SymbolResolver() {
    }

    public void resolvePosition(GameBoard currentGame) {
        switch (currentGame.getSelection()) {
            case "topleft": {currentGame.setTopleft(resolveSymbol());}break;
            case "topright": {currentGame.setTopright(resolveSymbol());}break;
            case "top": {currentGame.setTop(resolveSymbol());}break;
            case "left": {currentGame.setLeft(resolveSymbol());}break;
            case "middle": {currentGame.setMiddle(resolveSymbol());}break;
            case "right": {currentGame.setRight(resolveSymbol());}break;
            case "bottomleft": {currentGame.setBottomleft(resolveSymbol());}break;
            case "bottom": {currentGame.setBottom(resolveSymbol());}break;
            case "bottomright": {currentGame.setBottomright(resolveSymbol());}break;
        }
    }

    private String resolveSymbol() {
        String output = currentSymbol;
        if (currentSymbol.equals(X))
            currentSymbol = O;
        else
            currentSymbol = X;
        return output;
    }
}
