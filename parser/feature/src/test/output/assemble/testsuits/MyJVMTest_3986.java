import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class MyJVMTest_3986 {

    static String excParam1 = ":yor)%Otip";

    static Throwable exc = new Throwable(excParam1);

    static Void att = null;

    Throwable failed(Throwable exc, Void att) {
        throw new RuntimeException(exc);
        return exc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3986().failed(exc, att);
    }
}
