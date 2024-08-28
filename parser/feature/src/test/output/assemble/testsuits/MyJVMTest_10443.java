import java.io.*;

public class MyJVMTest_10443 {

    Object writeReplace() throws ObjectStreamException {
        return new C();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10443().writeReplace());
    }
}
