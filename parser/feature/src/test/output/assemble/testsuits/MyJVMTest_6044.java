public class MyJVMTest_6044 {

    static int field = 3;

    String method(int field) {
        try {
            return null;
        } finally {
            field += 1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6044().method(field));
    }
}
