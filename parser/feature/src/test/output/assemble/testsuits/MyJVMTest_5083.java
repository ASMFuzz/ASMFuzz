public class MyJVMTest_5083 {

    static boolean test = true;

    static int[] array1 = { 0, 0, 1606552558, 1, 1, 2, 8, 6, 9, 7 };

    static int[] array2 = { 9, -1024008234, 6, 0, -131951467, 567951361, 0, 4, 7, 0 };

    static int[] array = {0,0,-1218312325,6,-307787623,4,8,1,0,9};

    int[] m(boolean test, int[] array1, int[] array2) {
        int i = 0;
        if (test) {
            array = array1;
        } else {
            array = array2;
        }
        while (true) {
            int v = array[i];
            i++;
            if (i >= 10)
                return;
        }
        return array1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5083().m(test, array1, array2);
    }
}
