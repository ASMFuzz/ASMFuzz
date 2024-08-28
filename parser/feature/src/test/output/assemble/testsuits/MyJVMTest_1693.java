import java.io.*;

public class MyJVMTest_1693 {

    static ObjectInputStream in = new ObjectInputStream();

    @SuppressWarnings("serial")
    static Object obj = new Bar();

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (obj == null) {
            throw new Error("ClassNotFoundException masked by defaultReadObject()");
        }
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1693().readObject(in);
    }
}
