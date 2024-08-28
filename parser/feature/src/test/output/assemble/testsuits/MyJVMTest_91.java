public class MyJVMTest_91 {

    static String name = "\\<1IHB7'q6";

    static int[] data = { 2, 0, 0, -1644492240, 8, 0, 606376338, 0, 3, 3 };

    static int[] gold = { 1, 1, 3, 6, 5, 1, 1672774157, 0, 6, 8 };

    static int RANGE = 512;

    int[] verify(String name, int[] data, int[] gold) {
        for (int i = 0; i < RANGE; i++) {
            if (data[i] != gold[i]) {
                throw new RuntimeException(" Invalid " + name + " result: data[" + i + "]: " + data[i] + " != " + gold[i]);
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_91().verify(name, data, gold);
    }
}
