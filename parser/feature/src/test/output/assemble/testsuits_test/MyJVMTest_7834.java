public class MyJVMTest_7834 {

    static T x = null;

    <T> boolean isOK(T x) {
        return isOK(x);
    }

    <T> boolean isStillOK(T x) {
        return true && isOK(x);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7834().isStillOK(x));
    }
}
