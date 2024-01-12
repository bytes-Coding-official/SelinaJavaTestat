package prog.vital;

public class Messgeraet {

    //Array
    //Aufbau: Datentyp[] name = new Datentyp[anzahl]; bekannteste alle stellen werden mit null gefüllt
    //Datentyp[] name = {1,2,3,4,5}; setzt automatisch die anzahl
    //Datentyp[] name = new Datentyp[]{1,2,3,4,5}; setzt automatisch die anzahl
    private final Herzfrequenz[] herzfrequenzen = new Herzfrequenz[9999];

    public void hinzufuegen(Herzfrequenz herzfrequenz) throws RuntimeException {
        for (int i = 0; i < herzfrequenzen.length; i++) {
            if (herzfrequenzen[i] == null) {
                herzfrequenzen[i] = herzfrequenz;
                return;
            }
        }
        throw new RuntimeException("Kein Platz mehr im Messgerät");
    }
    
    
/*    private int anzahl = 0;
    public void hinzufuegen2(Herzfrequenz herzfrequenz) throws RuntimeException{
        if (anzahl < 9999){
            herzfrequenzen[anzahl] = herzfrequenz;
            anzahl++;
        } else {
            throw new RuntimeException("Kein Platz mehr im Messgerät");
        }
    }*/


    public Herzfrequenz[] getHerzfrequenzen() {
        return this.herzfrequenzen;
    }


    //gibt die herzfrquenzdurschnitt der letzten 20 messungen für eine bestimmte person zurück
    public double durchschnittlicheHerzfrequenz(String name) throws IllegalArgumentException, NullPointerException {
        if (name == null)
            throw new NullPointerException("Name darf nicht null sein");
        if (name.length() < 3)
            throw new IllegalArgumentException("Name muss mindestens 3 Zeichen lang sein");

        int anzahl = 0;
        int summe = 0;
        for (int index = 9999; index > 0; index--) {
            if (herzfrequenzen[index] != null && herzfrequenzen[index].getName().equalsIgnoreCase(name)) {
                summe += herzfrequenzen[index].getRuhepuls();
                anzahl++;
            }

            if (anzahl == 20)
                break;
        }

        if (anzahl == 0)
            throw new IllegalArgumentException("Keine Messungen für " + name + " gefunden");

        return summe / (double) anzahl;
    }
}
