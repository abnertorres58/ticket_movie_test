package com.fdmgroup.repositories;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.entities.Movie;
import com.fdmgroup.entities.Rental;


public interface RentalRepository extends CrudRepository<Rental, Integer>{
//	@Query("from Movie as m INNER JOIN rental as r WHERE  m.id=r.movie_id where r.user_id = :userId")
//	@SqlResultSetMapping(name="PersonDTOMapping",
//            classes="@ConstructorResult(targetClass= PersonDTO.class,
//            columns = {@ColumnResult(name="name"),
//                       @ColumnResult(name="birhDate")}))
//	@Query(nativeQuery=true, value="select m.* from movie m join rental r on m.id=r.movie_id AND r.user_id = :userId")
	// using JPQL
	@Query("from Movie as m INNER JOIN Rental as r ON  m.id=r.movieId WHERE r.userId = :userId")
	List<Movie> findMyRentals(@Param("userId") Integer userId);
	
//	@Modifying
//    @Transactional
//	@Query(nativeQuery=true, value="delete from rental r on r.user_id = :userId AND r.movie_id = :movieId")
//	void deleteByMovieIdAndUserId(@Param("movieId") Integer movieId, @Param("userId") Integer userId );

	@Modifying
    @Transactional
	void deleteByMovieIdAndUserId(@Param("movieId") Integer movieId, @Param("userId") Integer userId);

	
}
	
//Failed to convert from type [java.lang.Object[]] to type  
//		for value  nested exception is org.springframework.core.convert.ConverterNotFoundException: 
//	No converter found capable of converting from type [java.lang.Integer] to type 
