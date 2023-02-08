package models;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	String nombre;
	Integer probability;
	Integer points;
	List<Integer> games;
	Integer game;
	Integer sets;
	Integer serves;
	//private boolean winner;
	
	public Player() {
		games = new ArrayList<>();
		setNombre("");
		setProbability(0);
		setPoints(0);
		setGame(0);
		setSets(0);
		setServes(0);
		//setWinner(false);
	}
	
	public void addGames(Integer num) {
		games.add(num);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getProbability() {
		return probability;
	}
	
	public void setProbability(Integer probability) {
		this.probability = probability;
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public Integer getServes() {
		return serves;
	}

	public void setServes(Integer serves) {
		this.serves = serves;
	}

	public List<Integer> getGames() {
		return games;
	}
	
	public void setGames(List<Integer> games) {
		this.games = games;
	}
	
	public Integer getSets() {
		return sets;
	}
	
	public void setSets(Integer sets) {
		this.sets = sets;
	}

	public Integer getGame() {
		return game;
	}

	public void setGame(Integer game) {
		this.game = game;
	}
	
	
	
}
