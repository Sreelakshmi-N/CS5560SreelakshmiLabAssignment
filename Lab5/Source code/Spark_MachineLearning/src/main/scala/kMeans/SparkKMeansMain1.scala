package kMeans

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by sreel on 7/6/2017.
  */
object SparkKMeansMain1 {
  import org.apache.spark.mllib.clustering.{KMeans, KMeansModel}
  import org.apache.spark.mllib.linalg.Vectors
  System.setProperty("hadoop.home.dir", "C:\\winutil")
  val conf = new SparkConf().setAppName(s"KMeansExample").setMaster("local[*]").set("spark.driver.memory", "4g").set("spark.executor.memory", "4g")
  val sc = new SparkContext(conf)
  // Load and parse the data
  val data = sc.textFile("data/file.txt")
  val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble))).cache()

  // Cluster the data into two classes using KMeans
  val numClusters = 2
  val numIterations = 20
  val clusters = KMeans.train(parsedData, numClusters, numIterations)

  // Evaluate clustering by computing Within Set Sum of Squared Errors
  val WSSSE = clusters.computeCost(parsedData)
  println("Within Set Sum of Squared Errors = " + WSSSE)

  // Save and load model
  clusters.save(sc, "target/org/apache/spark/KMeansExample/KMeansModel")
  val sameModel = KMeansModel.load(sc, "target/org/apache/spark/KMeansExample/KMeansModel")
}
