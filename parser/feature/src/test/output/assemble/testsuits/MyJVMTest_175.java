public class MyJVMTest_175 {

    int method1() {
        int[] array = new int[10];
        try {
            int var1 = array[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            array[0] = 1;
        } finally {
            array[1] = 2;
        }
        return array[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_175().method1());
    }
}
