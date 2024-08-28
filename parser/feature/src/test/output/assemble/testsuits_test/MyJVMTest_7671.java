import java.io.*;

public class MyJVMTest_7671 {

    double nPower(int x, int pwr) {
        return Math.pow(x, pwr);
    }

    static int LEN = 5000;

    static int WIDTH = 20;

    static int ngrtO10000 = 0;

    static int ngrtO1000 = 0;

    static int ngrtO100 = 0;

    static int nsmetO100 = 0;

    static double[][] a = new double[LEN][WIDTH];

    static double[][] aopt = new double[LEN][WIDTH];

    void fopt() {
        for (int x = 0; x < LEN; x++) {
            for (int n = 0; n < WIDTH; n++) {
                double tmp = nPower(x, n);
                aopt[x][n] = tmp;
                if (tmp > 10000)
                    ngrtO10000++;
                else if (tmp > 1000)
                    ngrtO1000++;
                else if (tmp > 100)
                    ngrtO100++;
                else
                    nsmetO100++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7671().fopt();
    }
}
