//package ReadHBase
//
//import org.apache.hadoop.hbase.HBaseConfiguration
//import org.apache.hadoop.hbase.client.HBaseAdmin
//import org.apache.hadoop.hbase.mapreduce.TableInputFormat
//import org.apache.hadoop.hbase.util.Bytes
//import org.apache.spark.sql.{SQLContext, SaveMode}
//import org.apache.spark.{SparkConf, SparkContext}
//
//
//object YSGX{
//  def main(rgs: Array[String]): Unit = {
//
//
//    val sparkConf = new SparkConf().setAppName("cunchu").setMaster("local")
//    val sc = new SparkContext(sparkConf)
//    val sqlContext = new SQLContext(sc)
//    val tablename = "ysgd"
//    val conf = HBaseConfiguration.create()
//    conf set("hbase.zookeeper.quorum", "master")
//    conf.set("hbase.zookeeper.property.clientPort", "2181")
//    conf.set(TableInputFormat.INPUT_TABLE, tablename)
//    val admin = new HBaseAdmin(conf)
//
//    val hBaseConf = HBaseConfiguration.create()
//    hBaseConf.set(TableInputFormat.INPUT_TABLE, tablename)
//
//    val hBaseRDD = sc.newAPIHadoopRDD(hBaseConf, classOf[TableInputFormat],
//      classOf[org.apache.hadoop.hbase.io.ImmutableBytesWritable],
//      classOf[org.apache.hadoop.hbase.client.Result])
//    val rdd = hBaseRDD.map(r => (
//      Bytes.toString(r._2.getValue(Bytes.toBytes("cominfo"), Bytes.toBytes("reg_no"))),
//      Bytes.toString(r._2.getValue(Bytes.toBytes("cominfo"), Bytes.toBytes("com_name"))),
//      Bytes.toString(r._2.getValue(Bytes.toBytes("cominfo"), Bytes.toBytes("GD_name"))),
//      Bytes.toString(r._2.getValue(Bytes.toBytes("cominfo"), Bytes.toBytes("GDLX"))),
//      Bytes.toString(r._2.getValue(Bytes.toBytes("cominfo"), Bytes.toBytes("GDBL")))
//    ))
//
//    //    var df=shop
//    var i=0
//    var rdd2=rdd.filter(x=>x._4.trim.equals("1"))
//    var rdd3=rdd2.filter(x => !(x._3.contains("公司")))
//
//    var rdd6=rdd3.map(x=>(x._1,x._2,x._3,x._4,x._5,x._3))
//    var rdd5=rdd
//    var rdd4=rdd2.filter(x=>x._3.contains("公司"))
//    var array=rdd4.collect()
//    var li:List[Tuple2[String,String]]=List()
//    var rd=rdd.map(x=>(x._1,x._5.toDouble))
//    var rd1=rd.reduceByKey((x,y)=>x+y)
//    import sqlContext.implicits._
//    var shop=rd1.toDF("reg_no","Sum")
//    shop.registerTempTable("shop")
//    val df = sqlContext.sql("SELECT * FROM shop")
//    df.show(50)
//    val A=rd1.collect()
//    print(A.length)
//
//    val prop = new java.util.Properties
//    prop.setProperty("user","root")
//    prop.setProperty("password","root")
//    val url="jdbc:mysql://localhost:3306/tests"
//    df.write.mode(SaveMode.Overwrite).jdbc(url,"sum",prop)
//  }
//}