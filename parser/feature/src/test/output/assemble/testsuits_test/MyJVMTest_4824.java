import java.io.*;

public class MyJVMTest_4824 {

    static double radius = 0d;

    static double angle = 0d;

    double getX() {
        return radius * Math.cos(angle);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4824().getX());
    }
}
