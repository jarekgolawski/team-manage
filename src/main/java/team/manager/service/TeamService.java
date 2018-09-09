package team.manager.service;

import java.util.List;

import team.manager.entity.Team;

public interface TeamService {

	public List<Team> getTeams();

	public void saveTeam(Team theTeam);

	public Team getTeam(int theId);

	public void deleteTeam(int theId);
}
