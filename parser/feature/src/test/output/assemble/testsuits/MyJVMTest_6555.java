import java.io.*;

public class MyJVMTest_6555 {

    static String exParam1 = "d'aapgsO@{";

    static RuntimeException ex = new RuntimeException(exParam1);

    RuntimeException throwMe(RuntimeException ex) throws RuntimeException {
        throw ex;
        return ex;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6555().throwMe(ex);
    }
}
