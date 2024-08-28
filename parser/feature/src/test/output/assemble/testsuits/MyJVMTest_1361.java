import java.io.*;

public class MyJVMTest_1361 {

    static double radius = 0.4094482869013416;

    static double angle = Double.MAX_VALUE;

    double getY() {
        return radius * Math.sin(angle);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1361().getY());
    }
}
