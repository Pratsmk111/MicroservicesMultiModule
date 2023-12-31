package com.lcwd.rating.RatingService.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.lcwd.rating.RatingService.Entity.Rating;

public interface RatingRepository extends MongoRepository<Rating, String>{
	
	List<Rating>getRatingByUserId(String userId);
	
	List<Rating>getRatingByHotelId(String id);

}
