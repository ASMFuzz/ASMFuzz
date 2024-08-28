public class MyJVMTest_6623 {

    static Object o = new Object() {

        Object m() {
            return o2;
        }
    };

    static Object o2 = o;

    Object m() {
        return o2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6623().m());
    }
}
