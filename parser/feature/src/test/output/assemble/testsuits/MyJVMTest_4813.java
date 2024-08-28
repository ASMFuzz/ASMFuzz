public class MyJVMTest_4813 {

    static int i = 7;

    static int f = -621718873;

    static int[] a = {0,0,0,4,-322527806,1,0,3,0,1};

    static int sz = 1;

    int dummy(int i) {
        return i * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4813().dummy(i));
    }
}
