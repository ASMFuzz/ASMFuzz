public class MyJVMTest_1825 {

    static Integer i = 0;

    Integer foo(Integer i) {
        synchronized (i) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1825().foo(i);
    }
}
