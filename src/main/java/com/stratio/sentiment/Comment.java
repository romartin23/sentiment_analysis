package com.stratio.sentiment;

import java.io.Serializable;

/**
 * Created by roman on 1/11/16.
 */
public class Comment implements  Serializable{

    private String review;

    public Comment() {

    }

    public Comment(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
}
