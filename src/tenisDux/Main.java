package tenisDux;

import java.util.Random;
import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;

import models.Player;
import models.Tournament;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Tournament tournament = new Tournament();
		String badn = "y";
		play(tournament);
		System.out.print("Rematch? (y/n): ");
		badn = sc.nextLine().toUpperCase();
		if(badn.equals("Y")) {
			play(tournament);
		}else {
			System.out.println("______________________________________________________ \n");
			System.out.println("  FINALIZED \n");
			System.out.println("______________________________________________________ \n");
		}
		
	}
	
	public static void play(Tournament tournament) {
		Player player1 = new Player();
		Player player2 = new Player();
		loadData(tournament);
		player1 = tournament.setPlayer(0);
		player2 = tournament.setPlayer(1);
		try {
			for (int i = 0; i < tournament.getSets(); i++) {
				do {
					take(tournament);
					do {
						points(tournament);
						Thread.sleep(1000);
					} while (player1.getPoints() <= 2 && player2.getPoints() <= 2);
					games(tournament);
				} while (player1.getGame() <= 5 && player2.getGame() <= 5);
				player1.addGames(player1.getGame());
				player2.addGames(player2.getGame());
				sets(tournament);
			}
			showWinner(tournament);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void loadData(Tournament tournament) {
		Scanner sc = new Scanner(System.in);
		Player player = new Player();
		System.out.println("______________________________________________________ \n");
		System.out.print("Enter tournament name: ");
		tournament.setName(sc.nextLine());
		do {
			System.out.print("Define the number of sets to win (3 o 5): ");
			tournament.setSets(sc.nextInt());
		} while (tournament.getSets() != 3 && tournament.getSets() != 5);
		System.out.print("Player 1 \n ");
		loadPlayer(tournament, 1);
		System.out.print("Player 2 \n ");
		loadPlayer(tournament, 2);
		System.out.println("______________________________________________________ \n");
	}

	public static void loadPlayer(Tournament tournament, int jugador) {
		Scanner sc = new Scanner(System.in);
		Player player = new Player();
		Player player1 = new Player();
		System.out.println("______________________________________________________ \n");
		System.out.print("Enter name: ");
		player.setNombre(sc.nextLine());
		if (jugador == 1) {
			System.out.print("Enter probability of winning (1 to 100): ");
			player.setProbability(sc.nextInt());
		} else {
			player1 = tournament.setPlayer(0);
			System.out.print("Probability of winning: " + (100 - player1.getProbability()) + "\n");
		}
		player.setServes(numberRandom());
		tournament.addPlayer(player);
	}

	public static int numberRandom() {
		Random num = new Random();
		return num.nextInt(2);
	}

	public static void take(Tournament tournament) {
		Player player1 = new Player();
		Player player2 = new Player();
		player1 = tournament.setPlayer(0);
		player2 = tournament.setPlayer(1);
		System.out.println("______________________________________________________ \n");
		if (player1.getServes() == 1) {
			System.out.print("Take Out " + player1.getNombre() + "\n");
			player1.setServes(0);
			player2.setServes(1);
		} else {
			System.out.print("Take Out " + player2.getNombre() + "\n");
			player1.setServes(1);
			player2.setServes(0);
		}
		System.out.println("______________________________________________________ \n");
	}

	public static void points(Tournament tournament) {
		int random = numberRandom();
		Player player = new Player();
		if (random == 0) {
			player = tournament.setPlayer(0);
			player.setPoints(player.getPoints() + 1);
		} else {
			player = tournament.setPlayer(1);
			player.setPoints(player.getPoints() + 1);
		}
		showPartialResult(tournament);
	}

	public static void games(Tournament tournament) {
		Player player1 = new Player();
		Player player2 = new Player();
		player1 = tournament.setPlayer(0);
		player2 = tournament.setPlayer(1);

		if (player1.getPoints() == 3) {
			player1.setGame(player1.getGame() + 1);
		} else {
			player2.setGame(player2.getGame() + 1);
		}
		player1.setPoints(0);
		player2.setPoints(0);
		showPartialResult(tournament);
	}

	public static void sets(Tournament tournament) {
		Player player1 = new Player();
		Player player2 = new Player();
		player1 = tournament.setPlayer(0);
		player2 = tournament.setPlayer(1);

		if (player1.getGame() == 6) {
			player1.setSets(player1.getSets() + 1);
		} else {
			player2.setSets(player2.getSets() + 1);
		}
		player1.setPoints(0);
		player2.setPoints(0);
		player1.setGame(0);
		player2.setGame(0);
		showPartialResult(tournament);
	}

	public static void showPartialResult(Tournament tournament) {
		Player player1 = new Player();
		Player player2 = new Player();
		player1 = tournament.setPlayer(0);
		player2 = tournament.setPlayer(1);

		System.out.println("______________________________________________________ \n");
		System.out.print("Player		Sets 		Games		Point  \n");
		System.out.print(player1.getNombre() + " 		" + player1.getSets() + " 		" + player1.getGame()
				+ " 		" + table(player1.getPoints()) + "\n");
		System.out.print(player2.getNombre() + " 		" + player2.getSets() + " 		" + player2.getGame()
				+ " 		" + table(player2.getPoints()) + "\n");

	}

	public static void showWinner(Tournament tournament) {
		Player player1 = new Player();
		Player player2 = new Player();
		player1 = tournament.setPlayer(0);
		player2 = tournament.setPlayer(1);
		System.out.println("______________________________________________________ \n");
		System.out.println(tournament.getName().toUpperCase() + "  FINALIZED \n");
		System.out.println("______________________________________________________ \n");
		System.out.print("Player		Sets 		Games		 \n");
		if (player1.getSets() > player2.getSets()) {
			System.out.print(ANSI_GREEN + player1.getNombre() + " 		" + player1.getSets() + " 		"
					+ player1.getGames() + ANSI_RESET + "\n");
			System.out
					.print(player2.getNombre() + " 		" + player2.getSets() + " 		" + player2.getGames() + "\n");
		} else {
			System.out
					.print(player1.getNombre() + " 		" + player1.getSets() + " 		" + player1.getGames() + "\n");
			System.out.print(ANSI_GREEN + player2.getNombre() + " 		" + player2.getSets() + " 		"
					+ player2.getGames() + ANSI_RESET + "\n");
		}
	}

	public static int table(int punto) {
		switch (punto) {
		case 0:
			return 0;
		case 1:
			return 15;

		case 2:
			return 30;

		case 3:
			return 40;

		default:
			return 0;
		}
	}

	public static final String ANSI_GREEN = "\u001B[32m";

	public static final String ANSI_RESET = "\u001B[0m";

}
