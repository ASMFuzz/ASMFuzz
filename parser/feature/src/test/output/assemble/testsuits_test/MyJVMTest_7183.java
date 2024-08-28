import java.nio.file.*;
import java.io.*;
import java.lang.reflect.*;

public class MyJVMTest_7183 {

    static String tParam1Param1 = ",.8zPgX3$^";

    static Throwable tParam1 = new Throwable(tParam1Param1);

    static Throwable t = new Throwable(tParam1);

    static Throwable cause = new Throwable();

    Field hackCause(Throwable t, Throwable cause) throws NoSuchFieldException, IllegalAccessException {
        Field f = Throwable.class.getDeclaredField("cause");
        f.setAccessible(true);
        f.set(t, cause);
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7183().hackCause(t, cause);
    }
}
