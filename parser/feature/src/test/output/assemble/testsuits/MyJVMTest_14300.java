import java.io.*;

public class MyJVMTest_14300 {

    static String s = ")'eee|8g<5";

    String mm(String s) {
        return "mref" + s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14300().mm(s));
    }
}
