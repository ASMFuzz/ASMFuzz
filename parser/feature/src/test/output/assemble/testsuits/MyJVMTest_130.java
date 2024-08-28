import java.io.*;
import java.lang.instrument.*;
import java.lang.invoke.*;
import java.lang.management.*;
import java.lang.reflect.*;
import java.nio.file.*;
import java.security.*;
import java.util.jar.*;
import javax.tools.*;

public class MyJVMTest_130 {

    Object getName() {
        int fooInt = 1;
        if (true) {
            fooInt <<= 0x7;
        }
        return "foo" + fooInt;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_130().getName());
    }
}
