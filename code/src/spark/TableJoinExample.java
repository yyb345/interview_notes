package spark;

import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;

public class TableJoinExample implements Serializable {
   static boolean isSQL = true;
    public static void main(String[] args) {
        // 创建 SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("TableJoinExample")
                .master("local[*]")
                .getOrCreate();

        // 读取第一个表
        Dataset<Row> table1 = spark.read()
                .format("csv")
                .option("header", "true")
                .load("table1.csv");

        // 读取第二个表
        Dataset<Row> table2 = spark.read()
                .format("csv")
                .option("header", "true")
                .load("table2.csv");

        // 执行表连接操作
        Dataset<Row> joinResult;

        if(!isSQL){
            joinResult= table1.alias("left").join(table2.alias("right"), new Column("left.id").equalTo(new Column("right.id")), "inner");

        }else {
            table1.createOrReplaceTempView("table1");
            table2.createOrReplaceTempView("table2");
            joinResult = spark.sql("SELECT * FROM table1 JOIN table2 ON table1.id = table2.id");
        }

        // 显示连接结果
        joinResult.show();





        // 停止 SparkSession
        spark.stop();
    }
}

