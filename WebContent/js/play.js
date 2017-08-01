var player=document.getElementById('music');
var ped=document.getElementById('ped');
var ptn=document.getElementById('ptn');
var pro=document.getElementById('process');

/*模拟后台JSON数据*/

var dataInt={"data":[{"imageSrc":"images/baby.jpg","src":"music/周杰伦 - 稻香.mp3","title":"稻香","singer":"主唱：周杰伦","comment":"人生在世没什么大不了   很多人即时艰难困苦的活着  每一天还是充满欢乐   为自己而活着  而不是为活着而活着。"},
				{"imageSrc":"images/chang.jpg","src":"music/林俊杰 - 可惜没如果.mp3","title":"可惜没如果","singer":"主唱：林俊杰","comment":"喜欢一个人要勇敢的去追，该沉默时别沉默，该勇敢时别软弱，就算被拒绝了也不会留下遗憾。"},
				{"imageSrc":"images/dog.jpg","src":"music/林俊杰 - 杀手.mp3","title":"杀手","singer":"主唱：林俊杰","comment":"因为无法占有她的心而想着就算不能占有她的心也要占有她的人她永远是属于我的！因为很爱很爱她而想到用一种极端的方式来留住她，来爱她……"},
				{"imageSrc":"images/xiyang.jpg","src":"music/汪苏泷 - 某人.mp3","title":"某人","singer":"主唱：汪苏泷","comment":"男孩很喜欢那个女孩，可是后来女孩走了，这个男孩子的烦恼也只有他自己知道，当所有都觉的这个男孩越飞越高的时候也就是这个男孩子出名了，可是这个男孩还是很喜欢女孩，希望可以把她给找回来，挽留下来。"},
				{"imageSrc":"images/shu.jpg","src":"music/魏晨 - 千方百计.mp3","title":"千方百计","singer":"主唱：魏晨","comment":"一个身怀绝技的特工，为了去解救爱人，不惜身陷危险进入非法集团当中，一人抵挡万人进过激烈的打斗之后，终于获得胜利。"},
				{"imageSrc":"images/yun.jpg","src":"music/张韶涵 - 淋雨一直走.mp3","title":"淋雨一直走","singer":"主唱：张韶涵","comment":"我们都有梦，可有时候梦是虚幻的。对人生看淡一点，或许人生根本就只是一场游戏，那我们就不会痛，不会累，不会恨。"}]};


var songLength=dataInt.data.length;
var songIndex=0;

window.onload=function(){
	/*随机获取歌曲信息*/
//	var rad=Math.floor(Math.random()*songLength);
//	songIndex=rad;		/*将获取到的下标赋值给全局变量songIndex*/
//
//	/*初始化页面*/
	var bgImage=document.getElementById('bgImage');
//	var tit=document.getElementById('tit');
//	var singer=document.getElementById('singer');
//	var comment=document.getElementById('comment');
//	var down=document.getElementById('down');

	
	bgImage.style.backgroundImage='url('+dataInt.data[songIndex].imageSrc+')';
//	player.src='<%=request.getAttribute("src") %>';
//	tit.innerHTML=dataInt.data[songIndex].title;
//	singer.innerHTML=dataInt.data[songIndex].singer;
//	comment.innerHTML=dataInt.data[songIndex].comment;
//	down.href=dataInt.data[songIndex].src;
//	down.download=dataInt.data[songIndex].src;

	var p=document.getElementById('playbtn');
	var pre=document.getElementById('prebtn');
	var nex=document.getElementById('nextbtn');

	p.className="";
	p.className="play";
	player.play();
	TimePass();

	/*点击播放按钮切换状态*/
	p.onclick=function(){
		if(p.className=="pause"){
			if(ped.style.width=='100%' && ptn.style.left=='100%'){
				ped.style.width='0%';
	        	ptn.style.left='0%';
			}
			p.className="";
			p.className="play";
			player.play();
			TimePass();
		}else if(p.className=="play"){
			p.className="";
			p.className="pause";
			player.pause();
		}
	}

	
	/*上一首歌曲*/
	pre.onclick=function(){
		prev();
	}
	/*下一首歌曲*/
	nex.onclick=function(){
		next();
	}

	/*点击调节进度条*/
	/*pro.onclick=function(e){   		//onclicky由onmousedown和onmouseup组合实现，与下面的拖放事件冲突
		move(e);
	}*/

	/*拖拽移动进度条*/
	ptn.onmousedown=function(e){
		var x=(e || window.event).clientX;		//刚开始点击播放按钮时播放按钮距离左端的距离
		var l=this.offsetLeft;					//播放按钮距离进度条左边开始端的距离
		var maxLength=pro.offsetWidth-this.offsetWidth;		//播放按钮可移动的最大距离范围

		document.onmousemove=function(e){
			var Dx=(e || window.event).clientX;  //鼠标在整个窗口上距离窗口左端的距离
			var newPro=Math.min(maxLength,Math.max(0,l+(Dx-x)));
			var processLength=pro.offsetWidth;
			var currentScale=newPro/processLength;

			player.currentTime=currentScale*player.duration;	//重置当前时间

			var p=document.getElementById('playbtn');
			if(p.className=="pause"){						//修改样式
				p.className="";
				p.className="play";
			}

			player.play();
			TimePass();
		}
		
		document.onmouseup=function(){
			document.onmousemove=null;
			this.onmouseup=null;								
		}	
	}
}

