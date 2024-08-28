public class MyJVMTest_13017 {

    static Object obj = new Object();

    boolean test() {
        if (obj.getClass() == Object.class) {
            synchronized (obj) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13017().test());
    }
}
