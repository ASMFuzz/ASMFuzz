public class MyJVMTest_2343 {

    static int value = 868509960;

    int checkMethod(int value) {
        return Math.decrementExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2343().checkMethod(value));
    }
}
