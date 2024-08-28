import java.util.*;
import javax.management.*;
import javax.management.monitor.*;

public class MyJVMTest_18159 {

    static int n = 6;

    static Random random = new Random();

    int randomInt(int n) {
        return random.nextInt(n);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18159().randomInt(n));
    }
}
