import java.io.*;

public class MyJVMTest_13136 {

    static Object obj = 2107123463;

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
        new MyJVMTest_13136().writeRead(obj);
    }
}
