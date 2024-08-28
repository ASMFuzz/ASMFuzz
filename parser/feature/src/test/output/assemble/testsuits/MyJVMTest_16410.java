public class MyJVMTest_16410 {

    static double z = 0;

    double hand_optimized() {
        int k;
        double x = 1;
        k = 10001;
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16410().hand_optimized());
    }
}
