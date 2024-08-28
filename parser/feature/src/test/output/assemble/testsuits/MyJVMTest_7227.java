import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_7227 {

    static char arg = Character.MAX_VALUE;

    String n_char(char arg) {
        return "";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7227().n_char(arg));
    }
}
