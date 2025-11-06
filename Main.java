package Zadaci111;

import java.util.ArrayList;
import java.util.Scanner;


    abstract class EProizvod {
    protected String opis;
    protected String sifra;
    protected double ulaznaCijena;

    public EProizvod(String opis, String sifra, double ulaznaCijena) {
        this.opis = opis;
        this.sifra = sifra;
        this.ulaznaCijena = ulaznaCijena;
    }


    public double obracunajMaloprodajnuCijenu() {
        return ulaznaCijena * 1.05;
    }

    public String getTip() {
        return sifra.substring(0, 2).toUpperCase();
    }

    @Override
    public String toString() {
        return String.format("%s - %s, ulazna cijena: %.2f KM", sifra, opis, ulaznaCijena);
    }
}


class Racunar extends EProizvod {
    private String procesor;
    private int memorija;

    public Racunar(String opis, String sifra, double ulaznaCijena, String procesor, int memorija) {
        super(opis, sifra, ulaznaCijena);
        this.procesor = procesor;
        this.memorija = memorija;
    }

    @Override
    public double obracunajMaloprodajnuCijenu() {
        double cijena = super.obracunajMaloprodajnuCijenu();
        return cijena * 1.05;
    }

    @Override
    public String toString() {
        return String.format("[RACUNAR] %s | CPU: %s | RAM: %dGB | MP cijena: %.2f KM",
                opis, procesor, memorija, obracunajMaloprodajnuCijenu());
    }
}


    class Telefon extends EProizvod {
    private String operativniSistem;
    private double velicinaEkrana;

    public Telefon(String opis, String sifra, double ulaznaCijena, String operativniSistem, double velicinaEkrana) {
        super(opis, sifra, ulaznaCijena);
        this.operativniSistem = operativniSistem;
        this.velicinaEkrana = velicinaEkrana;
    }

    @Override
    public double obracunajMaloprodajnuCijenu() {
        double cijena = super.obracunajMaloprodajnuCijenu();
        if (velicinaEkrana > 6) {
            cijena *= 1.03;
        }
        return cijena;
    }

    @Override
    public String toString() {
        return String.format("[TELEFON] %s | OS: %s | %.1f inča | MP cijena: %.2f KM",
                opis, operativniSistem, velicinaEkrana, obracunajMaloprodajnuCijenu());
    }
}


    class TVUredjaj extends EProizvod {
    private double velicinaEkrana;

    public TVUredjaj(String opis, String sifra, double ulaznaCijena, double velicinaEkrana) {
        super(opis, sifra, ulaznaCijena);
        this.velicinaEkrana = velicinaEkrana;
    }

    @Override
    public double obracunajMaloprodajnuCijenu() {
        double cijena = super.obracunajMaloprodajnuCijenu();
        if (velicinaEkrana > 65) {
            cijena *= 1.10;
        }
        return cijena;
    }

    @Override
    public String toString() {
        return String.format("[TV] %s | %.1f inča | MP cijena: %.2f KM",
                opis, velicinaEkrana, obracunajMaloprodajnuCijenu());
    }
}


    public class Main {
    private static ArrayList<EProizvod> proizvodi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int izbor;
        do {
            System.out.println("\n=== SISTEM ZA UPRAVLJANJE E-PROIZVODIMA ===");
            System.out.println("1. Unos novog uređaja");
            System.out.println("2. Pregled svih uređaja");
            System.out.println("3. Pregled uređaja određenog tipa");
            System.out.println("0. Izlaz");
            System.out.print("Odaberite opciju: ");
            izbor = Integer.parseInt(scanner.nextLine());

            switch (izbor) {
                case 1:
                    unosUredjaja();
                    break;
                case 2:
                    prikaziSveUredjaje();
                    break;
                case 3:
                    prikaziPoTipu();
                    break;
                case 0:
                    System.out.println("Izlazak iz programa...");
                    break;
                default:
                    System.out.println("Nepoznata opcija!");
            }
        } while (izbor != 0);
    }


    private static void unosUredjaja() {
        System.out.print("Unesite šifru uređaja (RA, TE, TV...): ");
        String sifra = scanner.nextLine().trim().toUpperCase();

        System.out.print("Unesite opis uređaja: ");
        String opis = scanner.nextLine();

        System.out.print("Unesite ulaznu cijenu: ");
        double cijena = Double.parseDouble(scanner.nextLine());

        if (sifra.startsWith("RA")) {
            System.out.print("Unesite procesor: ");
            String procesor = scanner.nextLine();
            System.out.print("Unesite količinu memorije (GB): ");
            int memorija = Integer.parseInt(scanner.nextLine());
            proizvodi.add(new Racunar(opis, sifra, cijena, procesor, memorija));

        } else if (sifra.startsWith("TE")) {
            System.out.print("Unesite operativni sistem: ");
            String os = scanner.nextLine();
            System.out.print("Unesite veličinu ekrana (inči): ");
            double velicina = Double.parseDouble(scanner.nextLine());
            proizvodi.add(new Telefon(opis, sifra, cijena, os, velicina));

        } else if (sifra.startsWith("TV")) {
            System.out.print("Unesite veličinu ekrana (inči): ");
            double velicina = Double.parseDouble(scanner.nextLine());
            proizvodi.add(new TVUredjaj(opis, sifra, cijena, velicina));

        } else {
            System.out.println("Nepoznat tip proizvoda! Šifra mora početi sa RA, TE ili TV.");
        }

        System.out.println("Uređaj uspješno dodat!");
    }


        private static void prikaziSveUredjaje() {
        if (proizvodi.isEmpty()) {
            System.out.println("Nema unesenih uređaja!");
            return;
        }

        System.out.println("\n=== SVI UREĐAJI ===");
        for (EProizvod p : proizvodi) {
            System.out.println(p);
        }
    }


        private static void prikaziPoTipu() {
        System.out.print("Unesite tip uređaja (RA / TE / TV): ");
        String tip = scanner.nextLine().trim().toUpperCase();

        boolean nadjen = false;
        System.out.println("\n=== UREĐAJI TIPA " + tip + " ===");
        for (EProizvod p : proizvodi) {
            if (p.getTip().equalsIgnoreCase(tip)) {
                System.out.println(p);
                nadjen = true;
            }
        }
        if (!nadjen) {
            System.out.println("Nema uređaja tog tipa.");
        }
    }
}
   