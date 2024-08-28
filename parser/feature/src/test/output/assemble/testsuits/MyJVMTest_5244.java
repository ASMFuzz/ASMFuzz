import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;
import javax.management.relation.*;

public class MyJVMTest_5244 {

    int getFive() {
        return 5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5244().getFive());
    }
}
