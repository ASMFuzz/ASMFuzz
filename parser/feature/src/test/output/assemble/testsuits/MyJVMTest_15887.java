import java.io.*;
import java.net.URI;

public class MyJVMTest_15887 {

    static String op = "D9^e*l6T_G";

    static String fParam1Param1 = "OMb=ubZk8#";

    static String fParam1Param2 = "La%#l`#<8'";

    static String fParam1Param3 = "BZK~psV58K";

    static String fParam1Param4 = "r;G'e]sV~F";

    static String fParam1Param5 = "Hk6F$P^Gar";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3, fParam1Param4, fParam1Param5);

    static File f = new File(fParam1);

    static String[] ls = { "5|0S)(`>,f", ".c:C/RysDv", "Xd^[R1_NBj", "wa*@K2%lU-", "$QyaL L;u6", "mWs\\Em0SJB", "aFJtI2<1k*", ":OuM}aSP3t", "'X0^,,EP6@", "jB&h<@~8LW" };

    static File[] lf = { null, null, null, null, null, null, null, null, null, null };

    File[] ck(String op, File f, String[] ls, File[] lf) throws Exception {
        System.err.println("--- " + op);
        int n = lf.length;
        if (ls.length != n)
            throw new Exception("listFiles returned incorrect count");
        for (int i = 0; i < n; i++) {
            if (ls[i].equals(lf[i].getName()) && lf[i].getParentFile().equals(f)) {
                System.err.println(ls[i] + " ==> " + lf[i]);
            } else {
                throw new Exception("list mismatch: " + ls[i] + ", " + lf[i]);
            }
        }
        return lf;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15887().ck(op, f, ls, lf);
    }
}
