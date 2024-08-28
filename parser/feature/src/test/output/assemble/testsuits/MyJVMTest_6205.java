import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_6205 {

    static String[] args = { "!Psd\"]=olB", "Nd:!4dLYnf", "+u@U=2c+^b", "a[o6i:j:L)", "fstFQ*>p\\q", "|hrfD?iK}u", "%/R}1M+BjZ", "`?(Ow;p,Lt", "`~v+#, )x`", "r*%/[s Wn." };

    static boolean separateServerThread = true;

    static String tmAlgorithm = "j[K?,x<3+3";

    static String enabledProtocol = "H-?W?&kkbD";

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    String[] parseArguments(String[] args) {
        tmAlgorithm = args[0];
        enabledProtocol = args[1];
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6205().parseArguments(args);
    }
}
