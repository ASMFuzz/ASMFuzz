import java.io.*;

public class MyJVMTest_10608 {

    static byte[] inParam1Param1 = { 63, 80, -76, 120, -80, -63, -101, 11, 15, -10 };

    static int inParam1Param2 = 578;

    static int inParam1Param3 = 459;

    static InputStream inParam1 = new ByteArrayInputStream(inParam1Param1, inParam1Param2, inParam1Param3);

    static ObjectInputStream in = new ObjectInputStream(inParam1);

    static double radius = Double.MIN_VALUE;

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
        new MyJVMTest_10608().readObject(in);
    }
}
