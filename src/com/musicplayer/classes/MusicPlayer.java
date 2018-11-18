package com.musicplayer.classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//class containing the methods and instance variables
public class MusicPlayer {
	//contains a list of songs
	private List<String> songList;
	//songs map will keep a track of songs which are played
	private HashMap<String, Integer> songsPlayed = new HashMap<String,Integer>();
	//will store the index of song which is being played currently
	private Integer currentSong=0;
	
	//constructor
	public MusicPlayer(List<String> songList) {
		// TODO Auto-generated constructor stub
		this.songList = songList;
	}
	
	//this function is for Shuffling the songs, everytime this will give a unique list
	public void shuffleSongs(){
		//class for generating a random number
		Random rand = new Random();
		for(int i=0;i<this.songList.size();i++){
			int randomNumber= rand.nextInt(this.songList.size());
			
			//swapping the songs in the list generate a shuffled list
			String temp = this.songList.get(i);
			this.songList.set(i, this.songList.get(randomNumber));
			this.songList.set(randomNumber, temp);
			
		}
	}
	
	//this function will play the first song or play the current playing song
	public String playCurrentSong(){
		if(this.songsPlayed.get(this.songList.get(this.currentSong))==null){
			this.songsPlayed.put(this.songList.get(this.currentSong), 1);
		}
		return this.songList.get(this.currentSong);
	}
	
	//this function will play the next song
	public String playNextSong(){
		if(this.currentSong+1==this.songList.size()){
			this.currentSong=0;
		}
		else{
			this.currentSong+=1;
		}
		if(this.songsPlayed.get(this.songList.get(this.currentSong))==null){
			this.songsPlayed.put(this.songList.get(this.currentSong), 1);
		}
		return this.songList.get(this.currentSong);
	}
	
	//this function will play the previous song
	public String playPreviousSong(){
		if(this.currentSong==0){
			this.currentSong=this.songList.size()-1;
		}
		else{
			this.currentSong-=1;
		}
		if(this.songsPlayed.get(this.songList.get(this.currentSong))==null){
			this.songsPlayed.put(this.songList.get(this.currentSong), 1);
		}
		return this.songList.get(this.currentSong);
	}
	
	//getter method for songs list
	public List<String> getSongList() {
		return songList;
	}
	
	//getter method for songs map
	public Map<String, Integer> getSongsPlayed() {
		return songsPlayed;
	}
	
}