/*上一首*/
function prev(){
	
		getpev();
		songIndex-=1;
		var bgImage=document.getElementById('bgImage');
//		var tit=document.getElementById('tit');
//		var singer=document.getElementById('singer');
//		var comment=document.getElementById('comment');
//		var down=document.getElementById('down');

		bgImage.style.backgroundImage='url('+dataInt.data[songIndex].imageSrc+')';
//		player.src=dataInt.data[songIndex].src;
//		tit.innerHTML=dataInt.data[songIndex].title;
//		singer.innerHTML=dataInt.data[songIndex].singer;
//		comment.innerHTML=dataInt.data[songIndex].comment;
//		down.href=dataInt.data[songIndex].src;
//		down.download=dataInt.data[songIndex].src;
//		player.src="music/林俊杰 - 杀手.mp3";
		player.play();
		TimePass();
	
}
/*下一首*/
function next(){

		getnext();
		
		songIndex+=1;
		var bgImage=document.getElementById('bgImage');
//		var tit=document.getElementById('tit');
//		var singer=document.getElementById('singer');
//		var comment=document.getElementById('comment');
//		var down=document.getElementById('down');

		bgImage.style.backgroundImage='url('+dataInt.data[songIndex].imageSrc+')';
//		player.src=dataInt.data[songIndex].src;
//		tit.innerHTML=dataInt.data[songIndex].title;
//		singer.innerHTML=dataInt.data[songIndex].singer;
//		comment.innerHTML=dataInt.data[songIndex].comment;
//		down.href=dataInt.data[songIndex].src;
//		down.download=dataInt.data[songIndex].src;

		player.play();
		TimePass();
	
}

/*点击移动进度条*/
/*function move(e){
	var processLength=pro.offsetWidth;
	var currentLength=(e || window.event).offsetX;
	var currentScale=currentLength/processLength;

	player.currentTime=currentScale*player.duration;	//重置当前时间

	var p=document.getElementById('playbtn');
	if(p.className=="pause"){						//修改样式
		p.className="";
		p.className="play";
	}

	player.play();
	TimePass();
}*/

/*处理时间数值*/
function timeDispose(number){
	if(isNaN(number)){
		return "00:00";
	}else{
		var minute=parseInt(number/60);
		var second=parseInt(number%60);

		minute=minute>=10?minute:"0"+minute;
		second=second>=10?second:"0"+second;

		return minute+":"+second;
	}
}
/*已经播放所花的时间*/
function TimePass()   
  
{    
  	var ProcessYet = 0;
  	var timer=null;
    var ProcessYet =parseInt((player.currentTime / player.duration)*100); 

   	ped.style.width=ProcessYet+'%';
   	ptn.style.left=ProcessYet+'%';
   	var currentTime = timeDispose(player.currentTime);  
   	var  timeAll = timeDispose(player.duration);  

   	document.getElementById("timeShow").innerHTML=currentTime+" | "+timeAll; //时间显示    
   	timer=setTimeout(TimePass,1000);    /*每隔一秒循环一次*/  

   	//一首歌完整播放完毕
	if(player.currentTime==player.duration){
    	var p=document.getElementById('playbtn');
    	p.className="";
		p.className="pause";
		clearTimeout(timer);
	}      
}
//调用ajax进行歌曲切换
var req;
function getpev(){
	var url = "ListenMusic";
	var music_id=document.getElementById('Music_id').value;
	//alert(music_id);
    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
	
	if (req) 
	{
		//采用POST方式，异步传输
		req.open("post", url, true);
		//POST方式，必须加入如下头信息设定
		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		req.onreadystatechange = complete;
		req.send("music_id="+music_id+"&option=pev");
	}
}

function getnext()
{
	var url = "ListenMusic";
	var music_id=document.getElementById('Music_id').value;
	//alert(music_id);
    if (window.XMLHttpRequest)
    {
        req = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        req = new ActiveXObject("Microsoft.XMLHTTP");
    }
	
	if (req) 
	{
		//采用POST方式，异步传输
		req.open("post", url, true);
		//POST方式，必须加入如下头信息设定
		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		req.onreadystatechange = complete;
		req.send("music_id="+music_id+"&option=next");
	}
}
//回调函数
function complete() 
{
	if (req.readyState == 4 && req.status == 200)
	{
		//给返回的json串加上圆括号，转变成json对象
	
		var json =  eval("(" + req.responseText + ")");
		if(json.Music_judge!=0){
			
	
		document.getElementById('tit').innerText=json.Music_name;
		document.getElementById('singer').innerText="主唱："+json.Music_song;
		document.getElementById('comment').innerText="音乐类型:" + json.Music_type;
		player.src=json.Music_route;
		document.getElementById('Music_id').innerText=json.Music_id;
		//alert(document.getElementById('Music_id').value);
		player.play();
		TimePass();
		//document.getElementById("emp_email").innerText="邮箱:" + json.emp_email;
		}
	}
}