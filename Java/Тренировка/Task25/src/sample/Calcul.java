package sample;
/**
 * <h1>Complex Numbers</h1>
 * The ComplexNumber program implements an application that
 * allows to calculate complex numbers
 **/

public class Calcul {

    /**
     * Represents the real part of a complex number
     */
    private double re;

    /**
     * Represents imaginary part of a complex number
     */
    private double im;

    public Calcul(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    /**
     * @return modulus (or absolute value) of the number
     */
    private double getModule() {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    /**
     * Allows to get the sum of two complex numbers given in the parameters.
     *
     * @return the new complex number
     */
    public static Calcul sum(Calcul cn1, Calcul cn2) {
        return new Calcul(cn1.getRe() + cn2.getRe(), cn1.getIm() + cn2.getIm());
    }

    /**
     * Allows to get the product of two complex numbers given in the parameters.
     *
     * @return the new complex number
     */
    public static Calcul multiply(Calcul cn1, Calcul cn2) {
        return new Calcul(cn1.getRe() * cn2.getRe() - cn1.getIm() * cn2.getIm(), cn1.getRe() * cn2.getIm() + cn1.getIm() * cn2.getRe());
    }

    /**
     * Allows to get the difference of two complex numbers given in the parameters.
     *
     * @return the new complex number
     */
    public static Calcul subtract(Calcul cn1, Calcul cn2) {
        return new Calcul(cn1.getRe() - cn2.getRe(), cn1.getIm() - cn2.getIm());
    }

    /**
     * Allows to get the product of two complex numbers given in the parameters.
     *
     * @return the new complex number
     */
    public static Calcul divide(Calcul cn1, Calcul cn2) {
        Calcul temp = new Calcul(cn2.getRe(), (-1) * cn2.getIm());
        temp = Calcul.multiply(cn1, temp);
        double denominator = cn2.getRe() * cn2.getRe() + cn2.getIm() * cn2.getIm();
        return new Calcul(temp.getRe() / denominator, temp.getIm() / denominator);
    }

    /**
     * This function allows to get the argument of complex number to represent it in trigonometric form
     *
     * @return argument of complex number
     */
    private double GetArg() {
        if (this.re > 0) {
            return Math.atan(im / re);
        } else {
            if (re < 0 && im > 0) {
                return Math.PI + Math.atan(im / re);
            } else {
                return -Math.PI + Math.atan(im / re);
            }
        }
    }

    /**
     * Allows to raise complex number to specified power with the help of de Moivre's formula.
     *
     * @param cn    needed complex number (the base)
     * @param power the exponent
     * @return the new complex number
     */
    public static Calcul pow(Calcul cn, int power) {
        double factor = Math.pow(cn.getModule(), power);
        return new Calcul(factor * Math.cos(power * cn.GetArg()), factor * Math.sin(power * cn.GetArg()));
    }

    /**
     * The function of getting square roots of complex number cn
     *
     * @return an array of pair of square roots
     */
    public static Calcul[] sqrt(Calcul cn) {
        double a = cn.getModule() / 2;
        Calcul pos = new Calcul(Math.sqrt(a + cn.getRe() / 2), Math.signum(cn.getIm()) * Math.sqrt(a - cn.getRe() / 2));
        Calcul neg = new Calcul((-1) * pos.getRe(), (-1) * pos.getIm());
        Calcul[] answer = {pos, neg};
        return answer;
    }

    /**
     * Defines and returns the sign required for correct record of a number
     *
     * @return string with appropriate sign
     */
    private String sign() {
        if (im > 0) return " + ";
        else return " - ";
    }

    @Override
    public String toString() {
        String string;
        if (im == 1 || im == -1) {
            if (re == 0) {
                string = sign() + "i";
            } else {
                string = Double.toString(re) + sign() + "i";
            }
        } else {
            string = Double.toString(re) + sign() + Double.toString(Math.abs(im)) + "i";
        }
        return string;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass() || obj == null)
            return false;
        return true;
    }

    /**
     * In this function main test on the correctness of this program are done.
     * All operations on complex numbers are shown.
     */
    public static void main(String[] args) {
        Calcul x = new Calcul(2, 3);
        Calcul y = new Calcul(-1, 2);
        System.out.println("z1 = " + x + ",     z2 = " + y);

        Calcul z;
        z = Calcul.sum(x, y);
        System.out.println("+ : " + z);

        z = Calcul.subtract(x, y);
        System.out.println("- : " + z);

        z = Calcul.divide(x, y);
        System.out.println("/ : " + z);

        z = Calcul.multiply(x, y);
        System.out.println(" * :" + z);

        z = Calcul.pow(y, 2);
        System.out.println("Pow 2 of z2 : " + z);

        Calcul b = new Calcul(3, 4);
        Calcul[] ans = Calcul.sqrt(b);
        System.out.println("Sqrt of " + b + " = " + ans[0] + ",  " + ans[1]);

    }
}