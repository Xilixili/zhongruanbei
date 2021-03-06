//
//
//import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, HBaseAdmin, Put}
//import org.apache.hadoop.hbase.{HBaseConfiguration, HColumnDescriptor, HTableDescriptor, TableName}
//import org.apache.spark._
//import org.apache.spark.streaming._
//
//import scala.util.matching.Regex
//
//object com_info {
//  def main(args: Array[String]) {
//    val sparkConf = new SparkConf().setAppName("com_info").setMaster("local[2]")//设置为本地运行模式，2个线程，一个监听，另一个处理数据
//    val sc = new SparkContext(sparkConf)
//    val ssc = new StreamingContext(sparkConf, Seconds(20))// sparkstreaming执行，时间间隔为20秒
//    val lines = ssc.textFileStream("file:///home/hadoop/spark/mycode/streaming/logfile")  //这里采用本地文件,为mysql导出的数据文件
//
//    val words=lines.map(_.split(" "))
//    var  a1=0.0
//    words.foreachRDD(RDD=>{
//      val records=RDD.collect.apply(0)
//      val reg_no=records.apply(0)
//      val com_name=records.apply(1)
//      val yyzz=records.apply(2)
//      val base_info=records.apply(3)
//      val GDCZ=records.apply(5)
//      val tablename = "company"
//      val array=GDCZ.split("\n")
//
//      for (i<-array){
//        var GD_name=i.split(" ").apply(1)
//        val GDLX=i.split(" ").apply(0)
//        var a=i.split(" ").apply(5)
//        val str1=("[\\d.]{0,9}")
//        val pattern1=new Regex(str1)
//        val ZB=(pattern1 findAllIn a).mkString("")
//        if (a.contains("美元")) a1 = ZB.toDouble * 6.4379
//        else a1 = ZB.toDouble
//        var GDBL=a1
//
//        val table_name="ysgd"
//        val config = HBaseConfiguration.create()
//        val conn = ConnectionFactory.createConnection(config)
//        val admin = new HBaseAdmin(config)
//
//        if (admin.tableExists(table_name))
//        {
//          Hbase_create(conn,table_name,"com_info","cf2")//如果不存在表就创建表
//        }
//
//        Hbase_insert(conn,table_name,reg_no,"com_info","GDLX",GDLX)
//        Hbase_insert(conn,table_name,reg_no,"com_info","reg_no",reg_no)
//        Hbase_insert(conn,table_name,reg_no,"com_info","com_name",com_name)
//        Hbase_insert(conn,table_name,reg_no,"com_info","GD_name",GD_name)
//        Hbase_insert(conn,table_name,reg_no,"com_info","GDBL",GDBL.toString)
//
//
//      }
//
//    })
//
//    ssc.start()
//    ssc.awaitTermination()
//  }
//
//
//  //创建表
//  def Hbase_create(connection: Connection,tablename: String,a:String,b:String): Unit=
//  {
//    val admin = connection.getAdmin
//    val tableName = TableName.valueOf(tablename)
//    if (!admin.tableExists(tableName)) {
//      val tableDescriptor = new HTableDescriptor(tableName)
//      tableDescriptor.addFamily(new HColumnDescriptor(a.getBytes()))
//      tableDescriptor.addFamily(new HColumnDescriptor(b.getBytes()))
//      admin.createTable(tableDescriptor)
//    }
//  }
//  //插入记录
//  def  Hbase_insert(connection:Connection,tablename:String,key:String,family:String,column:String,value:String):Unit={
//    val admin = connection.getAdmin
//    try{
//      val userTable = TableName.valueOf(tablename)
//      if (admin.tableExists(userTable)) {
//        val table = connection.getTable(userTable)
//        val p = new Put(key.getBytes)
//        p.addColumn(family.getBytes, column.getBytes, value.getBytes())
//        table.put(p)
//      }
//    }
//  }
//
//}