package application.services;

import application.model.GameBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GameSessionManger {

    private SessionCleaner sessionCleaner;
    private Map<String,GameBoard> games = new HashMap<>();

    public GameSessionManger() {
    }

    @Autowired
    public GameSessionManger(SessionCleaner sessionCleaner) {
        this.sessionCleaner = sessionCleaner;
    }

    public GameBoard getCurrentGame(GameBoard game) {
        sessionCleaner.cleanIfNeeded(games);
        GameBoard currentGame = games.get(game.getGameId());

        if(currentGame == null) {
            games.put(game.getGameId(), game);
        }

        currentGame = games.get(game.getGameId());
        currentGame.setSelection(game.getSelection());

        return currentGame;
    }
}
