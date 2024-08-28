import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class MyJVMTest_10677 {

    static Integer bytesRead = 0;

    static Void att = null;

    Integer completed(Integer bytesRead, Void att) {
        throw new RuntimeException();
        return bytesRead;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10677().completed(bytesRead, att);
    }
}
