import java.io.*;

public class MyJVMTest_10045 {

    static byte[] prParam1Param1 = { -7, -127, 18, 59, 121, -49, 100, 15, -8, -116 };

    static int prParam1Param2 = 628;

    static int prParam1Param3 = 496;

    static InputStream prParam1 = new ByteArrayInputStream(prParam1Param1, prParam1Param2, prParam1Param3);

    static ObjectInputStream pr = new ObjectInputStream(prParam1);

    static int i = 7;

    static int[] tmp = {0,0,1524517484,0,0,1,9,914452995,1,4};

    ObjectInputStream readObjectCleanup(ObjectInputStream pr) {
        System.err.println("\nCleanup called on abort");
        if (tmp != null) {
            tmp = null;
        }
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10045().readObjectCleanup(pr);
    }
}
