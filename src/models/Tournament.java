package models;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
	String name;
	List<Player> players;
	Integer sets;
	
	public Tournament() {
		players = new ArrayList<>();
		setName("");
		setSets(3);
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public Player setPlayer(int num) {
		return players.get(num);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Integer getSets() {
		return sets;
	}

	public void setSets(Integer sets) {
		this.sets = sets;
	}
		
}
