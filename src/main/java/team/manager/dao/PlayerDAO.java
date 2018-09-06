package team.manager.dao;

import java.util.List;

import team.manager.entity.Player;

public interface PlayerDAO {

	public List<Player> getPlayers();

	public void savePlayer(Player thePlayer);

	public Player getPlayer(int theId);

	public void deletePlayer(int theId);
}
