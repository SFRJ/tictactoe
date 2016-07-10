package application.services;

import application.model.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameBoardService {

    private SelectionValidator selectionValidator;
    private ScoreResolver scoreResolver;
    private BoardCleanup boardCleanup;
    private SymbolResolver symbolResolver;
    private GameSessionManger gameSessionManger;


    public GameBoardService() {
    }


    @Autowired
    public GameBoardService(SelectionValidator selectionValidator, ScoreResolver scoreResolver, BoardCleanup boardCleanup, SymbolResolver symbolResolver, GameSessionManger gameSessionManger) {
        this.selectionValidator = selectionValidator;
        this.scoreResolver = scoreResolver;
        this.boardCleanup = boardCleanup;
        this.symbolResolver = symbolResolver;
        this.gameSessionManger = gameSessionManger;
    }


    public GameBoard updateBoard(final GameBoard game) {
        GameBoard currentGame = gameSessionManger.getCurrentGame(game);

        if(selectionValidator.alreadySelected(currentGame)) {
            return currentGame;
        }

        symbolResolver.resolvePosition(currentGame);

        if(scoreResolver.winnerFound(currentGame) || boardCleanup.isFull(currentGame)) {
            boardCleanup.empty(currentGame);
        }

        return currentGame;
    }
}
