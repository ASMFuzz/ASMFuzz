public class MyJVMTest_6243 {

    static int additionalValue = 0;

    int methodA() {
        additionalValue = 1;
        int returnValue = 100 + additionalValue;
        return returnValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6243().methodA());
    }
}
