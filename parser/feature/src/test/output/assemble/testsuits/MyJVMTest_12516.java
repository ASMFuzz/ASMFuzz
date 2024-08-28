public class MyJVMTest_12516 {

    long NestedLoop() {
        final int n = 50;
        long startTime = System.currentTimeMillis();
        int x = 0;
        for (int a = 0; a < n; a++) for (int b = 0; b < n; b++) for (int c = 0; c < n; c++) for (int d = 0; d < n; d++) for (int e = 0; e < n; e++) for (int f = 0; f < n; f++) x++;
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12516().NestedLoop());
    }
}
