public class MyJVMTest_14066 {

    static long freeSpace = 7717127892167517103L;

    static long KSIZE = 1024;

    static String name = "A)IZ=kt#k;";

    static long total = 0;

    static long free = 0;

    boolean woomFree(long freeSpace) {
        return ((freeSpace >= (free / 10)) && (freeSpace <= (free * 10)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14066().woomFree(freeSpace));
    }
}
