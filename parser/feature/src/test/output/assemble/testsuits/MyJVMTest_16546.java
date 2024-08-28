public class MyJVMTest_16546 {

    static int i = 0;

    int simple(int i) {
        Integer ib = new Integer(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16546().simple(i));
    }
}
