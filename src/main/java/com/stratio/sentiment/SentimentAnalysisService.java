package com.stratio.sentiment;

import com.stratio.Application;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Created by roman on 1/11/16.
 */

@RestController
public class SentimentAnalysisService {

    @RequestMapping(value = "/sentiment", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody CommentSentiment sentiment(@RequestBody Comment comment) {
        try {
            //Creating the dataframe to execute the model.
            DataFrame training = Application.sqlContext.createDataFrame(
                Arrays.asList(
                   new CommentSentiment(-1d,comment.getReview())
                ), CommentSentiment.class);

            //Executing the model (pipeline).
            DataFrame predictions =  Application.model.transform(training);

            //Getting the response of the execution...
            Row r = predictions.select("probability", "prediction").collect()[0];

            //Creating the response.
            return new CommentSentiment( (Double) r.get(1), comment.getReview());
        }catch (Throwable e) {
            e.printStackTrace();
        }
        return new CommentSentiment( -1d, "ERROR");
    }
}
