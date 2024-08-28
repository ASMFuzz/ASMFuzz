public class MyJVMTest_9801 {

    static boolean isUnix = false;

    static int stageNum = -333326142;

    boolean isActionAllowed_4() {
        return !((stageNum == 5 || stageNum == 6) && isUnix);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9801().isActionAllowed_4());
    }
}
