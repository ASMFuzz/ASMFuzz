import java.io.*;

public class MyJVMTest_1397 {

    static ObjectInputStream in = new ObjectInputStream();

    static double radius = Double.MAX_VALUE;

    static double angle = Double.NEGATIVE_INFINITY;

    double readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        ObjectInputStream.GetField fields = in.readFields();
        double x = fields.get("x", 0);
        double y = fields.get("y", 0.0);
        radius = Math.sqrt(x * x + y * y);
        angle = Math.atan2(y, x);
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1397().readObject(in);
    }
}
