public class MyJVMTest_12377 {

    float remi_sumb() {
        Float j = Float.valueOf(1.f);
        for (int i = 0; i < 1000; i++) {
            j = j + 1.f;
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12377().remi_sumb());
    }
}
