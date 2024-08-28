public class MyJVMTest_4678 {

    static String s = "`eAx@oAc?5";

    String getUnicodeString(String s) {
        String unicodeString = "";
        for (int j = 0; j < s.length(); j++) {
            unicodeString += "0x" + Integer.toString(s.charAt(j), 16);
        }
        return unicodeString;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4678().getUnicodeString(s));
    }
}
