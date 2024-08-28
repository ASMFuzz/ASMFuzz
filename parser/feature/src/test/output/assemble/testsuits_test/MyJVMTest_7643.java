import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_7643 {

    static String filesParam1 = "sLX950\\F}4";

    static File files = new File(filesParam1);

    String createPath(File... files) {
        StringBuilder sb = new StringBuilder();
        for (File f : files) {
            if (sb.length() > 0)
                sb.append(File.pathSeparatorChar);
            sb.append(f.getPath());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7643().createPath(files));
    }
}
