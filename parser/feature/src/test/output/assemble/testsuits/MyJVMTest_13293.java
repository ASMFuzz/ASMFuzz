public class MyJVMTest_13293 {

    static int value = 4;

    int checkMethod(int value) {
        return Math.incrementExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13293().checkMethod(value));
    }
}
