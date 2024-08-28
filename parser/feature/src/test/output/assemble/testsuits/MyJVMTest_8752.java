import javax.swing.*;
import java.awt.*;

public class MyJVMTest_8752 {

    static int n = 0;

    static int m = 750506148;

    boolean similar(int n, int m) {
        return Math.abs(n - m) <= 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8752().similar(n, m));
    }
}
