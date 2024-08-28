import java.awt.*;
import java.text.*;
import java.util.*;
import java.io.*;

public class MyJVMTest_11553 {

    static DecimalFormat _decFormat = (DecimalFormat) NumberFormat.getInstance();

    String Update() {
        Random r = new Random();
        return _decFormat.format(r.nextDouble());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11553().Update());
    }
}
