import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;
import java.nio.file.spi.*;
import java.nio.file.attribute.*;
import java.net.*;
import java.util.*;
import static java.nio.file.StandardOpenOption.*;
import static java.nio.file.StandardCopyOption.*;

public class MyJVMTest_11247 {

    static byte[] name = { 109, -69, -65, 55, -109, 81, -90, 123, -128, 8 };

    String getString(byte[] name) {
        return new String(name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11247().getString(name));
    }
}
