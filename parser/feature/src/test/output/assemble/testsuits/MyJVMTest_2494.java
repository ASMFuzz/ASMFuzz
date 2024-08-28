public class MyJVMTest_2494 {

    static int k = 6;

    int howMany(int k) {
        switch(k) {
            case 1:
                System.out.print("one ");
            case 2:
                System.out.print("too ");
            case 3:
                System.out.println("many");
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2494().howMany(k);
    }
}
