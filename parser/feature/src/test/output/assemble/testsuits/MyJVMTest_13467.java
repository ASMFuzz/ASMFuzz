import java.io.*;

public class MyJVMTest_13467 {

    static ObjectOutputStream out = new ObjectOutputStream();

    static double radius = Double.NEGATIVE_INFINITY;

    static double angle = 0d;

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("x", radius * Math.cos(angle));
        fields.put("y", radius * Math.sin(angle));
        out.writeFields();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13467().writeObject(out);
    }
}
