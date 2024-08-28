public class MyJVMTest_2531 {

    static int i = 5;

    int foo(int i) {
        return i;
    }

    void dummy() {
    }

    int simpleb_deop(int i) {
        Integer ib = Integer.valueOf(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2531().simpleb_deop(i));
    }
}
