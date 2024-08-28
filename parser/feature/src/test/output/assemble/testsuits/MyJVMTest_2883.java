import javax.management.modelmbean.*;

public class MyJVMTest_2883 {

    static int newTally = 9;

    static int tally = 0;

    int setCount(int newTally) {
        tally = newTally;
        return tally;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2883().setCount(newTally));
    }
}
