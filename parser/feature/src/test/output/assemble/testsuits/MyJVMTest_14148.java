public class MyJVMTest_14148 {

    Object cl() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14148().cl());
    }
}
