import java.io.*;

public class MyJVMTest_13541 {

    static OutputStream pwParam1 = new ByteArrayOutputStream();

    static ObjectOutputStream pw = new ObjectOutputStream(pwParam1);

    static int ii = 17;

    ObjectOutputStream writeObject(ObjectOutputStream pw) throws IOException {
        pw.writeUTF("PickleClass");
        pw.writeInt(ii);
        return pw;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13541().writeObject(pw);
    }
}
