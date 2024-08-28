public class MyJVMTest_17449 {

    static String str = "KgTw}$yj;>";

    String unquote(String str) {
        int length = (str == null) ? 0 : str.length();
        if (length > 1 && str.charAt(0) == '\"' && str.charAt(length - 1) == '\"') {
            return str.substring(1, length - 1);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17449().unquote(str));
    }
}
