public class MyJVMTest_15054 {

    static int src1 = 683582892;

    int blsmskl(int src1) {
        return (src1 - 1) ^ src1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15054().blsmskl(src1));
    }
}
