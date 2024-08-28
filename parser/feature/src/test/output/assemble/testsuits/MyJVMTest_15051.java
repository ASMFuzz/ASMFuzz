import java.io.*;

public class MyJVMTest_15051 {

    static String eParam1 = "#4E^Ei|14:";

    static String eParam2Param1 = "p1b$|_v$wK";

    static Throwable eParam2Param2 = new Throwable();

    static Throwable eParam2 = new Throwable(eParam2Param1, eParam2Param2);

    static boolean eParam3 = false;

    static boolean eParam4 = true;

    static Throwable e = new Throwable(eParam1, eParam2, eParam3, eParam4);

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
        System.out.println(new MyJVMTest_15051().test(e));
    }
}
