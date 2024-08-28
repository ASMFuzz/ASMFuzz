public class MyJVMTest_9759 {

    static int i = 5;

    int negativeInt(int i) {
        return -i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9759().negativeInt(i));
    }
}
