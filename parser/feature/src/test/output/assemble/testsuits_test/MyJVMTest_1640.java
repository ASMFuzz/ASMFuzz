public class MyJVMTest_1640 {

    void not_inlined() throws Exception1 {
        count++;
        if ((count % 100) == 0) {
            throw new Exception1();
        }
    }

    static Object field1 = new Object();

    static Object field2 = new Object();

    static int barrier = 0;

    static int count = 0;

    void test() {
        Object o1 = null;
        Object o2 = field2;
        try {
            not_inlined();
            o1 = field1;
            if (o1 == o2) {
            }
        } catch (Exception1 ex1) {
            o1 = field1;
            if (o1 == o2) {
            }
        }
        barrier = 42;
        if (o1 == o2) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1640().test();
    }
}
