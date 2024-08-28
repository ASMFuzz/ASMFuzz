public class MyJVMTest_1673 {

    float remi_sum() {
        Float j = new Float(1.f);
        for (int i = 0; i < 1000; i++) {
            j = new Float(j + 1.f);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1673().remi_sum());
    }
}
