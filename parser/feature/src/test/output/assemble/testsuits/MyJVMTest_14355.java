import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.jar.*;
import javax.tools.*;
import javax.tools.StandardJavaFileManager.*;

public class MyJVMTest_14355 {

    static T single = null;

    <T> Iterable<T> iterable(T single) {
        return Collections.singleton(single);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14355().iterable(single));
    }
}
