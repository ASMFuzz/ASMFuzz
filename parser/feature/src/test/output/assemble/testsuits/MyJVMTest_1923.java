public class MyJVMTest_1923 {

    int lzcomp(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    static int VALUE = 1;

    int dolzcomp() {
        return lzcomp(VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1923().dolzcomp());
    }
}
