import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class replace {
    public static void main(String[] args) throws Exception {

        /* 读入TXT文件 */
        String pathname = "C:\\Users\\admin\\Desktop\\shanxi5.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        File filename = new File(pathname); // 要读取以上路径的input。txt文件
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        line = br.readLine();
        String sb="";
        while((line = br.readLine()) != null) {
            sb=sb.concat(line);
        }
        sb.replaceAll("\n","");
        Pattern pattern= Pattern.compile("[\\d]{5,}\\*[\\u4e00-\\u9fa5]{1,}");
        Matcher matcher = pattern.matcher(sb);
        int i=0;
        while (matcher.find()){
//            System.out.println("i wei"+i);
//                System.out.println(matcher.group());
//                if (i!=0) {
                    String a = matcher.group();
                    String b1=a.split("\\*")[0];
                    String b2=a.split("\\*")[1];
                    String a1=b1.concat("\\*").concat(b2);
//                    System.out.println("a1 wei"+a1);
                    sb=sb.replaceAll(a1,"\n"+a);
//                }
                i++;
        }


        System.out.print("sb wei"+sb);
            /* 写入Txt文件 */
        File writename = new File("C:\\Users\\admin\\Desktop\\shanxi6.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
        writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        out.write(sb); // \r\n即为换行
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
    }

}
