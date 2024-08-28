import java.io.*;
import java.util.*;

public class MyJVMTest_13574 {

    static String tParam1 = "Nl\"f*)]#t?";

    static String tParam2Param1Param1 = "`!Te23jT2 ";

    static String tParam2Param1Param2Param1 = "D\"6ONV=-'b";

    static String tParam2Param1Param2Param2Param1 = "*'<%f3oz_B";

    static Throwable tParam2Param1Param2Param2Param2 = new Throwable();

    static boolean tParam2Param1Param2Param2Param3 = true;

    static boolean tParam2Param1Param2Param2Param4 = true;

    static Throwable tParam2Param1Param2Param2 = new Throwable(tParam2Param1Param2Param2Param1, tParam2Param1Param2Param2Param2, tParam2Param1Param2Param2Param3, tParam2Param1Param2Param2Param4);

    static Throwable tParam2Param1Param2 = new Throwable(tParam2Param1Param2Param1, tParam2Param1Param2Param2);

    static boolean tParam2Param1Param3 = false;

    static boolean tParam2Param1Param4 = true;

    static Throwable tParam2Param1 = new Throwable(tParam2Param1Param1, tParam2Param1Param2, tParam2Param1Param3, tParam2Param1Param4);

    static Throwable tParam2 = new Throwable(tParam2Param1);

    static Throwable t = new Throwable(tParam1, tParam2);

    Throwable reconstitute(Throwable t) {
        Throwable result = null;
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout)) {
            out.writeObject(t);
            out.flush();
            try (ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
                ObjectInputStream in = new ObjectInputStream(bin)) {
                result = (Throwable) in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13574().reconstitute(t));
    }
}
