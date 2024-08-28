public class MyJVMTest_8302 {

    static Object obj1 = 5;

    static Object obj2 = 2;

    static Object obj3 = 0;

    static Object obj4 = 2;

    static Object obj5 = 6;

    int doNothingInJava3(Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8302().doNothingInJava3(obj1, obj2, obj3, obj4, obj5));
    }
}
