package bigdata.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class WordCount {
    public static void main(String[] args) {
        // 创建Spark配置
        SparkConf conf = new SparkConf()
                .setAppName("WordCount")
                .setMaster("local[*]");

        // 创建Spark上下文
        JavaSparkContext sc = new JavaSparkContext(conf);

        // 读取文本文件并拆分单词
        JavaRDD<String> lines = sc.textFile("test_write_using_filechannel.txt");
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split("\\W+")).iterator());

        // 每个单词计数为1，并进行累加
        JavaPairRDD<String, Integer> wordCounts = words
                .mapToPair(word -> new Tuple2<>(word, 1))
                .reduceByKey(Integer::sum);

        // 打印结果
        wordCounts.foreach(tuple -> System.out.println(tuple._1() + ": " + tuple._2()));

        // 停止Spark上下文
        sc.stop();
    }
}

