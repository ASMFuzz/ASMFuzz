import java.io.*;

public class MyJVMTest_6404 {

    static String op = ".L^6u'^P)N";

    static String fParam1 = "A#|ed*i7[_";

    static String fParam2 = " t;;xFA=QG";

    static File f = new File(fParam1, fParam2);

    static String[] ls = { "d\\? ''1OAc", "%zf+PWB>S?", "s|eLOY\"bF'", "P/l9>c>BMw", "\\j[{Hj4\"a?", "(,r_2lh%%X", "|9KuEdc)4~", ";e7p\"II-jc", "F7X)p]}wTV", "7$V\"|ffn0a" };

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
        new MyJVMTest_6404().ck(op, f, ls, lf);
    }
}
