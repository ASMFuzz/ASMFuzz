import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13931 {

    static int n = 0;

    static int m = 1527221448;

    boolean similar(int n, int m) {
        return Math.abs(n - m) <= 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13931().similar(n, m));
    }
}
