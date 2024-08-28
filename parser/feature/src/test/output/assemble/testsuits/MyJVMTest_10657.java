import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.*;

public class MyJVMTest_10657 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static Random r = new Random();

    static int N = 50;

    static Set<Path> paths = new HashSet<>();

    static String name = "D*r6?-:mx|";

    static Map<ZipEntry, byte[]> entries = new HashMap<ZipEntry,byte[]>();

    static BasicFileAttributes attrs = null;

    static long lastModified = -9223372036854775808L;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10657().check(cond));
    }
}
