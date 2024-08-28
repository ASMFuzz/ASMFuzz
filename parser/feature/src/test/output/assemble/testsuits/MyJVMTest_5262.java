public class MyJVMTest_5262 {

    static int[] src = { -1634882638, 0, -962258478, 196535545, 8, 0, -392363624, 8, 8, -712824000 };

    static boolean flag1 = false;

    static boolean flag2 = false;

    static int[] escaped = {543826757,710944053,-16486810,1715921747,6,1,6,0,0,0};

    int[] test(int[] src, boolean flag1, boolean flag2) {
        int[] array = new int[10];
        if (flag1) {
            System.arraycopy(src, 0, array, 0, src.length);
        } else {
        }
        if (flag2) {
            escaped = array;
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5262().test(src, flag1, flag2);
    }
}
