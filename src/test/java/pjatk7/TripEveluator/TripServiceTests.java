package pjatk7.TripEveluator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pjatk7.TripEveluator.database.TripRepository;
import pjatk7.TripEveluator.models.Review;
import pjatk7.TripEveluator.models.Trip;
import pjatk7.TripEveluator.service.TripService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TripServiceTests {

    @Mock
    private TripRepository tripRepository;

    @InjectMocks
    private TripService tripService;

    @Test
    void saveTripMethodIsWorkingCorrectly(){
        //GIVEN
        Trip trip = new Trip(1, "Beach paradise", "Greece");
        //WHEN
        tripService.saveTrip(trip);
        //THEN
        assertThat(tripRepository.findById(trip.getId())).isNotNull();
    }

    @Test
    void addingReviewMethodIsWorkingCorrectly(){
        //GIVEN
        Trip trip = new Trip(1, "Beach paradise", "Greece");
        Review review = new Review(1, "Dobra wycieczka, polecam");
        //WHEN
        tripService.addReview(review, trip);
        //THEN
        assertThat(tripRepository.findById(trip.getId()).equals(trip.getReviewList()));
    }

    @Test
    void gettingListOfTripsIsWorkingCorrectly(){
        //GIVEN
        Trip trip = new Trip(1, "Beach paradise", "Greece");
        List<Trip> tripList = tripService.findAll();
        //WHEN
        tripService.saveTrip(trip);
        //THEN
        assertThat(tripRepository.findAll().equals(tripList));
    }

    @Test
    void findByIdIsWorkingCorrectly(){
        //GIVEN
        Integer id = 1;
        Trip trip = new Trip(id, "Beach paradise", "Greece");
        //WHEN
        tripService.saveTrip(trip);
        //THEN
        assertThat(tripRepository.findById(id).equals(trip));
    }

    @Test
    void findByIdIsWorkingCorrectlyWithNull(){
        //GIVEN
        Integer id = 1;
        Trip trip;
        //WHEN
        trip = tripService.findById(id);
        //THEN
        assertThat(tripRepository.findById(id).equals(trip));
    }

    @Test
    void deleteByIdIsWorkingCorrectly(){
        //GIVEN
        Trip trip = new Trip(1, "Beach paradise", "Greece");
        //WHEN
        tripService.saveTrip(trip);
        tripService.deleteById(trip.getId());
        //THEN
        assertThat(tripRepository.findById(trip.getId()).equals(null));
    }
}
