package team.manager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.manager.entity.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Player> getPlayers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Player> theQuery = currentSession.createQuery("from Player order by lastName",
								Player.class);
		List<Player> players = theQuery.getResultList();
		return players;
	}

	@Override
	public void savePlayer(Player thePlayer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thePlayer);
	}

	@Override
	public Player getPlayer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Player thePlayer = currentSession.get(Player.class, theId);
		return thePlayer;
	}

	@Override
	public void deletePlayer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Player where id=PlayerId");
		theQuery.setParameter("PlayerId", theId);
		theQuery.executeUpdate();	
	}

}
