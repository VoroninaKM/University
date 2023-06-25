package task.task22.spring.model;

public class Model {

    private int par1;
    private int par2;
    int[] array = new int[10];

    public int[] main(int par1, int par2)
    {
        final int min = par1; // Минимальное число для диапазона
        final int max = par2; // Максимальное число для диапазона
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd(min, max);
        }

        return array;
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public double average(){
        double aver;
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        aver = sum/array.length;
        return aver;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getPar1() {
        return par1;
    }

    public void setPar1(int par1) {
        this.par1 = par1;
    }

    public int getPar2() {
        return par2;
    }

    public void setPar2(int par2) {
        this.par2 = par2;
    }
}
