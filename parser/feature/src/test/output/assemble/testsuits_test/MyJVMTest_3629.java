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

public class MyJVMTest_3629 {

    static int indent = 0;

    void indent() {
        int n = 0;
        while (n++ < indent) System.out.printf(" ");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3629().indent();
    }
}
