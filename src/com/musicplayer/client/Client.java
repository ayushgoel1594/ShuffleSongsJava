package com.musicplayer.client;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.musicplayer.classes.MusicPlayer;
import com.musicplayer.helperservices.HelperServices;

public class Client {
	public static void main(String[] args) {
		
		//this will store the songs list
		List<String> songList = new ArrayList<String>();
		//Message to be displayed when all songs completed
		String allSongsPlayedMsg = "All Songs in the list are already played";
		//flag will indicate whether all songs are played or not
		int allSongsPlayedFlag = 0;
		//using helper service to read the file, we will get a list of songs
		songList=HelperServices.FileRead("./src/songsFile.txt");

		//creating object of Music Player class
		MusicPlayer musicPlayer = new MusicPlayer(songList);

		//shuffling the songs
		musicPlayer.shuffleSongs();

		//this will print the shuffled list
		//System.out.println(musicPlayer.getSongList()); 

		//calling show menu from helper services
		HelperServices.showMenu();

		int choice=0;
		while(choice!=4){
			System.out.println("Enter your choice:");
			try{
				Scanner scanner = new Scanner(System.in);
				choice = scanner.nextInt();
			} catch(InputMismatchException e){
				System.out.println("Enter valid input!");
				choice=-1;
			}

			switch(choice){
			case 1:
				if(musicPlayer.getSongList().size()!=musicPlayer.getSongsPlayed().size()){
					System.out.println("Current Song is:"+ musicPlayer.playCurrentSong());
				}
				else{
					System.out.println(allSongsPlayedMsg);
					allSongsPlayedFlag = 1;
				}
				break;
			case 2:
				if(musicPlayer.getSongList().size()!=musicPlayer.getSongsPlayed().size()){
					System.out.println("Current Song is:"+ musicPlayer.playPreviousSong());
				}
				else{
					System.out.println(allSongsPlayedMsg);
					allSongsPlayedFlag = 1;
				}
				break;
			case 3:
				if(musicPlayer.getSongList().size()!=musicPlayer.getSongsPlayed().size()){
					System.out.println("Current Song is:"+ musicPlayer.playNextSong());
				}
				else{
					System.out.println(allSongsPlayedMsg);
					allSongsPlayedFlag = 1;
				}
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice");
			}

			//check whether all songs are played or not
			if(allSongsPlayedFlag==1){
				try{
					System.out.println("Press 1 to shuffle and play songs again..... Press any other key to exit");
					Scanner scanner = new Scanner(System.in);
					choice = scanner.nextInt();
				} catch(InputMismatchException e){
					System.out.println("Exiting!");
				}
				//the songs will be played again if the user presses 1
				if(choice==1){
					musicPlayer.shuffleSongs();
					musicPlayer.getSongsPlayed().clear();
					HelperServices.showMenu();
					allSongsPlayedFlag=0;
				}
				else{
					choice=4;
				}

			}
		}

	}
}

