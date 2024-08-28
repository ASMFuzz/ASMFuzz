import java.io.*;

public class MyJVMTest_11039 {

    static ObjectInputStream pr = new ObjectInputStream();

    static int ii = 17;

    static int[] tmp = {4,0,0,-4887357,3,749907838,8,0,-1412953071,0};

    ObjectInputStream readObject(ObjectInputStream pr) throws IOException {
        tmp = new int[32];
        pr.readUTF();
        ii = pr.readInt();
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11039().readObject(pr);
    }
}
