import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.jar.*;
import javax.tools.*;
import javax.tools.StandardJavaFileManager.*;

public class MyJVMTest_12744 {

    static Iterable<T> iter = null;

    static String sep = "R+-'dfhE=l";

    <T> String join(Iterable<T> iter, String sep) {
        StringBuilder p = new StringBuilder();
        for (T t : iter) {
            if (p.length() > 0)
                p.append(' ');
            p.append(t);
        }
        return p.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12744().join(iter, sep));
    }
}
