import java.io.*;

public class MyJVMTest_1623 {

    static ObjectInputStream pr = new ObjectInputStream();

    static int i = 77;

    ObjectInputStream readObject(ObjectInputStream pr) throws IOException {
        i = pr.readInt();
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1623().readObject(pr);
    }
}
