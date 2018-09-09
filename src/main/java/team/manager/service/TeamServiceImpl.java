package team.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import team.manager.dao.TeamDAO;
import team.manager.entity.Player;
import team.manager.entity.Team;

@Service
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamDAO teamDAO;

	@Override
	@Transactional
	public List<Team> getTeams() {
		return teamDAO.getTeams();
	}

	@Override
	@Transactional
	public void saveTeam(Team theTeam) {
		teamDAO.saveTeam(theTeam);
	}

	@Override
	@Transactional
	public Team getTeam(int theId) {
		return teamDAO.getTeam(theId);
	}

	@Override
	@Transactional
	public void deleteTeam(int theId) {
		teamDAO.deleteTeam(theId);
	}


}
