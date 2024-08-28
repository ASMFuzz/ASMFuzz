import java.io.*;

public class MyJVMTest_10845 {

    static ObjectInputStream pr = new ObjectInputStream();

    static int i = 77;

    ObjectInputStream readObject(ObjectInputStream pr) throws IOException {
        i = pr.readInt();
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10845().readObject(pr);
    }
}
