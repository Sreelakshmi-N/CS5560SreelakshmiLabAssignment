import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source

/**
  * Created by Mayanka on 19-06-2017.
  */
object NGRAM {

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")
      .set("spark.driver.memory", "6g").set("spark.executor.memory", "6g")

    val sc = new SparkContext(sparkConf)


    val a = getNGrams("The dog see John in the park. The little bear see the fine fat trout in the rocky brook. The dog start chase John. The little bear catch a fish in the rocky brook .",3)
    a.foreach(f=>println(f.mkString(" ")))



  }

  def getNGrams(sentence: String, n:Int): Array[Array[String]] = {
    val words = sentence
    val ngrams = words.split(' ').sliding(n)
    ngrams.toArray
  }

}


