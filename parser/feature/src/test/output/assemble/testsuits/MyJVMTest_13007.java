public class MyJVMTest_13007 {

    String getSomethingCached() {
        return "Something cached value";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13007().getSomethingCached());
    }
}
