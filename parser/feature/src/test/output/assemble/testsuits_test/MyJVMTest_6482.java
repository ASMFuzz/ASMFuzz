public class MyJVMTest_6482 {

    static int stageNum = 3;

    boolean isActionAllowed_8() {
        return (stageNum < 2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6482().isActionAllowed_8());
    }
}
