package com.sundogsoftware.spark

import org.apache.log4j._
import org.apache.spark.sql.SparkSession

object DeltaLakeBasic {

  def main(args: Array[String]): Unit ={
    Logger.getLogger("org").setLevel(Level.ERROR)
  }

  val spark = SparkSession.builder()
    .appName("DeltaLakeBasic")
    .master("local[*]")
    .getOrCreate()

  import spark.implicits._

  //Write a basic delta table
  val data = spark.range(5, 10)
  data.write.format("delta").save("data/play-ground-delta-table")
}
