package team.manager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team.manager.entity.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Team> getTeams() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Team> theQuery = currentSession.createQuery("from Team order by name",
								Team.class);
		List<Team> teams = theQuery.getResultList();
		return teams;
	}

	public void saveTeam(Team theTeam) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theTeam);
	}

	public Team getTeam(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Team theTeam = currentSession.get(Team.class, theId);
		return theTeam;
	}

	public void deleteTeam(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Team where id=TeamId");
		theQuery.setParameter("TeamId", theId);
		theQuery.executeUpdate();	
	}
}
