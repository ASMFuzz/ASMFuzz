public class MyJVMTest_7310 {

    static int[] ia = new int[] { -1 };

    int loadI(int[] ia) {
        return ia[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7310().loadI(ia));
    }
}
