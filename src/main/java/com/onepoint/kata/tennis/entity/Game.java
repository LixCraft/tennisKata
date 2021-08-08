package com.onepoint.kata.tennis.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class Game {

    private Player playerOne;
    private Player playerTwo;
    private Integer scorePlayerOne;
    private Integer scorePlayerTwo;

    public Game() {
    }

    public Game(Player playerOne, Player playerTwo, Integer scorePlayerOne, Integer scorePlayerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scorePlayerOne = scorePlayerOne;
        this.scorePlayerTwo = scorePlayerTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return playerOne.equals(game.playerOne) && playerTwo.equals(game.playerTwo) && scorePlayerOne.equals(game.scorePlayerOne) && scorePlayerTwo.equals(game.scorePlayerTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerOne, playerTwo, scorePlayerOne, scorePlayerTwo);
    }

    @Override
    public String toString() {
        return "Game{" +
                "playerOne=" + playerOne +
                ", playerTwo=" + playerTwo +
                ", scorePlayerOne=" + scorePlayerOne +
                ", scorePlayerTwo=" + scorePlayerTwo +
                '}';
    }



}
