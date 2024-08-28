public class MyJVMTest_3945 {

    static int value = 7;

    int checkMethod(int value) {
        return Math.incrementExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3945().checkMethod(value));
    }
}
