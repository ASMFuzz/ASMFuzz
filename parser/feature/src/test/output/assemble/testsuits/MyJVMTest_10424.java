public class MyJVMTest_10424 {

    static Object obj1 = -450488594;

    static Object obj2 = 8;

    int doNothingInJava2(Object obj1, Object obj2) {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10424().doNothingInJava2(obj1, obj2));
    }
}
