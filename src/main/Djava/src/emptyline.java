public class emptyline {

    public static void main(String[] args) throws Exception {
        String string=",于伟峰\n" +
                "监事,谷亚\n" +
                "\n" +
                "经理,肥\n" +
                "侣中\n" +
                "兵";
        string=string.replaceAll("(\\n\\s)", "");
        System.out.print(string);
    }
}
