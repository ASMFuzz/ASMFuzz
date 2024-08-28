public class MyJVMTest_876 {

    static int start = 0;

    static int end = 1;

    static int[] a = {1,0,0,2,5,-973374170,0,4,0,749544105};

    int loop_forw(int start, int end) {
        int result = 0;
        int[] is = a;
        if (is == null)
            return 0;
        for (int index = start; index < end; index++) result += is[index];
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_876().loop_forw(start, end));
    }
}
