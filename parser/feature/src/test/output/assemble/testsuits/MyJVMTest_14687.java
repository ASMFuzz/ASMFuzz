public class MyJVMTest_14687 {

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
        System.out.println(new MyJVMTest_14687().test());
    }
}
