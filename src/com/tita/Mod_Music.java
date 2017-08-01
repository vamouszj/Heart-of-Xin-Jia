package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.MusicInfo;

public class Mod_Music {
	private List<MusicInfo> ML;
	private MusicInfo MI;
	public void Del_Music(MusicInfo MI){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.DelMusic(MI);
	}
	public void Add_Music(MusicInfo MI){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.AddMusic(MI);
	}
	public void Find_Condition_music(int music_id){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Find_condition_Music(music_id);
		ML=hbc.getMusicList();
		if(ML.size()==0){
			MI=null;
		}else{
			MI=ML.get(0);
		}
	}
	public MusicInfo getMI(){
		return MI;
	}
}
