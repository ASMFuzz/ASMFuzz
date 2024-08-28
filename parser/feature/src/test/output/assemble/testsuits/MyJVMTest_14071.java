public class MyJVMTest_14071 {

    static String s = "=gJHo\"kZ#y";

    String getUnicodeString(String s) {
        String unicodeString = "";
        for (int j = 0; j < s.length(); j++) {
            unicodeString += "0x" + Integer.toString(s.charAt(j), 16);
        }
        return unicodeString;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14071().getUnicodeString(s));
    }
}
