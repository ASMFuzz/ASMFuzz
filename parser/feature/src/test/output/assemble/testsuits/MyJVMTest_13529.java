public class MyJVMTest_13529 {

    static Object o1 = 1;

    static Object o2 = 0;

    static int i = -1979118946;

    Object m2(Object o1, Object o2, int i) {
        if (i == 4) {
            return o1;
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13529().m2(o1, o2, i));
    }
}
