public class MyJVMTest_13852 {

    static int i = 3;

    String returnBuzz(int i) {
        return "buzz";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13852().returnBuzz(i));
    }
}
