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

        int tageImMonat = getAnzahlTageInDiesemMonat(monat, istSchaltjahr(jahr));
        if (tageImMonat == -1 || tag < 1 || tag > tageImMonat) {
            // ungültiges Datum
            this.tag = 1;
            this.monat = 1;
        } else {
            this.tag = tag;
            this.monat = monat;
        }

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
        switch (monat) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        case 2:
            return schaltjahr ? 29 : 28;
        default:
            return -1;
        }

    }

    /**
     * prüft, ob jahr ein Schaltjahr ist
     * 
     * @param jahr das zu prüfende Jahr
     * @return true, wenn jahr ein Schaltjahr ist, false, wenn nicht
     */
    public static boolean istSchaltjahr(int jahr) {
        boolean teilbarDurch4 = isTeilbarDurch(jahr, 4);
        boolean teilbarDurch100 = isTeilbarDurch(jahr, 100);
        boolean teilbarDurch400 = isTeilbarDurch(jahr, 400);
        return (teilbarDurch4 && !teilbarDurch100) || teilbarDurch400;
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
