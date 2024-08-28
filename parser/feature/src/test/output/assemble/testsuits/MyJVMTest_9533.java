import java.io.*;

public class MyJVMTest_9533 {

    static OutputStream pwParam1 = new ByteArrayOutputStream();

    static ObjectOutputStream pw = new ObjectOutputStream(pwParam1);

    ObjectOutputStream writeObject(ObjectOutputStream pw) throws NotSerializableException {
        throw new NotSerializableException("NoPickleClass");
        return pw;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9533().writeObject(pw);
    }
}
