import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class MyJVMTest_13337 {

    static String excParam1 = ".L'~2N}=|R";

    static Throwable exc = new Throwable(excParam1);

    static Void att = null;

    Throwable failed(Throwable exc, Void att) {
        throw new RuntimeException(exc);
        return exc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13337().failed(exc, att);
    }
}
