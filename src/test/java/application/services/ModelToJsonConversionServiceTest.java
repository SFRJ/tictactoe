package application.services;

import application.model.GameBoard;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;


public class ModelToJsonConversionServiceTest {
    /*
    private String stripClassType(String json) {
        //stripClassType(formatJson(objectToJson(gameBoard)));
        String obJectTypeInformation = "\"@.*\",";
        return json.replaceAll(obJectTypeInformation,"");
    }
    */

    private GameBoard gameBoard;
    private ModelToJsonConversionService conversionService = new ModelToJsonConversionService();
    private String json;

    @Test
    public void shouldConvertObjcetToJson() throws Exception {
        givenAGameBoard();
        whenWeConvertToJson();
        thenItIsConvertedToJson();
    }

    private void givenAGameBoard() {
        gameBoard = new GameBoard("", "", "1","3","x","x","x","x","x","x","x","x","x");
    }

    private void whenWeConvertToJson() {
        json = conversionService.convertToJson(gameBoard);
    }

    private void thenItIsConvertedToJson() {
        assertThat(json).isEqualTo(
                "{" + lineSeparator() + "  \"player1\":\"1\"," + lineSeparator() +"  \"player2\":\"3\"," + lineSeparator() +"  \"topleft\":\"x\"," + lineSeparator() +"  \"top\":\"x\"," + lineSeparator() +"  \"topright\":\"x\"," + lineSeparator() +"  \"left\":\"x\"," + lineSeparator() +"  \"middle\":\"x\"," + lineSeparator() +"  \"right\":\"x\"," + lineSeparator() +"  \"bottomleft\":\"x\"," + lineSeparator() +"  \"bottom\":\"x\"," + lineSeparator() +"  \"bottomright\":\"x\"" + lineSeparator() +"}"
        );
    }
}