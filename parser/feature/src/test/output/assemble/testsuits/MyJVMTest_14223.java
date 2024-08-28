import java.io.*;

public class MyJVMTest_14223 {

    static double radius = Double.NEGATIVE_INFINITY;

    static double angle = Double.MIN_VALUE;

    double getX() {
        return radius * Math.cos(angle);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14223().getX());
    }
}
