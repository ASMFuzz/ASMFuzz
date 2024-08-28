import java.io.*;

public class MyJVMTest_16573 {

    static String x = "E`BQFN\\>Ck";

    String convert(String x) {
        return "*" + x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16573().convert(x));
    }
}
