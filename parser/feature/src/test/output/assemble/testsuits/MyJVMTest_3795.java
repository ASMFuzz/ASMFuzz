import java.io.*;

public class MyJVMTest_3795 {

    static Object obj = -478866016;

    ObjectOutputStream writeRead(Object obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(bout);
        oout.writeObject(obj);
        oout.close();
        ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        oin.readObject();
        return oout;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3795().writeRead(obj);
    }
}
