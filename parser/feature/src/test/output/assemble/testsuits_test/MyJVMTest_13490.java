public class MyJVMTest_13490 {

    static int type = 0;

    static int JVMTI_TEST_ERR_TYPE_HARD = 2;

    boolean isHard() {
        return (type == JVMTI_TEST_ERR_TYPE_HARD);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13490().isHard());
    }
}
