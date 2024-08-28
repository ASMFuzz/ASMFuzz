public class MyJVMTest_16936 {

    static int var1 = 1563756559;

    static int var2 = 0;

    int add(int var1, int var2) {
        return var1 + var2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16936().add(var1, var2));
    }
}
