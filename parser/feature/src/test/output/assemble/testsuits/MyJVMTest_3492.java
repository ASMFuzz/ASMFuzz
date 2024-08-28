import java.io.*;

public class MyJVMTest_3492 {

    static ObjectInputStream pr = new ObjectInputStream();

    static int i = 7;

    static int[] tmp = {1932390277,4,3,2,-530318850,1,2,711041163,0,0};

    ObjectInputStream readObject(ObjectInputStream pr) throws IOException {
        tmp = new int[32];
        i = pr.readInt();
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3492().readObject(pr);
    }
}
