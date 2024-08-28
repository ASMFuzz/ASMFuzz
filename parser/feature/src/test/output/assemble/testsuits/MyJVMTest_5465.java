public class MyJVMTest_5465 {

    static int sec = 5;

    static String className = "K!MJYHt[<R";

    static String uniqClassName = ")y4\\6)~fE,";

    int waitAndGC(int sec) {
        int cnt = sec;
        System.out.print("Wait ");
        while (cnt-- > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (cnt % 3 == 2) {
                System.gc();
                System.out.print("+");
            } else {
                System.out.print(".");
            }
        }
        System.out.println("");
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5465().waitAndGC(sec);
    }
}
