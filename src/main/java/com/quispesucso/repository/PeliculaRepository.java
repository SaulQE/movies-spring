package com.quispesucso.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quispesucso.entity.Pelicula;


public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>
{
	@Query("SELECT SUM(p.dur_minutos) FROM Pelicula p")
	public abstract Integer sumMinutos();
	
	@Query(value = "select s.sala_id, s.nombre, s.cant_butacas\r\n"
			+ "from peliculas_sala ps \r\n"
			+ "inner join peliculas p on ps.pelicula_id = p.pelicula_id \r\n"
			+ "inner join salas s on ps.sala_id = s.sala_id \r\n"
			+ "where p.pelicula_id=:param", nativeQuery = true)
	public abstract Collection<Object[]> peliculas_sala(@Param("param") Integer pelicula_id); 
}
