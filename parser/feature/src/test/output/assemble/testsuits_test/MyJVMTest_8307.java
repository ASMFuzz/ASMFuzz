import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_8307 {

    static Collection<?> c = null;

    boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8307().removeAll(c));
    }
}
