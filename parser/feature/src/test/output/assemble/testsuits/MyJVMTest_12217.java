import java.io.*;

public class MyJVMTest_12217 {

    static String eParam1 = "BiB5PBb>@,";

    static Throwable e = new Throwable(eParam1);

    ObjectOutputStream test(Throwable e) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(e);
        out.flush();
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bin);
        Throwable clone = (Throwable) in.readObject();
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12217().test(e);
    }
}
