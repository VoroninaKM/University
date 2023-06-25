package sample;

public class Parallelepiped {
    private String a;
    private String b;
    private String c;

    public Parallelepiped(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double calculateVolume(){
        return Double.parseDouble(a) * Double.parseDouble(b) * Double.parseDouble(c);
    }
}
