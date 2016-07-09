package application.services;

import application.model.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameResolvingService {

    private GameBoardService gameBoardService;
    private ModelToJsonConversionService modelToJsonConversionService;

    @Autowired
    public GameResolvingService(GameBoardService gameBoardService, ModelToJsonConversionService modelToJsonConversionService) {
        this.gameBoardService = gameBoardService;
        this.modelToJsonConversionService = modelToJsonConversionService;
    }

    public String resolve(GameBoard game) {
        return modelToJsonConversionService
                .convertToJson(gameBoardService.updateBoard(game));
    }
}
