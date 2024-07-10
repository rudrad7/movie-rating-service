package com.cg.dto;

import jakarta.persistence.*;

@Entity
@Table(name="mov_rating")
public class MovieRating
{
	@Id
	@Column(name="mov_id",length=10)
	private int movieId;
	
	@Column(name="mov_rating",length=10)
	private int movieRating;
	
	public int getMovieId() 
	{
		return movieId;
	}
	public void setMovieId(int movieId) 
	{
		this.movieId = movieId;
	}
	@Override
	public String toString() 
	{
		return "Movie [movieId=" + movieId + ", movieRating=" + movieRating + "]";
	}
	public MovieRating() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieRating(int movieId, int movieRating) {
		super();
		this.movieId = movieId;
		this.movieRating = movieRating;
	}
	public int getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

}
