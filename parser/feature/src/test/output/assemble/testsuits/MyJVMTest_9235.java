public class MyJVMTest_9235 {

    static String name = "3\"v$wC}!L9";

    static int[] data = { 6, 0, 0, 1258137774, 4, 736468397, 0, 0, 7, 7 };

    static int[] gold = { 0, 9, 0, 0, 1402817577, 7, 8, 875717207, 1, 6 };

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
        new MyJVMTest_9235().verify(name, data, gold);
    }
}
