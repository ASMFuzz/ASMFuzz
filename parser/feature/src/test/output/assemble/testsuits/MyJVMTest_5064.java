import java.io.*;

public class MyJVMTest_5064 {

    void testWin32() throws Exception {
        File f1 = new File("a");
        File f2 = new File("B");
        if (!(f1.compareTo(f2) < 0))
            throw new Exception("compareTo incorrect");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5064().testWin32();
    }
}
