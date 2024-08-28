import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_16750 {

    static char arg = '0';

    String n_char(char arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16750().n_char(arg));
    }
}
