public class MyJVMTest_4227 {

    short remi_sumb() {
        Short j = Short.valueOf((short) 1);
        for (int i = 0; i < 1000; i++) {
            j = (short) (j + 1);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4227().remi_sumb());
    }
}
