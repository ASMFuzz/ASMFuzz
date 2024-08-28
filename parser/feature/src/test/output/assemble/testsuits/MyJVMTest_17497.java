public class MyJVMTest_17497 {

    static int[] src = { 0, 5, 3, 1799112961, 7, -2145945721, 0, 5, 5, -75937702 };

    static int[] ref = { 627205621, 1209758309, -178466829, 7, 3, 0, 8, 176267341, -1613639472, 960611210 };

    int[] verify(int[] src, int[] ref) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] != ref[i]) {
                System.out.println("Error: src and ref don't match at " + i);
                System.exit(97);
            }
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17497().verify(src, ref);
    }
}
