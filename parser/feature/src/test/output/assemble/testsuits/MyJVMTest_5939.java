public class MyJVMTest_5939 {

    static long startTime = 8268660204012222330L;

    static long endTime = 9223372036854775807L;

    long getTime() {
        return endTime - startTime;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5939().getTime());
    }
}
