import java.io.*;
import java.util.*;
import java.util.jar.*;
import java.net.URI;

public class MyJVMTest_17192 {

    static String filesParam1Param1 = "#RqY6Jjif4";

    static String filesParam1Param2 = "q(yh(=VW0i";

    static String filesParam1Param3 = "4pa92Y=C]'";

    static int filesParam1Param4 = 640;

    static String filesParam1Param5 = "!x^])8Vw\";";

    static String filesParam1Param6 = "3U_HB/z\"\"4";

    static String filesParam1Param7 = "x\\6. W{st,";

    static URI filesParam1 = new URI(filesParam1Param1, filesParam1Param2, filesParam1Param3, filesParam1Param4, filesParam1Param5, filesParam1Param6, filesParam1Param7);

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
        System.out.println(new MyJVMTest_17192().createPath(files));
    }
}
