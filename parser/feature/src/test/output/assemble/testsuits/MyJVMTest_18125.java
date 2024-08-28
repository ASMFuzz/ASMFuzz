import java.io.*;

public class MyJVMTest_18125 {

    static byte[] prParam1Param1 = { -1, 115, -42, -103, -88, -56, -111, 83, -61, 124 };

    static InputStream prParam1 = new ByteArrayInputStream(prParam1Param1);

    static ObjectInputStream pr = new ObjectInputStream(prParam1);

    static int[] tmp = {3,8,1,2,2,1111028535,-1735373469,-1043783104,4,1};

    ObjectInputStream readObjectCleanup(ObjectInputStream pr) {
        System.err.println("\nPickleClass cleanup correctly called on abort.");
        if (tmp != null) {
            tmp = null;
        }
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18125().readObjectCleanup(pr);
    }
}
