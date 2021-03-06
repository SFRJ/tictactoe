package application.model;

import java.io.Serializable;

public class GameBoard implements Serializable {

    private String gameId;
    private String selection;
    private String player1;
    private String player2;
    private String topleft;
    private String top;
    private String topright;
    private String left;
    private String middle;
    private String right;
    private String bottomleft;
    private String bottom;
    private String bottomright;

    public GameBoard() {
        this.player1 = "0";
        this.player2 = "0";
        this.topleft = "";
        this.top = "";
        this.topright = "";
        this.left = "";
        this.middle = "";
        this.right = "";
        this.bottomleft = "";
        this.bottom = "";
        this.bottomright = "";
    }

    public GameBoard(String gameId, String selection, String player1, String player2, String topleft, String top, String topright, String left, String middle, String right, String bottomleft, String bottom, String bottomright) {
        this.gameId = gameId;
        this.selection = selection;
        this.player1 = player1;
        this.player2 = player2;
        this.topleft = topleft;
        this.top = top;
        this.topright = topright;
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.bottomleft = bottomleft;
        this.bottom = bottom;
        this.bottomright = bottomright;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getTopleft() {
        return topleft;
    }

    public void setTopleft(String topleft) {
        this.topleft = topleft;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getTopright() {
        return topright;
    }

    public void setTopright(String topright) {
        this.topright = topright;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public String getBottomleft() {
        return bottomleft;
    }

    public void setBottomleft(String bottomleft) {
        this.bottomleft = bottomleft;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getBottomright() {
        return bottomright;
    }

    public void setBottomright(String bottomright) {
        this.bottomright = bottomright;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
}
