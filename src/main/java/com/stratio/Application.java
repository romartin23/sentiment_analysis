package com.stratio;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.sql.SQLContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/


@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static JavaSparkContext ctx;
    public static SQLContext sqlContext;
    public static PipelineModel model;

    public static void main(String[] args) {

        String pathModel = args[0];
        SparkConf sparkConf = new SparkConf().setAppName("Sentiment_Analysis").setMaster("local[2]");
        ctx = new JavaSparkContext(sparkConf);
        sqlContext = new org.apache.spark.sql.SQLContext(ctx);
        model = PipelineModel.load(pathModel);
        SpringApplication.run(Application.class, args);

    }

}

