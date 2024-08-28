import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4543 {

    static int n = 0;

    static int m = 5;

    boolean similar(int n, int m) {
        return Math.abs(n - m) <= 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4543().similar(n, m));
    }
}
