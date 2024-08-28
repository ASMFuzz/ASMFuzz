public class MyJVMTest_11050 {

    static Integer i = 8;

    Integer foo(Integer i) {
        synchronized (i) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11050().foo(i);
    }
}
