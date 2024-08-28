public class MyJVMTest_3670 {

    String getSomethingCached() {
        return "Something cached value";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3670().getSomethingCached());
    }
}
