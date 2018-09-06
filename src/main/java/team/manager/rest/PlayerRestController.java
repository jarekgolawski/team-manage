package team.manager.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.manager.entity.Player;

import team.manager.service.PlayerService;

@RestController
@RequestMapping("/api")
public class PlayerRestController {

	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/players")
	public List<Player> getPlayers() {
		return playerService.getPlayers();
	}
	
	@GetMapping("/players/{playerId}")
	public Player getPlayer(@PathVariable int playerId) {
		Player thePlayer = playerService.getPlayer(playerId);
		
		if (thePlayer==null) {
			throw new PlayerNotFoundException("Player is not found - " + playerId);
		}
		return thePlayer;
	}
	
	@PostMapping("/players")
	public Player addPlayer(@RequestBody Player thePlayer) {
		thePlayer.setId(0);
		playerService.savePlayer(thePlayer);
		return thePlayer;
	}
	
	@PutMapping("/players")
	public Player updatePlayer(@RequestBody Player thePlayer) {
		playerService.savePlayer(thePlayer);
		return thePlayer;
	}
	
	@DeleteMapping("/players/{playerId}")
	public String deletePlayer(@PathVariable int playerId) {
		Player tempPlayer = playerService.getPlayer(playerId);
		playerService.deletePlayer(playerId);
		
		if (tempPlayer==null) {
			throw new PlayerNotFoundException("Player is not found: " + playerId);
		}
		return "Deleted Player id - " + playerId;
	}
}
