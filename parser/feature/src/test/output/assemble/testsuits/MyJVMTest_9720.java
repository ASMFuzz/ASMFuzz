import java.io.*;

public class MyJVMTest_9720 {

    Object readResolve() throws ObjectStreamException {
        return new D();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9720().readResolve());
    }
}
