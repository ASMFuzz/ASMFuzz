public class MyJVMTest_9543 {

    static int a = -1010493587;

    static int b = 4;

    int addPrivateInner(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9543().addPrivateInner(a, b));
    }
}
