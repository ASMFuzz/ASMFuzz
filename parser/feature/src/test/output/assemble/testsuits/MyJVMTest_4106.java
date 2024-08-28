import java.io.*;

public class MyJVMTest_4106 {

    static OutputStream outParam1 = new ByteArrayOutputStream();

    static ObjectOutputStream out = new ObjectOutputStream(outParam1);

    static double radius = Double.POSITIVE_INFINITY;

    static double angle = Double.POSITIVE_INFINITY;

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("x", radius * Math.cos(angle));
        fields.put("y", radius * Math.sin(angle));
        out.writeFields();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4106().writeObject(out);
    }
}
