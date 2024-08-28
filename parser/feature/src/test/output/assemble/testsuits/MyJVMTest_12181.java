import javax.management.modelmbean.*;

public class MyJVMTest_12181 {

    static int newTally = -1821823943;

    static int tally = 0;

    int setCount(int newTally) {
        tally = newTally;
        return tally;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12181().setCount(newTally));
    }
}
