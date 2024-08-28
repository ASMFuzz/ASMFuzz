public class MyJVMTest_11158 {

    int lzcomp(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    static int VALUE = 5;

    int dolzcomp() {
        return lzcomp(VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11158().dolzcomp());
    }
}
