import java.io.*;

public class MyJVMTest_10666 {

    static ObjectInputStream pr = new ObjectInputStream();

    ObjectInputStream readObject(ObjectInputStream pr) throws NotSerializableException {
        throw new NotSerializableException("NoPickleClass");
        return pr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10666().readObject(pr);
    }
}
