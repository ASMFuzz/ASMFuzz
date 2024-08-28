public class MyJVMTest_14514 {

    static int phase = 8;

    int phaseInc(int phase) {
        return (phase + 1) & Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14514().phaseInc(phase));
    }
}
