package com.musicplayer.helperservices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperServices {
	
	//helper service for reading the file
	public static List<String> FileRead(String filePath){
		List<String> songList = new ArrayList<String>();
		File file = new File(filePath); 

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st; 
			while ((st = br.readLine()) != null){
				st=st.trim();
				songList.add(st);
				//System.out.println(songList);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found:songsFile.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return songList;
	}
	
	//helper service for showing the menu to user
	static public void showMenu(){
		System.out.println("Select from below options:");
		System.out.println("1.Play Song");
		System.out.println("2.Play Previous Song");
		System.out.println("3.Play next Song");
		System.out.println("4.Exit");
		//System.out.println("Enter your choice:");
	}
}
