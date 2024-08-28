import java.io.*;

public class MyJVMTest_376 {

    static ObjectOutputStream pw = new ObjectOutputStream();

    ObjectOutputStream writeObject(ObjectOutputStream pw) throws NotSerializableException {
        throw new NotSerializableException("NoPickleClass");
        return pw;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_376().writeObject(pw);
    }
}
