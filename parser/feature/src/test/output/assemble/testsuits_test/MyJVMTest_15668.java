public class MyJVMTest_15668 {

    static Object src = -641527094;

    boolean crash(Object src) {
        String[] dst = new String[1];
        System.arraycopy(src, 0, dst, 0, 1);
        return dst[0] == null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15668().crash(src));
    }
}
