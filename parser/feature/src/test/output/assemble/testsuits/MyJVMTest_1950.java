import java.io.*;

public class MyJVMTest_1950 {

    Object readResolve() throws ObjectStreamException {
        throw new Error("package-private readResolve called");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1950().readResolve());
    }
}
