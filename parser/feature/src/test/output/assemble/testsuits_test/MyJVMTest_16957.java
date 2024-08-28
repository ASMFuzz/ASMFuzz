import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

public class MyJVMTest_16957 {

    static int outParam1Param1 = 112;

    static OutputStream outParam1 = new ByteArrayOutputStream(outParam1Param1);

    static ObjectOutputStream out = new ObjectOutputStream(outParam1);

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        throw new RuntimeException("wrote a parameter whos writeObject " + "method always throws a RuntimeException");
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16957().writeObject(out);
    }
}
