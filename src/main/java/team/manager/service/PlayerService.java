package team.manager.service;

import java.util.List;

import team.manager.entity.Player;

public interface PlayerService {

	public List<Player> getPlayers();

	public void savePlayer(Player thePlayer);

	public Player getPlayer(int theId);

	public void deletePlayer(int theId);
}
