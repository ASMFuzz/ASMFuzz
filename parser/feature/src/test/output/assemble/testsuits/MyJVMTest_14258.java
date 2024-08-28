import java.lang.instrument.ClassFileTransformer;

public class MyJVMTest_14258 {

    void makeGarbage() {
        for (int x = 0; x < 10; x++) {
            Object[] a = new Object[10000];
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14258().makeGarbage();
    }
}
