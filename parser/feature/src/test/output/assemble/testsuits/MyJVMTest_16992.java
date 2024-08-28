import java.security.*;

public class MyJVMTest_16992 {

    static int count = 0;

    boolean isUsed() {
        return (count != 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16992().isUsed());
    }
}
