public class MyJVMTest_4674 {

    static long freeSpace = 9223372036854775807L;

    static long KSIZE = 1024;

    static String name = "Evk5YfNw}\\";

    static long total = 9223372036854775807L;

    static long free = -9223372036854775808L;

    boolean woomFree(long freeSpace) {
        return ((freeSpace >= (free / 10)) && (freeSpace <= (free * 10)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4674().woomFree(freeSpace));
    }
}
