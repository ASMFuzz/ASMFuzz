import java.io.*;

public class MyJVMTest_16049 {

    static String exParam1 = "AVKD;s]l{C";

    static String exParam2Param1 = ")PQxQ2hK,=";

    static String exParam2Param2Param1 = "WZ:L}-[Uk/";

    static Throwable exParam2Param2 = new Throwable(exParam2Param2Param1);

    static Throwable exParam2 = new Throwable(exParam2Param1, exParam2Param2);

    static RuntimeException ex = new RuntimeException(exParam1, exParam2);

    RuntimeException throwMe(RuntimeException ex) throws RuntimeException {
        throw ex;
        return ex;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16049().throwMe(ex);
    }
}
