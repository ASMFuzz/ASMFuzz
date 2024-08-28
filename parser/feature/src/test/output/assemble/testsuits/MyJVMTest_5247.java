import java.util.*;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;

public class MyJVMTest_5247 {

    static String name = "V>0^}rb;@l";

    static int method = 9;

    static byte[] data = {-108,112,117,12,70,2,13,-122,117,-67};

    static byte[] extra = {-21,38,-31,8,-83,91,12,-52,102,-125};

    static String comment = "LSI#xtz7Vb";

    static int uniquifier = 86;

    String uniquify(String name) {
        return name + (uniquifier++);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5247().uniquify(name));
    }
}
