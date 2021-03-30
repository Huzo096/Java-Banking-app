


import java.text.DecimalFormat;
import java.util.Scanner;

//kreiram klasu BankovniRacun
public class BankovniRacun {

    //kreiram polja koja će račun sadržavati
    private String imeKorisnika;
    private String identifikacijskiBrojKorisnika;
    private double stanjeRacuna;
    private double prethodnaTransakcija;

    //kreiram konstruktor koji omogućuje unošenje podataka kada kreiram objekt "BankovniRacun" u drugoj klasi.
    //Početno stanje računa je uvijek 0.00
    public BankovniRacun(String imeKorisnika, String identifikacijskiBrojKorisnika){
        this.imeKorisnika = imeKorisnika;
        this.identifikacijskiBrojKorisnika = identifikacijskiBrojKorisnika;
        this.stanjeRacuna = 0.0;
    }

    /*
        metoda, odn. funkcionalnost za polaganje novca na bankovni račun, provjerava da li je suma novca veća
        od nule, ako je suma manja, tada se korisnika obavještava kako ništa ne može  položiti na račun
     */
    public void pologNovca(double sumaNovca){
        if(sumaNovca > 0){
            stanjeRacuna += sumaNovca;
            prethodnaTransakcija = sumaNovca;
        } else {
            System.out.println("Polog novca ne može biti negativan iznos!");
        }
    }
    /*
        metoda, odn. funkcionalnost za podizanje novca s bankovnog računa, provjerava da li je suma novca veća
        od stanja na računu, ako je , tada se korisnika obavještava o iznosu s kojim raspolaže na svom račnu.
     */
    public void podizanjeNovca(double sumaNovca){
        if(stanjeRacuna - sumaNovca > 0){
            stanjeRacuna -= sumaNovca;
            prethodnaTransakcija = -sumaNovca;
        } else {
            System.out.println("Iznos koji želite podići je veći od Vaših sredstava na računu.");
        }
    }
    /*
        metoda, odn. funkcionalnost koja prikazuje prethodne transakcije računa. Ako je transakcija veća od
        nule, znači da se radi o pologu novca te je dobivena povratna informacija o tome koliko je novca položeno
        na račun i koje je nakon toga stanje računa.
            Ako je transakcija manja od nule, znači da se radi o
        podizanju novca s računa te je dobivena povratna informacija o tome koliko je novca povućeno s računa
        i koje je nakon toga stanje računa. Korištena je metoda za apsolutnu vrijednost kako u ispisu ne bismo
        dobili broj s negativnim predznakom.
            Konačno ukoliko korisnik unese iznos od 0 novčanih jedinica, tada dobiva povratnu informaciju kako
        transakcija nije provedena.
            Decimal format uvijek zaokružuje brojeve na 2 decimale kako u ispisu ne bismo dobili broj sa većim
        brojem decimala.
     */
    public void prikaziPrethodnuTransakciju(){
        DecimalFormat f = new DecimalFormat("##.00");
        if(prethodnaTransakcija > 0){
            System.out.println("Na račun je položeno: " + prethodnaTransakcija + " HRK." +
                    " Na računu trenutno imate: "+ (f.format(this.stanjeRacuna)) + " HRK.");
        } else if(prethodnaTransakcija < 0){
            System.out.println("S računa je podignuto " + Math.abs(prethodnaTransakcija) + " HRK." +
                    " Na računu trenutno imate: "+ (f.format(this.stanjeRacuna)) + " HRK.");
        } else {
            System.out.println("Transakcija nije provedena.");
        }
    }

    /*
        metoda, odn. funkcionalnost za prikaz opcija koje se korisniku nude. Sustav poziva ime i ID korisnika
        koji ćemo u klasi Banka proslijediti novom objektu kroz konstruktor. Uz ime i ID se ispisuju poruke
        i mogući odabiri.
            do while - "do" dio traži unos opcije sve dok opcija nije jednaka broju 5 u "while" dijelu petlje.
        Program završava pritiskom na 5. Unešena opcija se pohranjuje u varijablu "int opcija", dok se unos
        očituje u pozivu scannera.
            unutar "do" dijela se pojavljuje switch koji svaku moguću opciju obrađuje kao zaseban slučaj. Svaki
        slučaj završava sa "break" kako odabrana opcija nebi za sobom aktivirala i opciju koja u nizu
        slučajeva slijedi nakon nje, odnosno do narednog breaka.
            ukoliko korisnik odabere neki broj koji nije obrađen switch slučajem, tada se ispisuje poruka
        defaultnog slučaja
     */
    public void prikažiMogućnostiOdabiraOpcijeZaKorisnika(){

        int opcija;
        Scanner scanner = new Scanner(System.in);

        System.out.println(imeKorisnika + ", dobrodošli!");
        System.out.println("Vaš identifikacijski broj jest " + identifikacijskiBrojKorisnika);
        System.out.println();
        System.out.println("Odaberite jednu od sljedećih opcija, ili za izlazak pritisnite: 5");
        System.out.println("Za polaganje novca na račun pritisnite: 1");
        System.out.println("Za podizanje novca s računa pritisnite: 2");
        System.out.println("Za pregled prošle transakcije pritisnite: 3");
        System.out.println("Za pregled stanja računa pritisnite: 4");

        do{
            System.out.println();
            System.out.println("Unesite opciju: ");
            opcija = Integer.valueOf(scanner.nextLine());
            DecimalFormat f = new DecimalFormat("##.00");

            switch (opcija){
                //prvi slučaj poziva funkciju za polaganje novca, pita korisnika koliku sumu želi položiti
                case 1:
                    System.out.println("Unesite sumu koju želite položiti na račun: ");
                    double sumaNovca = Double.valueOf(scanner.nextLine());
                    pologNovca(sumaNovca);
                    break;
                //drugi slučaj poziva funkciju za podizanje novca, pita korisnika koliku sumu želi podići
                //i ispisuje poruke iz metode za podizanje novca
                case 2:
                    System.out.println("Unesite sumu koju želite podići s računa: ");
                    double sumaNovca2 = Double.valueOf(scanner.nextLine());
                    podizanjeNovca(sumaNovca2);
                    break;
                //treći slučaj poziva funkciju za prikaz prethodne transakcije te ispisuje povezane poruke
                case 3:
                    prikaziPrethodnuTransakciju();
                    break;
                case 4:
                    System.out.println("Na računu trenutno imate: "+ (f.format(this.stanjeRacuna)) + " HRK.");
                    break;
                //peti slučaj prekida rad programa
                case 5:
                    break;
                default:
                    System.out.println("Unijeli ste nepostojeću opciju. Pokušajte ponovno!");
                    break;
            }


        } while( opcija != 5);

    }


}
