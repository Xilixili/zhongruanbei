//package ReadHBase
//
//import com.sun.jna.{Library, Native}
//
///**
//  * Created by maplejaw on 2017/2/8.
//  */
//trait CLibrary extends Library{
//
//
//  //初始化
//  def NLPIR_Init(sDataPath: String, encoding: Int, sLicenceCode: String): Int
//
//  //对字符串进行分词
//  def NLPIR_ParagraphProcess(sSrc: String, bPOSTagged: Int): String
//
//  //对TXT文件内容进行分词
//  def NLPIR_FileProcess(sSourceFilename: String, sResultFilename: String, bPOStagged: Int): Double
//
//  //从字符串中提取关键词
//  def NLPIR_GetKeyWords(sLine: String, nMaxKeyLimit: Int, bWeightOut: Boolean): String
//
//  //从TXT文件中提取关键词
//  def NLPIR_GetFileKeyWords(sLine: String, nMaxKeyLimit: Int, bWeightOut: Boolean): String
//
//  //添加单条用户词典
//  def NLPIR_AddUserWord(sWord: String): Int
//
//  //删除单条用户词典
//  def NLPIR_DelUsrWord(sWord: String): Int
//
//  //从TXT文件中导入用户词典
//  def NLPIR_ImportUserDict(sFilename: String,bOverwrite: Boolean ): Int
//
//  //将用户词典保存至硬盘
//  def NLPIR_SaveTheUsrDic: Int
//
//  //从字符串中获取新词
//  def NLPIR_GetNewWords(sLine: String, nMaxKeyLimit: Int, bWeightOut: Boolean): String
//
//  //从TXT文件中获取新词
//  def NLPIR_GetFileNewWords(sTextFile: String, nMaxKeyLimit: Int, bWeightOut: Boolean): String
//
//  //获取一个字符串的指纹值
//  def NLPIR_FingerPrint(sLine: String): Long
//
//  //设置要使用的POS map
//  def NLPIR_SetPOSmap(nPOSmap: Int): Int
//
//  //获取关键词的词频
//  def NIPIR_WordFreqStat(Input:String):String
//
//  //获取报错日志
//  def NLPIR_GetLastErrorMsg: String
//
//  //退出
//  def NLPIR_Exit()
//
//
//}
//
//object CLibrary{
//
//  def getInstance(nlpir_dir: String): CLibrary = {
//    // 定义初始化接口
//    val Instance = Native.loadLibrary(nlpir_dir, classOf[CLibrary]).asInstanceOf[CLibrary]
//    Instance
//  }
//}