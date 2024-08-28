import java.net.*;

public class MyJVMTest_17521 {

    static String s = "@8z%bk[ lZ";

    String printString(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print((int) s.charAt(i) + " ");
        }
        System.out.println();
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17521().printString(s);
    }
}
