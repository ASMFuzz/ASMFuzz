public class MyJVMTest_633 {

    static boolean isUnix = false;

    static int stageNum = 5;

    boolean isActionAllowed_4() {
        return !((stageNum == 5 || stageNum == 6) && isUnix);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_633().isActionAllowed_4());
    }
}
