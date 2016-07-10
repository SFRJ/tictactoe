package application.services;

import application.model.GameBoard;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoreResolverTest {

    public static final GameBoard CURRENT_GAME = new GameBoard();
    private CombinationsValidator combinationsValidator = mock(CombinationsValidator.class);
    private ScoreResolver scoreResolver = new ScoreResolver(combinationsValidator);
    private boolean result;

    @Test
    public void winnerIsFound() throws Exception {
        givenAPlayerHasACombination();
        whenTheResolverIsCalled();
        thenTheWinnerIsFound();
    }

    @Test
    public void winnerIsNotFound() throws Exception {
        givenAPlayerDoesntHaveACombination();
        whenTheResolverIsCalled();
        thenTheWinnerIsNotFound();
    }

    //givens
    private void givenAPlayerHasACombination() {
        when(combinationsValidator.completedFirstColumn(any(),any())).thenReturn(true);
    }

    private void givenAPlayerDoesntHaveACombination() {
        when(combinationsValidator.completedFirstColumn(any(),any())).thenReturn(false);
    }

    private void whenTheResolverIsCalled() {
        result = scoreResolver.winnerFound(CURRENT_GAME);
    }

    private void thenTheWinnerIsFound() {
        assertThat(result).isTrue();
    }

    private void thenTheWinnerIsNotFound() {
        assertThat(result).isFalse();
    }
}