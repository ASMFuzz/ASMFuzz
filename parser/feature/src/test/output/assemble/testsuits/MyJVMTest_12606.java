import java.io.*;

public class MyJVMTest_12606 {

    static ObjectInputStream in = new ObjectInputStream();

    static int i = 1726522756;

    static float f = Float.NEGATIVE_INFINITY;

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        i = in.readInt();
        f = in.readFloat();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12606().readObject(in);
    }
}
