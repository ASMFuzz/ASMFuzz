public class MyJVMTest_6815 {

    static int i = 0;

    int lzint(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6815().lzint(i));
    }
}
