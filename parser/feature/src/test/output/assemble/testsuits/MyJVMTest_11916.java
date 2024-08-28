public class MyJVMTest_11916 {

    static int stageNum = 4;

    boolean isActionAllowed_3() {
        return (stageNum < 5);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11916().isActionAllowed_3());
    }
}
