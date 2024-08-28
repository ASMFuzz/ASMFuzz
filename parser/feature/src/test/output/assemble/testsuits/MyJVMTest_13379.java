public class MyJVMTest_13379 {

    Local g() {
        return new Local();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13379().g());
    }
}
