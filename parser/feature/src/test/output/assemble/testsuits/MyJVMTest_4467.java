public class MyJVMTest_4467 {

    static int i = 1;

    String returnBuzz(int i) {
        return "buzz";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4467().returnBuzz(i));
    }
}
