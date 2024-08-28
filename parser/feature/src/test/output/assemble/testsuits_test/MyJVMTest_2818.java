public class MyJVMTest_2818 {

    static boolean isUnix = false;

    static int stageNum = -125794759;

    static int stagesCount = 7;

    boolean isActionAllowed_0() {
        return !((stageNum == 5 || stageNum == 6) && isUnix) && (stageNum < stagesCount);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2818().isActionAllowed_0());
    }
}
