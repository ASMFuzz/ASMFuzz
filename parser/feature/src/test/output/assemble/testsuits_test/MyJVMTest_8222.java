public class MyJVMTest_8222 {

    static boolean isUnix = false;

    static int stageNum = 483834147;

    static int stagesCount = 7;

    boolean isActionAllowed_2() {
        return !((stageNum == 5 || stageNum == 6) && isUnix) && (stageNum < stagesCount);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8222().isActionAllowed_2());
    }
}
