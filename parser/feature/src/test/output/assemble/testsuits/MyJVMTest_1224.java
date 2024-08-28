public class MyJVMTest_1224 {

    static Object obj1 = 3;

    static Object obj2 = 9;

    int doNothingInJava2(Object obj1, Object obj2) {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1224().doNothingInJava2(obj1, obj2));
    }
}
