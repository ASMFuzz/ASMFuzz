import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_17857 {

    static String[] data = { "Quux", "Quux", "&&&/foo.Bar", "foo.Bar", "foo.Bar", "quux/Quux", "*" };

    boolean isEmpty() {
        return data.length > 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17857().isEmpty());
    }
}
