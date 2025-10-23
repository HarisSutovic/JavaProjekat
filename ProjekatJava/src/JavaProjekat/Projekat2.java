package JavaProjekat;
import java.util.Scanner;
import java.util.ArrayList;
public class Projekat2 {
		
	public static void main(String[] args) {

Scanner sc = new Scanner(System.in);
String line = sc.nextLine();
//Clanovi grupe: Haris Sutović 24/084, Dalil Hadžiahmetovic 24/043
//Opis funkcije koda: kod ne funkcionise ali vazno je pokusati ga napisati:)

class Player  {
	private String ime;
	private int x;
	private int y;
	private int width;
	private int height;
	private int health;
	
	
	
public Player(String ime, int x, int y, int width, int height, int health) {
	super();
	this.ime = ime;
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.health = health;
	}

public String toString() {
	return String.format("Player[Player1] @ (10,5) 32x32 HP=85");
}

public String getIme() {
	return ime;
}


public void setIme(String ime) {
	this.ime = ime;
}


public int getX() {
	return x;
}


public void setX(int x) {
	this.x = x;
}


public int getY() {
	return y;
}


public void setY(int y) {
	this.y = y;
}


public int getWidth() {
	return width;
}


public void setWidth(int width) {
	this.width = width;
}


public int getHeight() {
	return height;
}


public void setHeight(int height) {
	this.height = height;
}


public int getHealth() {
	return health;
}


public void setHealth(int health) {
	this.health = health;
	
	    }

}

class Enemy {
	private String type;
	private int x;
	private int y;
	private int width;
	private int height;
	private int demage;
	
	
public Enemy(String type, int x, int y, int width, int height, int demage) {
	super();
	this.type = type;
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.demage = demage;
	



	}
public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public int getX() {
	return x;
}


public void setX(int x) {
	this.x = x;
}


public int getY() {
	return y;
}


public void setY(int y) {
	this.y = y;
}


public int getWidth() {
	return width;
}


public void setWidth(int width) {
	this.width = width;
}


public int getHeight() {
	return height;
}


public void setHeight(int height) {
	this.height = height;
}


public int getDemage() {
	return demage;
}


public void setDemage(int demage) {
	this.demage = demage;
	
	sc.close();
}
    
}
	

		
	}

}
