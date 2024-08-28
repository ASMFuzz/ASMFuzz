public class MyJVMTest_15020 {

    static int[][] value = {{1,111124664,8,664084417,-1156282393,0,0,1737512548,3,5},{1909275798,0,0,7,0,0,8,842894315,1931571956,1}};

    static int[][] result = {{0,4,-1567909864,9,7,2,3,7,3,1918091073},{0,9,7,7,0,-73180417,2,7,1154724035,-1635570779}};

    static int[][] source = {{7,-497145672,0,-1962184566,5,0,-1530418421,0,0,8},{2,5,5,0,2,0,8,9,7,-1184607986}};

    static int line0 = 1;

    static int bunch = 1267340842;

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
        new MyJVMTest_15020().run();
    }
}
