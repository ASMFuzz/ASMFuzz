import java.io.*;

public class MyJVMTest_4657 {

    static ObjectOutputStream pw = new ObjectOutputStream();

    static int i = 77;

    ObjectOutputStream writeObject(ObjectOutputStream pw) throws IOException {
        pw.writeInt(i);
        return pw;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4657().writeObject(pw);
    }
}
