import java.io.*;

public class MyJVMTest_5615 {

    static String eParam1 = "E%POP8BRo(";

    static String eParam2Param1 = "a\\?}T7Q#eN";

    static Throwable eParam2 = new Throwable(eParam2Param1);

    static Throwable e = new Throwable(eParam1, eParam2);

    Throwable test(Throwable e) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(e);
        out.flush();
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bin);
        Throwable clone = (Throwable) in.readObject();
        return clone;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5615().test(e));
    }
}
