public class MyJVMTest_4373 {

    static Short ib = 0;

    void dummy() {
    }

    short simplep_deop(Short ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4373().simplep_deop(ib));
    }
}
