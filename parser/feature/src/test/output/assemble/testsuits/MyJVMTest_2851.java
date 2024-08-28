public class MyJVMTest_2851 {

    static int i = 9;

    int index(int i) {
        if (i == 0)
            return 0;
        for (int n = 0; n < array.length; n++) if (i < array[n])
            return n;
        return -1;
    }

    static int[] array = new int[12];

    int test(int i) {
        int result = 0;
        i = index(i);
        if (i >= 0)
            if (array[i] != 0)
                result++;
        if (i != -1)
            array[i]++;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2851().test(i));
    }
}
