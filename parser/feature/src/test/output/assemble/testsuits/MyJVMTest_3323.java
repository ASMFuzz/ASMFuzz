import java.io.*;

public class MyJVMTest_3323 {

    double nPower(int x, int pwr) {
        return Math.pow(x, pwr);
    }

    static int LEN = 5000;

    static int WIDTH = 20;

    static int ngrt10000 = 0;

    static int ngrt1000 = 0;

    static int ngrt100 = 0;

    static int nsmet100 = 0;

    static double[][] a = new double[LEN][WIDTH];

    void f() {
        for (int x = 0; x < LEN; x++) {
            for (int n = 0; n < WIDTH; n++) {
                if (nPower(x, n) > 10000) {
                    a[x][n] = nPower(x, n);
                    ngrt10000++;
                } else if (nPower(x, n) > 1000) {
                    a[x][n] = nPower(x, n);
                    ngrt1000++;
                } else if (nPower(x, n) > 100) {
                    a[x][n] = nPower(x, n);
                    ngrt100++;
                } else {
                    a[x][n] = nPower(x, n);
                    nsmet100++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3323().f();
    }
}
