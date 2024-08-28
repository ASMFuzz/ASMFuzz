import java.io.*;
import java.net.URI;

public class MyJVMTest_5237 {

    static String op = "9+7S]||$@&";

    static String gotParam1Param1 = "bza>yr;1so";

    static String gotParam1Param2 = "KVR)h<Byyi";

    static String gotParam1Param3 = "vkv'M2{KUI";

    static String gotParam1Param4 = "Pux\"6V%lh\"";

    static String gotParam1Param5 = "xJ{ddZpM-Q";

    static URI gotParam1 = new URI(gotParam1Param1, gotParam1Param2, gotParam1Param3, gotParam1Param4, gotParam1Param5);

    static File got = new File(gotParam1);

    static String ansParam1Param1 = "S7|[bn_zq5";

    static String ansParam1Param2 = "%kfCo[tTp3";

    static String ansParam1Param3 = "u8Sghw#!,l";

    static String ansParam1Param4 = "<\\*Bku}2z0";

    static URI ansParam1 = new URI(ansParam1Param1, ansParam1Param2, ansParam1Param3, ansParam1Param4);

    static File ans = new File(ansParam1);

    File ck(String op, File got, File ans) throws Exception {
        if (!got.equals(ans))
            throw new Exception(op + " incorrect");
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5237().ck(op, got, ans);
    }
}
