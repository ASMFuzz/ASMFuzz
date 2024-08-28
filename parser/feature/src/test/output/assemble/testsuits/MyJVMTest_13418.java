public class MyJVMTest_13418 {

    static Float ibc = new Float(1.f);

    float remi_sumc() {
        Float j = ibc;
        for (int i = 0; i < 1000; i++) {
            j = j + ibc;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13418().remi_sumc());
    }
}
