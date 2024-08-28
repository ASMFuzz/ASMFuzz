public class MyJVMTest_15786 {

    int sum() {
        int s = 0;
        for (int x = 1, y = 0; x != 0; x++, y--) {
            s ^= y;
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15786().sum());
    }
}
