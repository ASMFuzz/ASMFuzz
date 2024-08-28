import java.io.*;

public class MyJVMTest_431 {

    Object writeReplace() throws ObjectStreamException {
        return new B();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_431().writeReplace());
    }
}
