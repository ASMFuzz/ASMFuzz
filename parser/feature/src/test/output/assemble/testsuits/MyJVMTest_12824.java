import java.io.*;

public class MyJVMTest_12824 {

    static byte[] prParam1Param1 = { -28, 44, -85, 45, -63, -99, -124, 84, -122, 126 };

    static int prParam1Param2 = 616;

    static int prParam1Param3 = 91;

    static InputStream prParam1 = new ByteArrayInputStream(prParam1Param1, prParam1Param2, prParam1Param3);

    static ObjectInputStream pr = new ObjectInputStream(prParam1);

    static int i = 7;

    static int[] tmp = {7,2,715251570,6,-1430476821,1,-1082362816,0,0,-293126158};

    ObjectInputStream readObject(ObjectInputStream pr) throws IOException {
        tmp = new int[32];
        i = pr.readInt();
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12824().readObject(pr);
    }
}
