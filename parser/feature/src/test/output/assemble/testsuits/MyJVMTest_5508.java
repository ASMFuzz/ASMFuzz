public class MyJVMTest_5508 {

    static int SIZE = 30;

    int f() {
        int[] a = new int[SIZE];
        a[0] = 0;
        a[1] = a[0] + 1;
        a[2] = a[1] + 2;
        a[3] = a[2] + 3;
        a[4] = a[3] + 4;
        a[5] = a[4] + 5;
        a[6] = a[5] + 6;
        a[7] = a[6] + 7;
        a[8] = a[7] + 8;
        a[9] = a[8] + 9;
        a[10] = a[9] + 10;
        a[11] = a[10] + 11;
        a[12] = a[11] + 12;
        a[13] = a[12] + 13;
        a[14] = a[13] + 14;
        a[15] = a[14] + 15;
        a[16] = a[15] + 16;
        a[17] = a[16] + 17;
        a[18] = a[17] + 18;
        a[19] = a[18] + 19;
        a[20] = a[19] + 20;
        a[21] = a[20] + 21;
        a[22] = a[21] + 22;
        a[23] = a[22] + 23;
        a[24] = a[23] + 24;
        a[25] = a[24] + 25;
        a[26] = a[25] + 26;
        a[27] = a[26] + 27;
        a[28] = a[27] + 28;
        a[29] = a[28] + 29;
        return a[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5508().f());
    }
}
