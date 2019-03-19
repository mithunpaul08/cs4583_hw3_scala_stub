
package edu.arizona.cs
import org.apache.lucene.analysis.standard.StandardAnalyzer
import java.io._
import org.apache.lucene.search.similarities.Similarity
import org.apache.lucene.search.similarities.ClassicSimilarity
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.queryparser.classic.ParseException
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.ScoreDoc
import org.apache.lucene.search.TopDocs
import org.apache.lucene.store.Directory
import org.apache.lucene.store.RAMDirectory
import scala.collection.mutable.ListBuffer
import java.io.File
import java.io.IOException
import java.util.Scanner
import QueryEngine._
import scala.collection.JavaConversions._
import scala.io.Source
import scala.collection.mutable.{ListBuffer, ArrayBuffer}
import scala.collection.immutable

object QueryEngine {

  def main(args: Array[String]): Unit = {
    val fileName: String = "input.txt"
    println("********Welcome to  Homework 3!")

    val query13a: List[String] = List("information", "retrieval")
    val objQueryEngine: QueryEngine = new QueryEngine(fileName)
    val q1Results = objQueryEngine.runQ1(query13a)

    println("Results for Q13a are: " + q1Results.map(_.DocName.get("docid")).mkString(", "))
  }

}

class QueryEngine(var collectionFileName: String) {

  var indexExists = false

  def buildIndex(): Unit = {
    val source = Source.fromResource(collectionFileName)
    // build one doc in your Lucene index from each line in the input file
    for(line <- source.getLines()) {
      // TODO: your code here :)
    }
    source.close()
    indexExists = true
  }

  def runQ1(query: List[String]): List[ResultClass] = {
    if(! indexExists) buildIndex()
    returnDummyResults(2)
  }

  def runQ13a(query: List[String]): List[ResultClass] = {
    if(! indexExists) buildIndex()
    returnDummyResults(2)
  }

  def runQ13b(query: List[String]): List[ResultClass] = {
    if(! indexExists) buildIndex()
    List[ResultClass]()
  }

  def runQ13c(query: List[String]): List[ResultClass] = {
    if(! indexExists) buildIndex()
    returnDummyResults(1)
  }


  private def returnDummyResults(maxResults:Int): List[ResultClass] = {
    var doc_score_list = new ListBuffer[ResultClass]()

    for (i <- 0 until maxResults) {
      val doc: Document = new Document()
      doc.add(new TextField("title", "", Field.Store.YES))
      doc.add(
        new StringField("docid",
          "Doc" + java.lang.Integer.toString(i + 1),
          Field.Store.YES))
      val objResultClass: ResultClass = new ResultClass()
      objResultClass.DocName = doc
      doc_score_list += (objResultClass)
    }

    doc_score_list.toList
  }


}
