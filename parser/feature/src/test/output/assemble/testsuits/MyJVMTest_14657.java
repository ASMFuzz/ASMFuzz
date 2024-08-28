import java.io.*;

public class MyJVMTest_14657 {

    static String op = "/`VejG&6cq";

    static String gotParam1 = "fmIIiY5M' ";

    static File got = new File(gotParam1);

    static String ansParam1 = "upyL,P~DjJ";

    static File ans = new File(ansParam1);

    File ck(String op, File got, File ans) throws Exception {
        if (!got.equals(ans))
            throw new Exception(op + " incorrect");
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14657().ck(op, got, ans);
    }
}
