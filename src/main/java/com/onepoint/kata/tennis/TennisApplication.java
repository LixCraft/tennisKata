package com.onepoint.kata.tennis;

import com.onepoint.kata.tennis.entity.Game;
import com.onepoint.kata.tennis.entity.Player;
import com.onepoint.kata.tennis.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TennisApplication implements CommandLineRunner {
	private static Logger LOG = LoggerFactory
			.getLogger(TennisApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TennisApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");

		Scanner in = new Scanner(System.in);
		Player playerOne = new Player();
		Player playerTwo = new Player();

		System.out.println("Tennis match begins.");
		System.out.println("Enter first name of player 1 :");
		playerOne.setFirtName(in.next());
		System.out.println("Enter last name of player 1 :");
		playerOne.setLastName(in.next());
		System.out.println("Enter first name of player 2 :");
		playerTwo.setFirtName(in.next());
		System.out.println("Enter last name of player 2 :");
		playerTwo.setLastName(in.next());
		Game game = new Game(playerOne, playerTwo, 0,0);
		System.out.println(playerOne.displayShortIdentityPlayer() + " " + playerTwo.displayShortIdentityPlayer());
		System.out.println(GameService.calculate(game));

		String display = GameService.calculate(game);
		while (!display.contains("win the game")){
			System.out.println("Point win by " + game.getPlayerOne().displayShortIdentityPlayer() + "(Enter '1') or by " + game.getPlayerTwo().displayShortIdentityPlayer() + "(Enter '2') ?");
			String value = in.next();
			if("1".equals(value)) {
				game.setScorePlayerOne(game.getScorePlayerOne() +1);
				display = GameService.calculate(game);
				System.out.println(display);
			} else if ("2".equals(value)){
				game.setScorePlayerTwo(game.getScorePlayerTwo() +1);
				display = GameService.calculate(game);
				System.out.println(display);
			} else {
				System.out.println("(Response error)");
			}
		}
	}
}
