
package tech.sda.starter.hadoop

import java.io.IOException
import java.util._
import org.apache.hadoop.fs.Path
import org.apache.hadoop.conf._
import org.apache.hadoop.io._
import org.apache.hadoop.mapred._
import org.apache.hadoop.util._

object WordCount {
  class Map extends MapReduceBase with Mapper[LongWritable, Text, Text, IntWritable] {
    private final val one = new IntWritable(1)
    private val word = new Text()

    def map(key: LongWritable, value: Text, output: OutputCollector[Text, IntWritable], reporter: Reporter) {
      val line: String = value.toString
      line.split(" ").foreach { token =>
        word.set(token)
        output.collect(word, one)
      }
    }
  }
  class Reduce extends MapReduceBase with Reducer[Text, IntWritable, Text, IntWritable] {

    def reduce(key: Text, values: Iterator[IntWritable], output: OutputCollector[Text, IntWritable], reporter: Reporter) {
      import scala.collection.JavaConversions._
      val sum = values.toList.reduce((valueOne, valueTwo) => new IntWritable(valueOne.get() + valueTwo.get()))
      output.collect(key, new IntWritable(sum.get()))
    }
  }
  def main(args: Array[String]) {
    if (args.length < 2) {
      System.err.println(
        "Usage: Wordcount <input> <output>")
      System.exit(1)
    }

    val conf: JobConf = new JobConf(this.getClass)
    conf.setJobName("Word Count")
    conf.setOutputKeyClass(classOf[Text])
    conf.setOutputValueClass(classOf[IntWritable])
    conf.setMapperClass(classOf[Map])
    conf.setCombinerClass(classOf[Reduce])
    conf.setReducerClass(classOf[Reduce])
    conf.setInputFormat(classOf[TextInputFormat])
    conf.setOutputFormat(classOf[TextOutputFormat[Text, IntWritable]])
    FileInputFormat.setInputPaths(conf, new Path(args(0)))
    FileOutputFormat.setOutputPath(conf, new Path(args(1)))
    JobClient.runJob(conf)
  }
}