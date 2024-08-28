public class MyJVMTest_17473 {

    String next() {
        return "a";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17473().next());
    }
}
