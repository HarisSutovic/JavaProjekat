package UdgTest;


public class ZadatakZaBodove {

	public static void main(String[] args) {
	
class Vozilo {
	private String proizvodjac;
	private int godinaProizvodnje;
	private int kubikaza;
	private String boja;
	
	public Vozilo(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja) {
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.kubikaza = kubikaza;
		this.boja = boja;
		
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public int getKubikaza() {
		return kubikaza;
	}

	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}
	
	public double cijenaRegistracije() {
	    double cijena = 100;
	    if (godinaProizvodnje < 2010) {
	      cijena += 30;
	    }
	    if (kubikaza > 2000) {
	      cijena += 50;
	    }
	    return cijena;
  }
	public void prikaziInfo() {
        System.out.println("Proizvođač: " + proizvodjac);
        System.out.println("Godina proizvodnje: " + godinaProizvodnje);
        System.out.println("Kubikaža: " + kubikaza + " cc");
        System.out.println("Boja: " + boja);
    }
    }   
       

class Automobil extends Vozilo {
    private int brojVrata;
    private String tipMotora;

    public Automobil(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int brojVrata, String tipMotora) {
        super(proizvodjac, godinaProizvodnje, kubikaza, boja);
        this.brojVrata = brojVrata;
        this.tipMotora = tipMotora;
	}

	public int getBrojVrata() {
		return brojVrata;
	}

	public void setBrojVrata(int brojVrata) {
		this.brojVrata = brojVrata;
	}

	public String getTipMotora() {
		return tipMotora;
	}

	public void setTipMotora(String tipMotora) {
		this.tipMotora = tipMotora;
	}
    
      }
	    }
          }  


