//import com.hankcs.hanlp.HanLP
//import com.hankcs.hanlp.dictionary.CoreSynonymDictionary
//import com.hankcs.hanlp.seg.CRF.CRFSegment
//import com.hankcs.hanlp.seg.Segment
//import com.hankcs.hanlp.seg.common.Term
//import com.hankcs.hanlp.suggest.Suggester
//import jdk.nashorn.internal.runtime.regexp.joni.Regex
//import java.sql._
//import java.util
//import java.util.{Calendar, List}
//import java.util.regex.Matcher
//import java.util.regex.Pattern
//
//import ReadHBase.HBase_Con
//import com.sun.org.apache.xalan.internal.lib.ExsltStrings.split
////插入关于高级搜索的数据
//object hanlp {
//  def hanlp(li: util.List[company]): Unit = {
//
//    try
//      Class.forName("com.mysql.jdbc.Driver")
//    catch {
//      case e: ClassNotFoundException =>
//        e.printStackTrace()
//    }
//    val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8")
//    //        Iterator<company> iter = li.iterator();
//    //        while(iter.hasNext()){  //执行过程中会执行数据锁定，性能稍差，若在循环过程中要去掉某个元素只能调用iter.remove()方法。
//    //            System.out.println(iter.next());
//    //            String com_name=
//    //
//    //
//    //            iter.toString();
//    //        }
//    var i = 0
//    System.out.println()
//    i = 0
//    while ( {
//      i <= li.size - 1
//    }) {
//      val com_name = li.get(i).getCom_name
//      var ZB = ""
//      var RQ = ""
//      var FW = ""
//      var PRO = ""
//      var pro_num = ""
//      val cal = Calendar.getInstance
//      val year = cal.get(Calendar.YEAR)
//      val reg_no = li.get(i).getReg_no
//      val yyzz = li.get(i).getYyzz
//      val base_info = li.get(i).getBase_info
//      val dwcz = li.get(i).getDwcz
//      val gdcz = li.get(i).getGdcz
//      val pattern = Pattern.compile("\\注册资本：\\n[\\u4e00-\\u9fa5\\s\\d].{1,}")
//      val pattern1 = Pattern.compile("\\成立日期：\\n[\\u4e00-\\u9fa5\\s\\d].{1,}")
//      val pattern2 = Pattern.compile("\\经营范围：\\n[\\u4e00-\\u9fa5\\s\\d].{1,}\\。")
//      val pattern3 = Pattern.compile("[\\u4e00-\\u9fa5^市\\s\\d].{1,}\\市")
//      val matcher = pattern.matcher(yyzz)
//      val matcher1 = pattern1.matcher(yyzz)
//      val matcher2 = pattern2.matcher(yyzz)
//      val matcher3 = pattern3.matcher(yyzz)
//      if (matcher.find) {
//        val ZCZB = matcher.group(0)
//        val p = Pattern.compile("[0-9]{1,}")
//        val m = p.matcher(ZCZB)
//        if (m.find) {
//          ZB = m.group(0)
//          if (Integer.valueOf(ZB) <= 100) ZB = "100万以内"
//          else if (Integer.valueOf(ZB) > 100 && Integer.valueOf(ZB) <= 500) ZB = "100-500万"
//          else if (Integer.valueOf(ZB) > 500 && Integer.valueOf(ZB) <= 1000) ZB = "500-1000万"
//            else if (Integer.valueOf(ZB) > 1000 && Integer.valueOf(ZB) <= 3000) ZB = "1000-3000万"
//              else if (Integer.valueOf(ZB) > 3000 && Integer.valueOf(ZB) <= 5000) ZB = "3000-5000万"
//                else ZB = "5000万以上"
//        }
//      }
//      if (matcher1.find) {
//        val CLRQ = matcher1.group(0)
//        val p1 = Pattern.compile("[0-9]{4,}")
//        val m1 = p1.matcher(CLRQ)
//        if (m1.find) {
//          RQ = m1.group(0)
//          if (year - Integer.valueOf(RQ) <= 1) RQ = "1年内"
//          else if (year - Integer.valueOf(RQ) > 1 && year - Integer.valueOf(RQ) <= 3) RQ = "1-3年"
//          else if (year - Integer.valueOf(RQ) > 3 && year - Integer.valueOf(RQ) <= 10) RQ = "4-10年"
//            else RQ = "10年以上"
//        }
//      }
//      if (matcher2.find) {
//        val JYFW = matcher2.group(0)
//        val content = JYFW
//        val phraseList1 = HanLP.extractPhrase(content, 5)
//        val phrase = phraseList1.toString
//        val suggester = new Suggester
//        val titleArray = ("农、林、牧、渔业\n" + "采矿业\n" + "制造业\n" + "电力、热力、燃气及水生产和供应业\n" + "建筑业\n" + "批发和零售业\n" + "交通运输、仓储和邮政业\n" + "住宿和餐饮业\n" + "信息传输、软件和信息技术服务业\n" + "金融业\n" + "房地产业\n" + "租赁和商务服务业\n" + "科学研究和技术服务业\n" + "水利、环境和公共设施管理业\n" + "居民服务、修理和其他服务业\n" + "教育\n" + "卫生和社会工作\n" + "文化、体育和娱乐业\n") //                                "公共管理、社会保障和社会组织\n"
//          .split("\n")
//        for (title <- titleArray) {
//          suggester.addSentence(title)
//        }
//        FW = suggester.suggest(phrase, 1).get(0).toString.trim // 语义
//
//        //                System.out.println(FW);
//      }
//      if (matcher3.find) {
//        val ZS = matcher3.group(0)
//        //                System.out.println(ZS);
//        //                ZS=ZS.substring(0,3);
//        //                System.out.println(ZS);
//        sql1 = "select * from dict_city"
//        sql2 = "select * from dict_province WHERE N_PROVID=?"
//        stmt1 = conn.prepareStatement(sql1)
//        rs1 = stmt1.executeQuery
//        while ( {
//          rs1.next
//        }) {
//          pro_num = rs1.getString("N_PROVID")
//          val city_name = rs1.getString("S_CITYNAME")
//          if (ZS.contains(city_name)) {
//            stmt2 = conn.prepareStatement(sql2)
//            stmt2.setString(1, pro_num)
//            rs2 = stmt2.executeQuery
//            while ( {
//              rs2.next
//            }) {
//              pro_num = rs2.getString("N_PROVID")
//              PRO = rs2.getString("S_PROVNAME").trim
//              //                            System.out.println(PRO);
//            }
//          }
//        }
//      }
//
//      for (i<-0 to (a.length-1)){
//        val b=a11(i).split("/")
//        HBase_Con.Hbase_insert(conn,"company1","com_info","reg_no",b(0))
//        HBase_Con.Hbase_insert(conn,"company1","com_info","com_name",b(2))
//        HBase_Con.Hbase_insert(conn,"company1","com_info","ZB",b(3))
//        HBase_Con.Hbase_insert(conn,"company1","com_info","RQ",b(4))
//        HBase_Con.Hbase_insert(conn,"company1","com_info","FW",b(5))
//        HBase_Con.Hbase_insert(conn,"company1","com_info","PRO",b(6))
//      }
//
//
//      {
//        i += 1; i - 1
//      }
//    }
//  }
//}
