public class MyJVMTest_17066 {

    static int dummy = -134129186;

    int getX(int... dummy) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17066().getX(dummy));
    }
}
