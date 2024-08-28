import java.lang.annotation.*;
import java.util.*;
import javax.annotation.processing.*;

public class MyJVMTest_12615 {

    static String[] data = { "Quux", "Quux", "&&&/foo.Bar", "foo.Bar", "foo.Bar", "quux/Quux", "*" };

    int size() {
        return data.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12615().size());
    }
}
