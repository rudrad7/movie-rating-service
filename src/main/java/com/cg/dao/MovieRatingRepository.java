package com.cg.dao;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.dto.MovieRating;

import jakarta.transaction.Transactional;

@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Integer>
{
	@Transactional
	@Modifying
	@Query("delete from MovieRating mr where mr.movieRating >= :mrt")
	void deleteMovie(@Param("mrt") int movRating);	
	
}