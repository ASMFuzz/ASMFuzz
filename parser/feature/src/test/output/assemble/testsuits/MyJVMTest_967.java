import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_967 {

    static Collection<?> c = null;

    boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_967().retainAll(c));
    }
}
