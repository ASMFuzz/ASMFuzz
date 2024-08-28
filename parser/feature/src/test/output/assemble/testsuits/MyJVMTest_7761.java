public class MyJVMTest_7761 {

    static int x = 2;

    long foo2() {
        return x & 0xff000000;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7761().foo2());
    }
}
