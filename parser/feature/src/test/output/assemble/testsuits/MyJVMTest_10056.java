public class MyJVMTest_10056 {

    static int start = 7;

    static int end = 0;

    static int[] a = {7,0,6,0,-1545541602,0,9,0,0,0};

    int loop_forw(int start, int end) {
        int result = 0;
        int[] is = a;
        if (is == null)
            return 0;
        for (int index = start; index < end; index++) result += is[index];
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10056().loop_forw(start, end));
    }
}
