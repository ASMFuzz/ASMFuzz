public class MyJVMTest_6463 {

    static int[][] result = {{4,-1296350855,1867165360,-222036098,0,1,100640805,2,0,1149363431},{0,2,0,-1700934984,3,0,6,6,3,0}};

    static int[][] source = {{5,0,0,0,6,1,7,9,-1206616597,0},{6,7,2,1,1468514548,1910977965,0,4,6,0}};

    static int line0 = 0;

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
        new MyJVMTest_6463().run();
    }
}
