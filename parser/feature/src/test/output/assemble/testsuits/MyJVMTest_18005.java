import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_18005 {

    static Collection<?> c = null;

    boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18005().containsAll(c));
    }
}
