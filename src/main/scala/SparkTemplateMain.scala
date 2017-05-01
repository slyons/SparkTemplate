import java.io.File

import com.typesafe.config.ConfigFactory
import net.ceedubs.ficus.Ficus._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object SparkTemplateMain {


  def main(args:Array[String]):Unit = {
    val config = ConfigFactory.parseFile(new File("application.conf"))
    val sparkSettings = config.as[Map[String, String]]("sparkConf")

    val sparkConf = new SparkConf()
    sparkConf.setAll(sparkSettings)

    val spark = SparkSession.builder().enableHiveSupport().config(sparkConf).getOrCreate()
    val sc = spark.sparkContext

    /**
      * Your spark context starts here
      */
    sc.parallelize(1 to 10).count()
  }
}
