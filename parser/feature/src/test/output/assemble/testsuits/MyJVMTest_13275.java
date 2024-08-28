import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import java.net.URI;

public class MyJVMTest_13275 {

    static String aParam1Param1 = "KP0q+72*o6";

    static String aParam1Param2 = "rq[I<\\'ipj";

    static String aParam1Param3 = "Pq7*,?X~hw";

    static String aParam1Param4 = "j\\tvhP>Y}L";

    static String aParam1Param5 = ";.puf%+XPz";

    static URI aParam1 = new URI(aParam1Param1, aParam1Param2, aParam1Param3, aParam1Param4, aParam1Param5);

    static File a = new File(aParam1);

    static String bParam1Param1 = "]oj-X^<lTF";

    static String bParam1Param2 = "iV}5}Ac.[/";

    static String bParam1Param3 = "v>MQ+ZKCRX";

    static int bParam1Param4 = 123;

    static String bParam1Param5 = ">H7,yH!8k-";

    static String bParam1Param6 = "?:/,,b$2@k";

    static String bParam1Param7 = "pQ\"!g,\"&Fd";

    static URI bParam1 = new URI(bParam1Param1, bParam1Param2, bParam1Param3, bParam1Param4, bParam1Param5, bParam1Param6, bParam1Param7);

    static File b = new File(bParam1);

    boolean compare(File a, File b) throws IOException {
        List<String> aLines = Files.readAllLines(a.toPath(), Charset.defaultCharset());
        List<String> bLines = Files.readAllLines(b.toPath(), Charset.defaultCharset());
        System.out.println(a + ": " + aLines.size() + " lines");
        System.out.println(b + ": " + bLines.size() + " lines");
        return aLines.equals(bLines);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13275().compare(a, b));
    }
}
