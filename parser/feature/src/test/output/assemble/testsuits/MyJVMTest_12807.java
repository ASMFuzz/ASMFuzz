import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_12807 {

    static String e = "XmY4-7x8@+";

    boolean add(String e) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12807().add(e));
    }
}
