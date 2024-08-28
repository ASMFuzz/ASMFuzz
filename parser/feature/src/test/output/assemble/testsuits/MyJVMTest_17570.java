import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import static java.util.Collections.*;

public class MyJVMTest_17570 {

    static List<T> list = new ArrayList<T>();

    static int size = -285304324;

    <T> List<T> asSubList(List<T> list) {
        return list.subList(0, list.size());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17570().asSubList(list));
    }
}
