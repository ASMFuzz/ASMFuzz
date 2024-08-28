import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_14661 {

    static Collection<? extends String> c = null;

    boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14661().addAll(c));
    }
}
