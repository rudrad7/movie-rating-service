package com.cg.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cg.dao.MovieRatingRepository;
import com.cg.dto.MovieRating;
import com.cg.util.MovieRatingCollection;

@Service
public class MovieRatingService 
{
	@Autowired
	MovieRatingRepository movieRatingDao;
	
	@Autowired	(required = false)
    private CircuitBreakerFactory circuitBreakerFactory;
	
	public Set<MovieRating> getAllMovieRating()
	{
		ArrayList<MovieRating> movList=(ArrayList)movieRatingDao.findAll();
		HashSet<MovieRating> movSet=new  HashSet<MovieRating>();
		for(MovieRating mr:movList)
		{
			movSet.add(mr);
		}		
		return movSet;
		
	}
	public MovieRating getMovieRatingById(int movId)
	{
		 CircuitBreaker circuitBreaker =
				 circuitBreakerFactory.create("circuitbreaker");
		Optional<MovieRating>  opCat=movieRatingDao.findById(movId);		
		System.out.println(" opCat: "+opCat);
		 if(opCat.isEmpty())
		 {
			 return circuitBreaker.run(() ->{ 
			 MovieRating movieRating=new MovieRating(0,0);
				 return movieRating;} );	
		 }
		return opCat.get();
	}
}
