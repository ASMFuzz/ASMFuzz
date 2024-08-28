public class MyJVMTest_12892 {

    static int i = 1800914930;

    static int[] array = new int[12];

    int index(int i) {
        if (i == 0)
            return 0;
        for (int n = 0; n < array.length; n++) if (i < array[n])
            return n;
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12892().index(i));
    }
}
