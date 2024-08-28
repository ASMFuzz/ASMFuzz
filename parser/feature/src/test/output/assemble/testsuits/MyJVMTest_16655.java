public class MyJVMTest_16655 {

    static int n = 1;

    static int current = 748821170;

    String times(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16655().times(n));
    }
}
