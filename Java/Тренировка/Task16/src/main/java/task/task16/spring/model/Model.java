package task.task16.spring.model;

public class Model {

    private double par1;
    private double par2;
    private double result;
    private String action;

    public void summation(){
        this.result = par1 + par2;
    }

    public void subtraction(){
        this.result = par1-par2;
    }

    public void division(){
        this.result = par1/par2;
    }

    public void multiplication(){
        this.result = par1 * par2;
    }

    public void exponentiation(){
        this.result = Math.pow(par1, par2);
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getPar1() { return par1; }

    public void setPar1(double par1) {
        this.par1 = par1;
    }

    public double getPar2() {
        return par2;
    }

    public void setPar2(double par2) {
        this.par2 = par2;
    }
}
