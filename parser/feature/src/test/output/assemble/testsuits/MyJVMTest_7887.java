public class MyJVMTest_7887 {

    static String str = ":,0H?U}nF ";

    String unquote(String str) {
        int length = (str == null) ? 0 : str.length();
        if (length > 1 && str.charAt(0) == '\"' && str.charAt(length - 1) == '\"') {
            return str.substring(1, length - 1);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7887().unquote(str));
    }
}
