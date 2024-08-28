import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.modelmbean.*;

public class MyJVMTest_1838 {

    static int x = 7;

    int addOne(int x) {
        return x + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1838().addOne(x));
    }
}
