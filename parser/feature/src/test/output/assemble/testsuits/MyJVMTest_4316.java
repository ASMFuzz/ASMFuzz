public class MyJVMTest_4316 {

    static T t1 = null;

    static T t2 = null;

    <T> T m1(T t1, T t2) {
        return t1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4316().m1(t1, t2));
    }
}
