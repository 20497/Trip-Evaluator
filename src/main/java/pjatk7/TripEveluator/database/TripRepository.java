package pjatk7.TripEveluator.database;

import org.springframework.data.jpa.repository.JpaRepository;
import pjatk7.TripEveluator.models.Trip;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}
