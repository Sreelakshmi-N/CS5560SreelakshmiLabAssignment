import java.nio.file.{Files, Paths}

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by user on 6/17/2017.
  */
object sRat {

  def main(args: Array[String]) {


    System.setProperty("hadoop.home.dir","C:\\winutils");

    val sparkConf = new SparkConf().setAppName("sRat").setMaster("local[*]")
    val sc=new SparkContext(sparkConf)
    val snow: StanfordLemmatizer = new StanfordLemmatizer
    val text = new String(Files.readAllBytes(Paths.get("C:/Users/user/Desktop/bbc/entertainment/030.txt")))
    val jon = snow.lemmatize(text)


    val x = sc.parallelize(Array(jon))
    //val y = x.groupBy(word => word.charAt(0))
    val y = x.flatMap(line=>{line.split(" ")}).groupBy(word=> word.charAt(0)).cache()
    //val p = x.filter(line=>{line.split(" ")}).groupBy(word=>word)
    y.saveAsTextFile("output")
    //System.out.println(jon)
  }

}
