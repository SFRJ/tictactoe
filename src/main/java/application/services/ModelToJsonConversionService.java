package application.services;

import application.model.GameBoard;
import org.springframework.stereotype.Component;

import static com.cedarsoftware.util.io.JsonWriter.formatJson;
import static com.cedarsoftware.util.io.JsonWriter.objectToJson;
import static java.lang.System.lineSeparator;

@Component
public class ModelToJsonConversionService {

    public ModelToJsonConversionService() {
    }

    public String convertToJson(GameBoard gameBoard) {
        return stripClassType(formatJson(objectToJson(gameBoard)));
    }

    private String stripClassType(String json) {
        String obJectTypeInformation = "\"@.*\",";
        return json.replaceAll(obJectTypeInformation,"")
                .replaceFirst(lineSeparator(),"")
                .replaceFirst(" ","")
                .replaceFirst(" ","");
    }
}
