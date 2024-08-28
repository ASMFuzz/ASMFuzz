public class MyJVMTest_16318 {

    static int i = 1897074329;

    int lzint(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16318().lzint(i));
    }
}
