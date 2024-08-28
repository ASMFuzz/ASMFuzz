public class MyJVMTest_2166 {

    static int i = 9;

    static String name = "D.Y2nv\\=S[";

    Object createValidValue(int i) {
        byte[] unused = new byte[17832];
        return Integer.toString(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2166().createValidValue(i));
    }
}
