package pjatk7.TripEveluator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pjatk7.TripEveluator.models.Review;
import pjatk7.TripEveluator.models.Trip;
import pjatk7.TripEveluator.service.TripService;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripRestController {

    private final TripService tripService;

    public TripRestController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/save")
    public ResponseEntity<Void> getSaveTrip(Trip trip){
        tripService.saveTrip(trip);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/postReview")
    public ResponseEntity<Void> addReview(Review review, Trip trip){
        tripService.addReview(review, trip);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allTrips")
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripService.findAll());
    }

    @GetMapping("/findTripById/{id}")
    public ResponseEntity<Trip> findTripById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(tripService.findById(id));
    }

    @GetMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteTripById(@PathVariable("id") Integer id){
        tripService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
