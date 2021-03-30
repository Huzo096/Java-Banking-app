/*
        Cilj zadatka jest napraviti bankovnu aplikaciju s osnovnim funkcijama za prikaz
        stanja računa, mogućnošću pologa i podizanja novca, te s mogućnošću uvida u prošle
        transakcije.

        Najprije je potrebno kreirati posebnu klasu "BankovniRacun" sa svim pripadajućim metodama.
        Zatim se vraćamo u klasu Banka gdje u main stvaramo novi objekt.
 */
public class Banka {

    public static void main(String[] args) {
        //objekt BankovniRacun sa imenom franjinRacun
        //u zagradi su parametri koje unosim kroz konstruktor
        BankovniRacun franjinRacun = new BankovniRacun("Franjo","RB13");

        //stvaranje novog bankovnog računa s imenom aninRacun
        BankovniRacun aninRacun = new BankovniRacun("Ana", "SF2016");
        //poziv moetode za odabir opcija se otvara isti izbornik kao i za franjinRacun
        aninRacun.prikažiMogućnostiOdabiraOpcijeZaKorisnika();
        //pokrećem porgram
    }
}

