public class MyJVMTest_7684 {

    static Object o1 = 2;

    static Object o2 = 3;

    int compare(Object o1, Object o2) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7684().compare(o1, o2));
    }
}
