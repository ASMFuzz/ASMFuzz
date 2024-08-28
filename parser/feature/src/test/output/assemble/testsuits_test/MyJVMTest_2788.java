import java.net.*;
import java.text.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;
import com.sun.net.httpserver.*;
import javax.security.auth.*;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;

public class MyJVMTest_2788 {

    static PrintStream ps = null;

    static DateFormat df = null;

    String description() {
        return "Request logger";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2788().description());
    }
}
