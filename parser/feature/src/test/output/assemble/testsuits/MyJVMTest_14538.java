public class MyJVMTest_14538 {

    static int i = 0;

    int fint(int i) {
        return Integer.bitCount(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14538().fint(i));
    }
}
