public class MyJVMTest_16776 {

    static short[] sa = new short[] { -1 };

    int loadUSmask(short[] sa) {
        return sa[0] & 0xFFFE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16776().loadUSmask(sa));
    }
}
