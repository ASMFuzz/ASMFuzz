import java.net.*;
import java.util.*;

public class MyJVMTest_10474 {

    boolean isMacOS() {
        return System.getProperty("os.name").contains("OS X");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10474().isMacOS());
    }
}
