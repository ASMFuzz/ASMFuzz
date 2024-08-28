public class MyJVMTest_17335 {

    static Byte j = 47;

    byte remi_sump(Byte j) {
        for (int i = 0; i < 1000; i++) {
            j = new Byte((byte) (j + 1));
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17335().remi_sump(j));
    }
}
