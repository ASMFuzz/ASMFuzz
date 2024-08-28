public class MyJVMTest_5266 {

    int test() {
        Object[] arrayref = null;
        try {
            Object obj = arrayref[0];
            return 2;
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5266().test());
    }
}
