public class MyJVMTest_15951 {

    static int[][] result = {{7,3,-2034324254,9,9,6,3,6,0,-859798238},{20191913,-1699702762,263801193,-123604625,779271195,0,0,8,6,0}};

    static int[][] source = {{4,-1290016648,0,2,2,4,5,0,0,8},{0,766140081,0,-199953342,4,8,0,-1255257690,1,6}};

    static int line0 = 0;

    static int bunch = -426584370;

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
        new MyJVMTest_15951().run();
    }
}
