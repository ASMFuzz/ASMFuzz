import java.io.*;

public class MyJVMTest_1814 {

    static ObjectInputStream pr = new ObjectInputStream();

    static int ii = 17;

    static int[] tmp = {0,0,5,5,1,0,1575755629,-1608223745,1630862856,7};

    ObjectInputStream readObject(ObjectInputStream pr) throws IOException {
        tmp = new int[32];
        pr.readUTF();
        ii = pr.readInt();
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1814().readObject(pr);
    }
}
