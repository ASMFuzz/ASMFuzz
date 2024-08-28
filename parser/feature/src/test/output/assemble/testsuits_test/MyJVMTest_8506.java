import java.awt.geom.AffineTransform;
import java.util.Random;

public class MyJVMTest_8506 {

    static int numops = 0;

    static Random rand = new Random();

    AffineTransform makeRandomTransform(int numops) {
        AffineTransform at = new AffineTransform();
        while (--numops >= 0) {
            switch(rand.nextInt(4)) {
                case 0:
                    at.scale(rand.nextDouble() * 5 - 2.5, rand.nextDouble() * 5 - 2.5);
                    break;
                case 1:
                    at.shear(rand.nextDouble() * 5 - 2.5, rand.nextDouble() * 5 - 2.5);
                    break;
                case 2:
                    at.rotate(rand.nextDouble() * Math.PI * 2);
                    break;
                case 3:
                    at.translate(rand.nextDouble() * 50 - 25, rand.nextDouble() * 50 - 25);
                    break;
                default:
                    throw new InternalError("bad case!");
            }
        }
        return at;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8506().makeRandomTransform(numops));
    }
}
