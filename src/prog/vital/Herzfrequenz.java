package prog.vital;

public class Herzfrequenz {


    private final String name; //final = Konstante, kann nicht mehr geändert werden
    //wenn ich eine variable die final ist habe, muss ich sie im Konstruktor initialisieren 
    // oder direkt einen wert zugewiesen bekommen und es gibt keinen setter

    private byte ruhepuls;   //byte = 127, short= 32767, int= 2147483647, long= 9223372036854775807 
    //standard wäre int wenn mans nicht weiß


    public Herzfrequenz(String name) throws IllegalArgumentException {
        if (name.length() < 3)
            throw new IllegalArgumentException("Name muss mindestens 3 Zeichen lang sein");
        this.name = name;
    }


    public String gebeWert() {
        return name + ":" + ruhepuls;
    }


    public String getName() {
        return name;
    }

    public byte getRuhepuls() {
        return ruhepuls;
    }

    public void setRuhepuls(byte ruhepuls) {
        this.ruhepuls = ruhepuls;
    }
}
