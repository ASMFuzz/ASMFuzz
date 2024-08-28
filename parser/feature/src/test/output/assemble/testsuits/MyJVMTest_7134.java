public class MyJVMTest_7134 {

    static int n = 4;

    static int current = 0;

    String times(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7134().times(n));
    }
}
