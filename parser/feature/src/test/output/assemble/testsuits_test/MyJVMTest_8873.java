public class MyJVMTest_8873 {

    String patchName() {
        return "patch2";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8873().patchName());
    }
}
