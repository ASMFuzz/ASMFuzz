public class MyJVMTest_4168 {

    static Object o1 = 0;

    static Object o2 = 5;

    static int i = 1;

    Object m2(Object o1, Object o2, int i) {
        if (i == 4) {
            return o1;
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4168().m2(o1, o2, i));
    }
}
