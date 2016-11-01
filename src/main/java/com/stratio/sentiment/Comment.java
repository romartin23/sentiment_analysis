package com.stratio.sentiment;

import java.io.Serializable;

/**
 * Created by roman on 1/11/16.
 */
public class Comment implements  Serializable{

    private Double rating;
    private String review;

    public Comment() {

    }
    public Comment(Double rating, String review) {
        this.rating = rating;
        this.review = review;
    }
    public Double getRating() {
        return rating;
    }
    public String getReview() {
        return review;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public void setReview(String review) {
        this.review = review;
    }
}
