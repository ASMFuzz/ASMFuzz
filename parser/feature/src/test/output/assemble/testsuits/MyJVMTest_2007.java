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

public class MyJVMTest_2007 {

    static byte[] name = { 84, 82, 52, -110, -7, -88, 41, 33, 67, -84 };

    String getString(byte[] name) {
        return new String(name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2007().getString(name));
    }
}
