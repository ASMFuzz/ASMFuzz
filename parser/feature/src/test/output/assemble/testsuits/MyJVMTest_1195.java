import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class MyJVMTest_1195 {

    Integer initialValue() {
        return Integer.valueOf(-1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1195().initialValue());
    }
}
