import java.awt.geom.AffineTransform;

public class MyJVMTest_2859 {

    AffineTransform makeRandomAT() {
        AffineTransform at = new AffineTransform();
        at.scale(Math.random() * -10.0, Math.random() * 100.0);
        at.rotate(Math.random() * Math.PI);
        at.shear(Math.random(), Math.random());
        at.translate(Math.random() * 300.0, Math.random() * -20.0);
        return at;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2859().makeRandomAT());
    }
}
