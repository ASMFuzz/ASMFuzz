import java.io.*;

public class MyJVMTest_3282 {

    static ObjectInputStream in = new ObjectInputStream();

    static int i = 591513882;

    static float f = 0.52848744f;

    ObjectInputStream readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        i = in.readInt();
        f = in.readFloat();
        return in;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3282().readObject(in);
    }
}
