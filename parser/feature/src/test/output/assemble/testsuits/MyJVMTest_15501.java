public class MyJVMTest_15501 {

    static int field = 9;

    String method(int field) {
        try {
            return null;
        } finally {
            field += 1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15501().method(field));
    }
}
