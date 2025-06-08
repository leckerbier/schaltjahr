import java.util.Scanner;

/**
 * stellt ein Datum (europäisches Format) dar
 */
public class Datum {
    private int tag;
    private int monat;
    private int jahr;

    /**
     * erstellt ein Datum aus den eingegebenen Werten bzw. 1.1.jahr, wenn tag und
     * monat kein gültiges Datum formen
     * 
     * @param tag   Tag im Monat
     * @param monat Monat im Jahr
     * @param jahr  Jahreszahl
     */
    public Datum(int tag, int monat, int jahr) {
        this.jahr = jahr;
        this.tag = tag;
        this.monat = monat;

    }

    @Override
    public String toString() {
        return this.tag + "." + this.monat + "." + this.jahr;
    }

    /**
     * liefert die Anzahl der Tage in monat zurück
     * 
     * @param monat      der zu überprüfende Monat
     * @param schaltjahr Information, ob der Monat in einem Schaltjahr liegt oder
     *                   nicht
     * @return Anzahl der Tage in monat; -1, wenn der nicht existiert
     */
    public static int getAnzahlTageInDiesemMonat(int monat, boolean schaltjahr) {
        return -1;

    }

    /**
     * prüft, ob jahr ein Schaltjahr ist
     * 
     * @param jahr das zu prüfende Jahr
     * @return true, wenn jahr ein Schaltjahr ist, false, wenn nicht
     */
    public static boolean istSchaltjahr(int jahr) {
        return false;
    }

    /**
     * prüft, ob zahl durch teiler teilbar ist
     * 
     * @param zahl   zu prüfende Zahl
     * @param teiler möglicher Teiler
     * @return true, wenn zahl durch teiler teilbar ist
     */
    private static boolean isTeilbarDurch(int zahl, int teiler) {
        return teiler != 0 && zahl % teiler == 0;
    }

    /**
     * erstellt ein Datum aus drei Benutzereingaben und gibt es aus
     * 
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        int tag;
        int monat;
        int jahr;
        System.out.println("Bitte den Tag eingeben: ");
        tag = tastatur.nextInt();
        System.out.println("Bitte den Monat eingeben: ");
        monat = tastatur.nextInt();
        System.out.println("Bitte das Jahr eingeben: ");
        jahr = tastatur.nextInt();

        Datum neu;
        neu = new Datum(tag, monat, jahr);
        System.out.println(neu);
    }

}
