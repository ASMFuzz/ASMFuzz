import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_5241 {

    static Collection<? extends String> c = null;

    boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5241().addAll(c));
    }
}
