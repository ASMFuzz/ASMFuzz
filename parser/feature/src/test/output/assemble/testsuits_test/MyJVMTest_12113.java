public class MyJVMTest_12113 {

    static boolean isUnix = false;

    static int stageNum = 1;

    static int stagesCount = 7;

    boolean isActionAllowed_0() {
        return !((stageNum == 5 || stageNum == 6) && isUnix) && (stageNum < stagesCount);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12113().isActionAllowed_0());
    }
}
