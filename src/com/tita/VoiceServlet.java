package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.MusicInfo;


public class VoiceServlet {
	private List<MusicInfo> list=null;
	private int Count;
	public VoiceServlet(String music_id){                //É¾³ý
		HibernectConnetc hbc=new HibernectConnetc();
		int music=Integer.parseInt(music_id);
		hbc.Find_condition_Music(music);
		list=hbc.getMusicList();
		MusicInfo MI=list.get(0);
		Mod_Music MM=new Mod_Music();
		MM.Del_Music(MI);
	}
	public VoiceServlet(){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Music();
		list=hbc.getMusicList();
	}
	public VoiceServlet(int pages){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.fenMusix(pages, 5);;
		
		hbc.Musicconut();
		Count=hbc.getCount();
		list=hbc.getMusicList();
	}
	public List<MusicInfo> getList(){
		if(list!=null)
			return list;
		else return null;
	}
	public int getConut(){
		if(Count%5==0){
			return Count/5;
		}else {
			return Count/5+1;
		}
	}
	
}
