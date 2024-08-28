import java.nio.file.*;
import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_16706 {

    static String tParam1 = "'nd=1:CL.D";

    static String tParam2Param1Param1 = "SN@o0#R\\0b";

    static String tParam2Param1Param2Param1 = "nv_I^EZ/k8";

    static Throwable tParam2Param1Param2 = new Throwable(tParam2Param1Param2Param1);

    static Throwable tParam2Param1 = new Throwable(tParam2Param1Param1, tParam2Param1Param2);

    static Throwable tParam2 = new Throwable(tParam2Param1);

    static boolean tParam3 = true;

    static boolean tParam4 = true;

    static Throwable t = new Throwable(tParam1, tParam2, tParam3, tParam4);

    static String causeParam1 = "ge)>>l3UA~";

    static Throwable cause = new Throwable(causeParam1);

    Field hackCause(Throwable t, Throwable cause) throws NoSuchFieldException, IllegalAccessException {
        Field f = Throwable.class.getDeclaredField("cause");
        f.setAccessible(true);
        f.set(t, cause);
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16706().hackCause(t, cause);
    }
}
