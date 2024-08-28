public class MyJVMTest_17878 {

    static Object obj1 = -844871811;

    static Object obj2 = -1296403983;

    static Object obj3 = 455482169;

    static Object obj4 = 1001447862;

    static Object obj5 = 0;

    int doNothingInJava3(Object obj1, Object obj2, Object obj3, Object obj4, Object obj5) {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17878().doNothingInJava3(obj1, obj2, obj3, obj4, obj5));
    }
}
