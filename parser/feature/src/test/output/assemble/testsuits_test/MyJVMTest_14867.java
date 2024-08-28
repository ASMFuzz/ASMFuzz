public class MyJVMTest_14867 {

    static Object o = 0;

    Integer m(Object o) {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14867().m(o));
    }
}
