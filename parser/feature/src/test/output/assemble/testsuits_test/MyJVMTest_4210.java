import java.io.*;
import java.util.*;

public class MyJVMTest_4210 {

    static String tParam1Param1 = "\"Q%e`%b5o3";

    static String tParam1Param2Param1 = "w,+q]M4,>C";

    static Throwable tParam1Param2Param2 = new Throwable();

    static boolean tParam1Param2Param3 = false;

    static boolean tParam1Param2Param4 = true;

    static Throwable tParam1Param2 = new Throwable(tParam1Param2Param1, tParam1Param2Param2, tParam1Param2Param3, tParam1Param2Param4);

    static boolean tParam1Param3 = true;

    static boolean tParam1Param4 = false;

    static Throwable tParam1 = new Throwable(tParam1Param1, tParam1Param2, tParam1Param3, tParam1Param4);

    static Throwable t = new Throwable(tParam1);

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
        System.out.println(new MyJVMTest_4210().reconstitute(t));
    }
}
