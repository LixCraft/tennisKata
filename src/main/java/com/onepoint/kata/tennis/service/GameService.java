package com.onepoint.kata.tennis.service;

import com.onepoint.kata.tennis.entity.Game;
import com.onepoint.kata.tennis.exception.TennisAppException;

public class GameService {


    private static final String[] defaults = new String[]{"0", "15", "30", "40"};
    private static final String WIN = "#playerName win the game";
    private static final String ADVANTAGE = "ADV";
    private static final String DEUCE = "DEUCE";

    private static final String PLAYERONE_NAME_VAR = "#playerOneName";
    private static final String PLAYERTWO_NAME_VAR = "#playerTwoName";
    private static final String PLAYERONE_SCORE_VAR = "#playerOneScore";
    private static final String PLAYERTWO_SCORE_VAR = "#playerTwoScore";
    private static final String SCORE_DISPLAY = PLAYERONE_NAME_VAR + " "
            + PLAYERONE_SCORE_VAR + " - " + PLAYERTWO_SCORE_VAR + " " + PLAYERTWO_NAME_VAR;

    public static String calculate(Game game) throws TennisAppException{
        validatorGameInfo(game);
        if(game.getScorePlayerOne() > 3 || game.getScorePlayerTwo() > 3){
            return winOrTie(game);
        } else {
            return displayScore(game.getPlayerOne().displayShortIdentityPlayer(), defaults[game.getScorePlayerOne()],
                    game.getPlayerTwo().displayShortIdentityPlayer(), defaults[game.getScorePlayerTwo()]);
        }
    }

    private static String winOrTie(Game game) throws TennisAppException {
        validatorGameInfo(game);
        if(Math.abs(game.getScorePlayerOne() - game.getScorePlayerTwo()) >= 2) return win(game);
        return tie(game);
    }

    private static String win(Game game) throws  TennisAppException{
        validatorGameInfo(game);
        if(game.getScorePlayerOne()>game.getScorePlayerTwo()) {
            return WIN.replace("#playerName", game.getPlayerOne().displayShortIdentityPlayer());
        } else {
            return WIN.replace("#playerName", game.getPlayerTwo().displayShortIdentityPlayer());
        }
    }

    private static String tie(Game game) throws TennisAppException {
        validatorGameInfo(game);
        if(game.getScorePlayerOne()>game.getScorePlayerTwo()){
            return displayScore(game.getPlayerOne().displayShortIdentityPlayer(), ADVANTAGE, game.getPlayerTwo().displayShortIdentityPlayer(), defaults[3]);
        } else if(game.getScorePlayerOne()< game.getScorePlayerTwo()) {
            return displayScore(game.getPlayerOne().displayShortIdentityPlayer(), defaults[3], game.getPlayerTwo().displayShortIdentityPlayer(), ADVANTAGE);
        } else {
            return displayScore(game.getPlayerOne().displayShortIdentityPlayer(), DEUCE, game.getPlayerTwo().displayShortIdentityPlayer(), DEUCE);
        }
    }

    private static String defaultScore(Integer playerOnePoint, Integer playerTwoPoint) {
        return defaults[playerOnePoint] + " - " + defaults[playerTwoPoint];
    }

    private static String displayScore(String playerOneName, String playerOneScore, String playerTwoName, String playerTwoScore){
            return SCORE_DISPLAY.replace(PLAYERONE_NAME_VAR, playerOneName)
                    .replace(PLAYERONE_SCORE_VAR, playerOneScore)
                    .replace(PLAYERTWO_NAME_VAR, playerTwoName)
                    .replace(PLAYERTWO_SCORE_VAR, playerTwoScore);
    }

    private static void validatorGameInfo(Game game) throws TennisAppException{
        if(game == null){
            throw new TennisAppException("Game object is null");
        } else {
            if(game.getPlayerOne() == null || game.getPlayerTwo() == null){
                throw new TennisAppException("Game information players missing : " + game.toString());
            }
        }
    }
}
