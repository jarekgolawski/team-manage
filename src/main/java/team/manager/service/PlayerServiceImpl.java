package team.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.manager.dao.PlayerDAO;
import team.manager.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDAO;

	@Override
	@Transactional
	public List<Player> getPlayers() {
		return playerDAO.getPlayers();
	}

	@Override
	@Transactional
	public void savePlayer(Player thePlayer) {
		playerDAO.savePlayer(thePlayer);
	}

	@Override
	@Transactional
	public Player getPlayer(int theId) {
		return playerDAO.getPlayer(theId);
	}

	@Override
	@Transactional
	public void deletePlayer(int theId) {
		playerDAO.deletePlayer(theId);
	}
	
	
}
