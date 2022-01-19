package pjatk7.TripEveluator.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="Trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String destination;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviewList;
    private Integer averagePrice;

    public Trip() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public void setAveragePrice(Integer averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDestination() {
        return destination;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public Integer getAveragePrice() {
        return averagePrice;
    }
}
