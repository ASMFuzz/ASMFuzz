public class MyJVMTest_3387 {

    static String toAdd = "0123456789abcdef";

    static String s = "v9zQ#A\\xBJ";

    void test() {
        s = s + toAdd;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3387().test();
    }
}
