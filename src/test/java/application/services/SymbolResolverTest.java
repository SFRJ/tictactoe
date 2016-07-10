package application.services;

import application.model.GameBoard;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SymbolResolverTest {

    private GameBoard gameBoard = new GameBoard();
    private SymbolResolver symbolResolver = new SymbolResolver();

    @Test
    public void resolvesGame() throws Exception {
        givenFirstPlayerPlays();
        whenSecondPlayerPlays();
        thenTheSymbolIsResolvedCorrectly();
    }

    private void givenFirstPlayerPlays() {
        gameBoard.setSelection("left");
        symbolResolver.resolvePosition(gameBoard);
    }

    private void whenSecondPlayerPlays() {
        gameBoard.setSelection("top");
        symbolResolver.resolvePosition(gameBoard);
    }

    private void thenTheSymbolIsResolvedCorrectly() {
        assertThat(gameBoard.getTop()).isEqualTo("o");
    }
}