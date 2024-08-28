public class MyJVMTest_982 {

    static T t1 = null;

    static T t2 = null;

    static short s = -32138;

    static Object o = 1892691024;

    <T> T choose(T t1, T t2) {
        return t1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_982().choose(t1, t2));
    }
}
