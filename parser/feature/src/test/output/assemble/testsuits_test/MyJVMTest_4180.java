import java.io.*;

public class MyJVMTest_4180 {

    static int pwParam1Param1 = 314;

    static OutputStream pwParam1 = new ByteArrayOutputStream(pwParam1Param1);

    static ObjectOutputStream pw = new ObjectOutputStream(pwParam1);

    static int ii = 17;

    ObjectOutputStream writeObject(ObjectOutputStream pw) throws IOException {
        pw.writeUTF("PickleClass");
        pw.writeInt(ii);
        return pw;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4180().writeObject(pw);
    }
}
