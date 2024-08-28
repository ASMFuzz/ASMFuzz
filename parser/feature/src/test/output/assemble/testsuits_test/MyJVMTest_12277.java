import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.zip.*;

public class MyJVMTest_12277 {

    static Random r = new Random();

    static int N = 50;

    static Set<Path> paths = new HashSet<>();

    static String name = "wM_R3KSUyl";

    static Map<ZipEntry, byte[]> entries = new HashMap<ZipEntry,byte[]>();

    static BasicFileAttributes attrs = null;

    static long lastModified = -9223372036854775808L;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12277().pass();
    }
}
