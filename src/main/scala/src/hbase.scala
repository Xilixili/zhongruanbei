///**
//  * Created by hadoop on 17-5-25.
//  */
//package ReadHBase
//
//import org.apache.hadoop.hbase.client._
//import org.apache.hadoop.hbase.util.Bytes
//import org.apache.hadoop.hbase.{HColumnDescriptor, HTableDescriptor, TableName}
//
//import scala.collection.mutable.ArrayBuffer
//
//object HBase_Con{
//  class People {
//    var mac=new String
//    var range=new String
//    var time=new String
//  }
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
//
//  //删除表
//  def Hbase_deletetable(connection:Connection,tablename:String):Unit={
//    val tableName = TableName.valueOf(tablename)
//    val admin = connection.getAdmin
//    if (admin.tableExists(tableName)){
//      admin.disableTable(tableName)
//      admin.deleteTable(tableName)
//    }
//  }
//  //清空表数据
//  def Hbase_truncate(connection:Connection,tablename:String):Unit={
//    val tableName = TableName.valueOf(tablename)
//    val admin = connection.getAdmin
//    val td = admin.getTableDescriptor(tableName)
//    if (admin.tableExists(tableName)){
//      admin.disableTable(tableName)
//      admin.deleteTable(tableName)
//    }
//    admin.createTable(td)
//  }
//
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
//  //查询某条数据
//  def  Hbase_get(connection:Connection,tablename:String,key:String,family:String,column:String):String={
//    var table:Table=null
//    val admin = connection.getAdmin
//    try{
//      val userTable = TableName.valueOf(tablename)
//      if (admin.tableExists(userTable)) {
//        table = connection.getTable(userTable)
//        val g = new Get(key.getBytes())
//        val result = table.get(g)
//        val value = Bytes.toString(result.getValue(family.getBytes(), column.getBytes()))
//        value
//      }
//      else null
//    }finally{
//      if(table!=null)table.close()
//    }
//  }
//  //删除某条记录
//  def  Hbase_deleteOne(connection:Connection,tablename:String,key:String,family:String,column:String): Unit ={
//    var table:Table=null
//    val admin = connection.getAdmin
//    try{
//      val userTable=TableName.valueOf(tablename)
//      if (admin.tableExists(userTable)) {
//        table = connection.getTable(userTable)
//        val d = new Delete(key.getBytes())
//        d.addColumn(family.getBytes(), column.getBytes())
//        table.delete(d)
//      }
//    }finally{
//      if(table!=null)table.close()
//    }
//  }
//  //扫描记录店铺名
//  def  Hbase_scan_dianpu(connection:Connection,tablename:String): ArrayBuffer[String] ={
//    var table:Table=null
//    var scanner:ResultScanner=null
//    var l=new ArrayBuffer[String]
//    val admin = connection.getAdmin
//    try{
//      val userTable=TableName.valueOf(tablename)
//      if (admin.tableExists(userTable)) {
//        table = connection.getTable(userTable)
//        val s = new Scan()
//        //s.addColumn(family.getBytes(),column.getBytes())
//        scanner = table.getScanner(s)
//        var result: Result = scanner.next()
//        while (result != null) {
//          var p = new String
//          p = Bytes.toString(result.getRow)
//          result = scanner.next()
//          l += p
//        }
//        l
//      }
//      else null
//    }finally{
//      if(table!=null)
//        table.close()
//      scanner.close()
//    }
//  }
//  //扫描记录(通过列名和标识)
//  def  Hbase_scan2(connection:Connection,tablename:String): ArrayBuffer[People] ={
//    var table:Table=null
//    var scanner:ResultScanner=null
//    var l=new ArrayBuffer[People]
//    val admin = connection.getAdmin
//    try{
//      val userTable=TableName.valueOf(tablename)
//      if (admin.tableExists(userTable)) {
//        table = connection.getTable(userTable)
//        val s = new Scan()
//        //s.addColumn(family.getBytes(),column.getBytes())
//        scanner = table.getScanner(s)
//        var result: Result = scanner.next()
//        while (result != null) {
//          var p = new People
//          p.mac = Bytes.toString(result.getRow)
//          p.range = Bytes.toString(result.getValue("range".getBytes(), "1".getBytes()))
//          p.time = Bytes.toString(result.getValue("time".getBytes(), "1".getBytes()))
//          result = scanner.next()
//          l += p
//        }
//        l
//      }
//      else null
//    }finally{
//      if(table!=null)
//        table.close()
//      scanner.close()
//    }
//  }
//  def  Hbase_scan1(connection:Connection,tablename:String): ArrayBuffer[People] ={
//    var table:Table=null
//    var scanner:ResultScanner=null
//    var l=new ArrayBuffer[People]
//    val admin = connection.getAdmin
//    try{
//      val userTable=TableName.valueOf(tablename)
//      if (admin.tableExists(userTable)) {
//        table = connection.getTable(userTable)
//        val s = new Scan()
//        scanner = table.getScanner(s)
//        var result: Result = scanner.next()
//        while (result != null) {
//          var p = new People
//          p.mac = Bytes.toString(result.getRow)
//          p.time = Bytes.toString(result.getValue("time".getBytes(), "1".getBytes()))
//          result = scanner.next()
//          l += p
//        }
//        l
//      }
//      else null
//    }finally{
//      if(table!=null)
//        table.close()
//      scanner.close()
//    }
//  }
//  def  Hbase_scan(connection:Connection,tablename:String,family:String,column:String): ArrayBuffer[People] ={
//    var table:Table=null
//    var scanner:ResultScanner=null
//    var l=new ArrayBuffer[People]
//    val admin = connection.getAdmin
//    try{
//      val userTable=TableName.valueOf(tablename)
//      if (admin.tableExists(userTable)) {
//        table = connection.getTable(userTable)
//        val s = new Scan()
//        s.addColumn(family.getBytes(), column.getBytes())
//        scanner = table.getScanner(s)
//        var result: Result = scanner.next()
//        while (result != null) {
//          var p = new People
//          p.mac = Bytes.toString(result.getRow)
//          p.time = Bytes.toString(result.getValue(family.getBytes(), column.getBytes()))
//          result = scanner.next()
//          l += p
//        }
//        l
//      }
//      else null
//    }finally{
//      if(table!=null)
//        table.close()
//      scanner.close()
//    }
//  }
//}