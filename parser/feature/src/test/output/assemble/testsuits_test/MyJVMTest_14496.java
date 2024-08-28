public class MyJVMTest_14496 {

    static boolean test = false;

    static int[] array1 = { 0, 1625659056, 0, 6, 7, 0, 8, 0, -939720029, 8 };

    static int[] array2 = { 1, 8, 0, 9, -1648945845, 8, 439119546, 9, 3, -1607566065 };

    static int[] array = {-1662826782,2,413944911,0,0,5,0,-1130949589,0,7};

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
        new MyJVMTest_14496().m(test, array1, array2);
    }
}
