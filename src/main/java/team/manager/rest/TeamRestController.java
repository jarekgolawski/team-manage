package team.manager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.manager.entity.Team;

import team.manager.service.TeamService;

@RestController
@RequestMapping("/api")
public class TeamRestController {

	
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/teams")
	public List<Team> getTeams() {
		return teamService.getTeams();
	}
	
	@GetMapping("/teams/{teamId}")
	public Team getTeam(@PathVariable int teamId) {
		Team theTeam = teamService.getTeam(teamId);
		
		if (theTeam==null) {
			throw new TeamNotFoundException("Team is not found - " + teamId);
		}
		return theTeam;
	}
	
	@PostMapping("/teams")
	public Team addTeam(@RequestBody Team theTeam) {
		theTeam.setId(0);
		teamService.saveTeam(theTeam);
		return theTeam;
	}
	
	@PutMapping("/teams")
	public Team updateTeam(@RequestBody Team theTeam) {
		teamService.saveTeam(theTeam);
		return theTeam;
	}
	
	@DeleteMapping("/teams/{teamId}")
	public String deleteTeam(@PathVariable int teamId) {
		Team tempTeam = teamService.getTeam(teamId);
		teamService.deleteTeam(teamId);
		
		if (tempTeam==null) {
			throw new TeamNotFoundException("Team is not found: " + teamId);
		}
		return "Deleted Team id - " + teamId;
	}
}
