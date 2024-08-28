import java.io.*;

public class MyJVMTest_11187 {

    Object readResolve() throws ObjectStreamException {
        throw new Error("package-private readResolve called");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11187().readResolve());
    }
}
