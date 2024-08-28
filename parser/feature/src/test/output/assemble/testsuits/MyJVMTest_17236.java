public class MyJVMTest_17236 {

    static Object o1 = 2;

    static Object o2 = 8;

    int compare(Object o1, Object o2) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17236().compare(o1, o2));
    }
}
