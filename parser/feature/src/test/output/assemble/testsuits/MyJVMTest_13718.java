public class MyJVMTest_13718 {

    static boolean isUnix = false;

    static int stageNum = 0;

    static int stagesCount = 7;

    boolean isActionAllowed_1() {
        return !((stageNum == 5 || stageNum == 6) && isUnix) && (stageNum < stagesCount);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13718().isActionAllowed_1());
    }
}
