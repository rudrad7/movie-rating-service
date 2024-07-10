package com.cg.ctrl;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
//http://localhost:9909/rating/list
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.MovieRating;
import com.cg.service.MovieRatingService;

@RestController
@RequestMapping("/movRatCtrl")
public class MovieRatingControlller 
{
	@Autowired
	MovieRatingService movieRatingSer;
		
	
	//http://localhost:8083/movRatCtrl/fetchMovieById/1002
	@RequestMapping("/fetchMovieById/{movId}")
	
	public MovieRating getMovieById(@PathVariable("movId")int mId)
	{
	 MovieRating movieRating = movieRatingSer.getMovieRatingById(mId);
		System.out.println(" rating "+movieRating);
		return movieRating;
	}
	
	//http://localhost:9092/movRatCtrl/fetchAllMovieRating
	@RequestMapping("/fetchAllMovieRating")
	public HashSet<MovieRating> getAllMovieRating()
	{
		return (HashSet)movieRatingSer.getAllMovieRating();
	}
	public  MovieRating whenMovIdNotFound(int movId)
	{
		return new MovieRating(0,0);
		//return "  Movie id not found " +movId;
	}
	

}
