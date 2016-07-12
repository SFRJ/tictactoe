package application.services;

import application.model.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.lineSeparator;

@Component
public class GameBoardService {

    private  Logger logger = LoggerFactory.getLogger(GameBoardService.class);

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
            logEndOfGame(currentGame);
            boardCleanup.empty(currentGame);
        }

        return currentGame;
    }

    private void logEndOfGame(GameBoard currentGame) {
        logger.info(currentGame.getGameId() + " ended " + lineSeparator() + "board:" + lineSeparator() +
                currentGame.getBottomleft() + currentGame.getTop() + currentGame.getTopright() + lineSeparator() +
                currentGame.getLeft() + currentGame.getMiddle() + currentGame.getRight() + lineSeparator() +
                currentGame.getBottomleft() + currentGame.getBottom() + currentGame.getBottomright());
    }
}
