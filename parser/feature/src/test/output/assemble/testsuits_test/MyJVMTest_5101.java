public class MyJVMTest_5101 {

    static int phase = -209723235;

    int phaseInc(int phase) {
        return (phase + 1) & Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5101().phaseInc(phase));
    }
}
