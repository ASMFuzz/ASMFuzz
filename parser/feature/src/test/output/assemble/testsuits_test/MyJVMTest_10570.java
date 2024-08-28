import java.io.*;

public class MyJVMTest_10570 {

    static double radius = Double.NaN;

    static double angle = Double.MIN_VALUE;

    double getY() {
        return radius * Math.sin(angle);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10570().getY());
    }
}
