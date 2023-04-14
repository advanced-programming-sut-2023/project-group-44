package model;

public class Turns {
    private User currentPlayer;
    private int passedTurns;
    private int totalTurns;

    public Turns(int totalTurns) {
        this.passedTurns = 0;
        this.totalTurns=totalTurns;
    }

    public User getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(User currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getPassedTurns() {
        return passedTurns;
    }

    public void setPassedTurns(int passedTurns) {
        this.passedTurns = passedTurns;
    }
}
