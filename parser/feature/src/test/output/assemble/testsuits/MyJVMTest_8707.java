import java.util.Arrays;

public class MyJVMTest_8707 {

    static char[] src = new char[10];

    static int count = 0;

    void foo() {
        try {
            Arrays.copyOfRange(src, -1, 128);
            do {
            } while (true);
        } catch (ArrayIndexOutOfBoundsException ex) {
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8707().foo();
    }
}
