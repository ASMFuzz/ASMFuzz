import java.net.*;

public class MyJVMTest_7958 {

    static String s = "EZo>{Ag8Rv";

    String printString(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print((int) s.charAt(i) + " ");
        }
        System.out.println();
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7958().printString(s);
    }
}
