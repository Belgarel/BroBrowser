package com.mycompany.javabrowser;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Favorite {
	private String csvFile;
	private FileWriter writer;
	private Scanner scanner;
	
	public Favorite() {
		try {
			this.writer = new FileWriter("fav.csv");
			this.scanner = new Scanner(new File("fav.csv"));
		} catch (IOException e) {
			System.out.println("Error with fav file");
			e.printStackTrace();
		}
	}
	
	public void getEntireFavFile() {
		System.out.println(scanner);
	}
	
	public void addNewFav(String name, String url) {
		//TODO Store name + url in the CSV file
	}
	
	public void deleteFav(String name) {
		//TODO Delete fav
	}
	
	public ArrayList<String> getAllFavName() {
		return new ArrayList<String>();
	}
	
	public String getUrlFromName(String favName) {
		return null;
	}
}
