import java.io.*;

public class MyJVMTest_10340 {

    static ObjectOutputStream out = new ObjectOutputStream();

    static String str = "foo";

    ObjectOutputStream writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField pf = out.putFields();
        pf.put("str", "bar");
        out.writeFields();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10340().writeObject(out);
    }
}
