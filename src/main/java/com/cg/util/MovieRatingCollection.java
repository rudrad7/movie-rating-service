package com.cg.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.cg.dto.MovieRating;

public class MovieRatingCollection
{
	static HashMap<Integer,MovieRating> movRatMap=new HashMap<Integer,MovieRating>();
	static
	{
		MovieRating m1=new MovieRating(1001,5);
		MovieRating m2=new MovieRating(1002,1);
		MovieRating m3=new MovieRating(1003,2);
		MovieRating m4=new MovieRating(1004,5);
		MovieRating m5=new MovieRating(1005,4);
		MovieRating m6=new MovieRating(1006,2);
		
		movRatMap.put(1001, m1);
		movRatMap.put(1002, m2);
		movRatMap.put(1003, m3);
		movRatMap.put(1004, m4);
		movRatMap.put(1005, m5);
		movRatMap.put(1006, m6);
		
	}
	public static  HashSet<MovieRating> getAllMovRating()
	{
		Collection<MovieRating> obj = movRatMap.values(); 
		HashSet<MovieRating> hSet=new HashSet<MovieRating>();
		for(MovieRating mr:obj)
		{
			hSet.add(mr);
		}
		return   hSet;
	}
	public static  MovieRating  getMovieRatingById(int movId)
	{
		MovieRating mov=movRatMap.get(new Integer(movId));
		System.out.println("..............In  Collection Util"+mov);
		return mov;
	}

}
