public class MyJVMTest_768 {

    int add(int var1, int var2) {
        return var1 + var2;
    }

    int method1() {
        int var1 = 1;
        int var2 = 2;
        int var3 = add(var1, var2);
        return var3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_768().method1());
    }
}
