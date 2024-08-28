import java.io.*;

public class MyJVMTest_554 {

    Object readResolve() throws ObjectStreamException {
        return new D();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_554().readResolve());
    }
}
