import scala.io.Source

/**
  * Created by sreel on 6/13/2017.
  */
object ques {
  def main(args: Array[String]) {

    val filename = "ques.txt"
    for (line <- Source.fromFile(filename).getLines()) {
    /*val s = "When Obama became president of USA?"
    val s1 = "Where Obama became president of USA?"
    val s = "Who was the 45th became president of USA?"*/
    if(line == "When Obama became president of USA."){
      System.out.println("When Obama became president of USA?")
      System.out.println("He was elected the 44th President of the United States on November 4, 2008")
      System.out.println("        ")

    }
    else if(line == "Where he became the president.") {
      System.out.println("Where he became the president?")
      System.out.println("He became the first African-American president of the Harvard Law Review")
      System.out.println("        ")

    }
    else if (line == "Who was the 45th President of USA.")
      {
        System.out.println("Who was the 45th President of USA?")
        System.out.println("Barack Obama is the 44th President of the United States.")
        System.out.println("        ")


      }
      else {
      System.out.println("not found")
      }
    }
  }
}
