import java.io.*;

public class MyJVMTest_14048 {

    static OutputStream pwParam1 = new ByteArrayOutputStream();

    static ObjectOutputStream pw = new ObjectOutputStream(pwParam1);

    static int i = 77;

    ObjectOutputStream writeObject(ObjectOutputStream pw) throws IOException {
        pw.writeInt(i);
        return pw;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14048().writeObject(pw);
    }
}
