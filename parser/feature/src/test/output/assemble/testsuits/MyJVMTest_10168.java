public class MyJVMTest_10168 {

    static T t1 = null;

    static T t2 = null;

    static short s = 0;

    static Object o = 6;

    <T> T choose(T t1, T t2) {
        return t1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10168().choose(t1, t2));
    }
}
