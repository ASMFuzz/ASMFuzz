import java.io.*;

public class MyJVMTest_3351 {

    static ObjectInputStream in = new ObjectInputStream();

    ObjectInputStream readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        throw new ClassNotFoundException();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3351().readObject(in);
    }
}
