public class MyJVMTest_17544 {

    static int i = 5;

    static int sz = 9;

    static int[] a = {0,-1950126521,5,2028806580,-862904743,6,8,0,6,0};

    int put(int i) {
        a[i % sz] = i;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17544().put(i);
    }
}
