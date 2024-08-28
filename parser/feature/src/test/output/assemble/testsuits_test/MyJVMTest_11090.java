import java.io.*;

public class MyJVMTest_11090 {

    static ObjectInputStream in = new ObjectInputStream();

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        in.close();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11090().readObject(in);
    }
}
