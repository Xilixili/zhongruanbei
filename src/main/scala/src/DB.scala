//package ReadHBase
//
//import java.sql.Connection
//import java.sql.DriverManager
////import java.sql.PreparedStatement
////import java.sql.ResultSet
//
///**
//  * Created by GatsbyNewton on 2015/10/12.
//  */
//object DBUtils {
//
//  val url = "jdbc:mysql://localhost:3306/bigdata"
//  val username = "root"
//  val password = "root"
//
//  classOf[com.mysql.jdbc.Driver]
//
//  def getConnection(): Connection = {
//    DriverManager.getConnection(url, username, password)
//  }
//
//  def close(conn: Connection): Unit = {
//    try{
//      if(!conn.isClosed() || conn != null){
//        conn.close()
//      }
//    }
//    catch {
//      case ex: Exception => {
//        ex.printStackTrace()
//      }
//    }
//  }
//
//    def close(rs: ResultSet): Unit = {
//      try {
//        if(!rs.isClosed() || rs != null){
//          rs.close()
//        }
//      }
//      catch {
//        case ex: Exception => {
//          ex.printStackTrace()
//        }
//      }
//    }
//
//    def close(pstm: PreparedStatement): Unit = {
//      try {
//        if(!pstm.isClosed() || pstm != null){
//          pstm.close()
//        }
//      }
//      catch {
//        case ex: Exception => {
//          ex.printStackTrace()
//        }
//      }
//    }
//
//}