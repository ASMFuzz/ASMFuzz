import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.*;

public class MyJVMTest_16385 {

    static String msg = "eAtj}5Go2m";

    static Random r = new Random();

    static int N = 50;

    static Set<Path> paths = new HashSet<>();

    static String name = "<7V`p)~EvY";

    static Map<ZipEntry, byte[]> entries = new HashMap<ZipEntry,byte[]>();

    static BasicFileAttributes attrs = null;

    static long lastModified = 0;

    static int passed = 0, failed = 0;

    String pass(String msg) {
        System.out.println(msg);
        passed++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16385().pass(msg);
    }
}
