package co.edu.icesi.mio.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.mio.model.Tmio1Servicio;
import co.edu.icesi.mio.model.Tmio1ServicioPK;

@Repository
@Scope("singleton")
public class Tmio1_Servicios_DAO implements ITmio1_Servicios_DAO {

	// adicionales
	@Override
	public List<Tmio1Servicio> findByRangeOfDates(EntityManager em, Calendar fechaInicio, Calendar fechaFin) {

		String jpql = "Select a from Tmio1Servicio a WHERE (a.id.fechaInicio BETWEEN ?1 AND ?2)"
				+ " AND (a.id.fechaFin BETWEEN ?1 AND ?2)";
		Query q = em.createQuery(jpql);
		q.setParameter(1, fechaInicio.getTime(), TemporalType.DATE);
		q.setParameter(2, fechaFin.getTime(), TemporalType.DATE);
		return q.getResultList();
	}

	@Override
	public List<Tmio1Servicio> findByCollitionDates(EntityManager em, Calendar fechaInicio, Calendar fechaFin) {

		String jpql = "Select a from Tmio1Servicio a WHERE (a.id.fechaInicio BETWEEN ?1 AND ?2)"
				+ " OR (a.id.fechaFin BETWEEN ?1 AND ?2)";
		Query q = em.createQuery(jpql);
		q.setParameter(1, fechaInicio.getTime(), TemporalType.DATE);
		q.setParameter(2, fechaFin.getTime(), TemporalType.DATE);
		return q.getResultList();
	}
	
	@Override
	public List<Tmio1Servicio> servicesSaturdaysAndSundaysOrJustSundays(EntityManager em) {
		BigDecimal saturday = new BigDecimal(6);
		BigDecimal sunday = new BigDecimal(7);
		String jpql = "Select s from Tmio1Servicio s Where (s.tmio1Ruta.diaInicio =" + saturday
				+ "AND s.tmio1Ruta.diaFin = " + sunday + ") or (s.tmio1Ruta.diaInicio =" + sunday
				+ "AND s.tmio1Ruta.diaFin = " + sunday + ")";
		return em.createQuery(jpql).getResultList();
	}

	// normales
	@Override
	public void save(EntityManager em, Tmio1Servicio servicio) {
		em.persist(servicio);
	}

	@Override
	public void update(EntityManager em, Tmio1Servicio servicio) {
		em.merge(servicio);
	}

	@Override
	public void delete(EntityManager em, Tmio1Servicio servicio) {
		em.remove(em.contains(servicio) ? servicio : em.merge(servicio));
	}

	@Override
	public List<Tmio1Servicio> findAll(EntityManager em) {
		String jpql = "Select s from Tmio1Servicio s";
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public Tmio1Servicio findById(EntityManager em, Tmio1ServicioPK id) {
		return em.find(Tmio1Servicio.class, id);
	}
}
