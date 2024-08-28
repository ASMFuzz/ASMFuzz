public class MyJVMTest_5438 {

    static Object o = 4;

    Integer m(Object o) {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5438().m(o));
    }
}
