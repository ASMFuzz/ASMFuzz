public class MyJVMTest_12155 {

    static int i = -1928337849;

    int dummy(int i) {
        return i * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12155().dummy(i));
    }
}
