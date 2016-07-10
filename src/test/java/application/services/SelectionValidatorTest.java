package application.services;

import application.model.GameBoard;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectionValidatorTest {

    public static final String EMPTY = "";
    public static final String X = "x";
    private GameBoard gameBoard = new GameBoard();
    private final String TOPLEFT = EMPTY;

    private SelectionValidator selectionValidator = new SelectionValidator();
    private boolean validationResult;

    @Test
    public void cantSelectAnAlreadySelectedPosition() throws Exception {
        givenPlayerAlreadySelectedAPosition();
        whenTheAPlayerSelectsTheSamePosition();
        thenItIsAlreadySelected();
    }

    @Test
    public void canSelectAPositionThatWasNeverSelected() throws Exception {
        givenPlayerSelectsAPossitionThatWasNeverSelected();
        whenThePossitionIsChecked();
        thenItIsAlreadySelected();
    }

    //givens
    private void givenPlayerAlreadySelectedAPosition() {
        gameBoard.setTopleft(X);
    }

    private void givenPlayerSelectsAPossitionThatWasNeverSelected() {
        gameBoard.setSelection(TOPLEFT);
    }

    //whens
    private void whenTheAPlayerSelectsTheSamePosition() {
        gameBoard.setSelection(TOPLEFT);
        validationResult = selectionValidator.alreadySelected(gameBoard);
    }

    private void whenThePossitionIsChecked() {
        validationResult = selectionValidator.alreadySelected(gameBoard);
    }

    //thens
    private void thenItIsAlreadySelected() {
        assertThat(validationResult).isTrue();
    }

    private void thenThePlayerIsAllowdToSelectThatPossition() {
        assertThat(validationResult).isFalse();
    }

}