public class MyJVMTest_14367 {

    static int iFld = 20;

    static int iFld2 = 0;

    static int[] iArrFld = new int[50];

    void test4() {
        int unused = 500;
        boolean b = true;
        int i = 1;
        while (++i < 35) {
            iArrFld[i] = 6;
            switch(iFld2) {
                case 40:
                    if (b) {
                        continue;
                    }
                    b = false;
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14367().test4();
    }
}
