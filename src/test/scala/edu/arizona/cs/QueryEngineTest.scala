package edu.arizona.cs
import org.scalatest.FunSuite
import scala.collection.JavaConversions
import scala.collection.JavaConversions._
import scala.collection.immutable._


class QueryEngineTest extends FunSuite{

  val inputFileFullPath = "input.txt"
  val doc_names_q1 = List("Doc1", "Doc2")

  test("QueryEngine.Q1") {

    val inputFileFullPath = "input.txt"
    val objQueryEngine: QueryEngine = new QueryEngine(inputFileFullPath)
    val common_query: List[String] = List("information", "retrieval")
    val ans1 = objQueryEngine.runQ1(common_query)
    val doc_names_q1 = List("Doc1", "Doc2")
    assert(doc_names_q1.size == ans1.size)
    var counter1 = 0
    for (x <- ans1) {
      assert(x.DocName.get("docid") == doc_names_q1(counter1))
      counter1 = counter1 + 1
    }
  }

  test("QueryEngine.Q13a") {
    val objQueryEngine: QueryEngine = new QueryEngine(inputFileFullPath)

    val common_query: List[String] = List("information", "retrieval")
    val ans1 = objQueryEngine.runQ13a(common_query)
    var counter1 = 0
    assert(doc_names_q1.size == ans1.size)
    for (x <- ans1) {
      assert(x.DocName.get("docid") == doc_names_q1(counter1))
      counter1 = counter1 + 1
    }
  }

  test("QueryEngine.Q13b") {
    val inputFileFullPath = "input.txt"
    val objQueryEngine: QueryEngine = new QueryEngine(inputFileFullPath)
    val common_query: List[String] = List("information", "retrieval")
    val ans1 = objQueryEngine.runQ13b(common_query)
    assert(ans1.size()  == 0)

  }

  test("QueryEngine.Q13c") {
    val inputFileFullPath = "input.txt"
    val objQueryEngine: QueryEngine = new QueryEngine(inputFileFullPath)
    val common_query: List[String] = List("information", "retrieval")
    val ans1 = objQueryEngine.runQ13c(common_query)

    assert(ans1.size == 1)
    assert(ans1(0).DocName.get("docid")== doc_names_q1(0))
  }

}
