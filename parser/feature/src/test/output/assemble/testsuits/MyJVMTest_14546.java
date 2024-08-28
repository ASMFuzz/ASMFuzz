import java.io.*;

public class MyJVMTest_14546 {

    static int pwParam1Param1 = 885;

    static OutputStream pwParam1 = new ByteArrayOutputStream(pwParam1Param1);

    static ObjectOutputStream pw = new ObjectOutputStream(pwParam1);

    static int i = 7;

    ObjectOutputStream writeObject(ObjectOutputStream pw) throws IOException {
        pw.writeInt(i);
        return pw;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14546().writeObject(pw);
    }
}
