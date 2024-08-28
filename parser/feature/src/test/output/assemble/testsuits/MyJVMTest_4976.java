public class MyJVMTest_4976 {

    static Object o = -299886173;

    int constant() {
        return 65;
    }

    static int field = 5;

    int test(Object o) {
        do {
            if (field <= 0) {
                return -109;
            }
            do {
                field = 4;
            } while (constant() >= 0);
        } while (o == null);
        return -109;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4976().test(o));
    }
}
