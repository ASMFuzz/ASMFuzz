public class MyJVMTest_6209 {

    static int i = 6;

    int tzint(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6209().tzint(i));
    }
}
