public class MyJVMTest_5123 {

    static int i = 0;

    int fint(int i) {
        return Integer.bitCount(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5123().fint(i));
    }
}
