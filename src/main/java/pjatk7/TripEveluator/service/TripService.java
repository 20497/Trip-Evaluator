package pjatk7.TripEveluator.service;

import org.springframework.stereotype.Service;
import pjatk7.TripEveluator.database.TripRepository;
import pjatk7.TripEveluator.models.Review;
import pjatk7.TripEveluator.models.Trip;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public void saveTrip(Trip trip){
        tripRepository.save(trip);
    }

    public void addReview(Review review, Trip trip){
        List<Review> reviewList = trip.getReviewList();
        reviewList.add(review);
        trip.setReviewList(reviewList);
    }

    public List<Trip> findAll(){
        List<Trip> allTrips = tripRepository.findAll();
        return allTrips;
    }

    public Trip findById(Integer id){
        Optional<Trip> tripById = tripRepository.findById(id);
        return tripById.orElse(null);
    }

    public void deleteById(Integer id){
        tripRepository.deleteById(id);
    }
}
