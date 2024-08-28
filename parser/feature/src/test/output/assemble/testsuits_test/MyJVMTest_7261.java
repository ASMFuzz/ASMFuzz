import java.lang.reflect.*;

public class MyJVMTest_7261 {

    static U[] array1 = { null, null, null, null, null, null, null, null, null, null };

    U[] bar(U[] array1) {
        return;
        return array1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7261().bar(array1);
    }
}
