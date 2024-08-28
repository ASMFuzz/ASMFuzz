public class MyJVMTest_5584 {

    static int[][] value = {{0,-1180327351,8,2,1187228460,0,5,0,-1857832812,0},{-1978509072,0,4,0,0,266535618,8,8,0,1184582435}};

    static int[][] result = {{2,0,1837473315,1,595950368,0,4,2056636672,-930626009,-1779975701},{254904074,6,2064577154,-892547276,0,484283232,4,814082187,1,140719723}};

    static int[][] source = {{0,0,705894683,2,315769772,0,9,1216905987,1,2},{1860710997,6,2038789604,6,9,5,1,-205771487,9,4}};

    static int line0 = 3;

    static int bunch = 0;

    void run() {
        int line1 = line0 + bunch;
        int size = result.length;
        for (int line = line0; line < line1; line++) for (int column = 0; column < size; column++) {
            int sum = 0;
            for (int i = 0; i < size; i++) sum += source[line][i] * source[i][column];
            result[line][column] = sum;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5584().run();
    }
}
