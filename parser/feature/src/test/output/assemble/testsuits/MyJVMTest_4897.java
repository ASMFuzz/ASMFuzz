import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_4897 {

    static String[] data = { "Quux", "Quux", "&&&/foo.Bar", "foo.Bar", "foo.Bar", "quux/Quux", "*" };

    Object[] toArray() {
        return data.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4897().toArray()));
    }
}
