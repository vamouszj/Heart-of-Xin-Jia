
var req;
function btnOnclick(){
		var oBtn = document.getElementById("btn");
		var oIno = document.getElementById("mes");
		var oUl = document.getElementById("ulMesList");

		var oInoValue = oIno.value;
		if(!oInoValue){
			oIno.placeholder = "我们在这里听你说,不可为空哦";
			return;
		}
	
		oUl.innerHTML = oUl.innerHTML + '<li style="float:right"><img src="./images/user.jpg" style="float:right"><span style="float:right">' 
					+ oInoValue + '</span></li>';

	
		oIno.value="";
		
		var url = "http://localhost:8080/text馨/Pouer";
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
		    req.send("mess="+oInoValue);
			
		}
		
}

function PourAjax()
{
	var oIno = document.getElementById("mes");
	var url = "http://localhost:8080/Testeverone/Pouer";
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
	    req.send("mess",oIno);
		
	}
}
//回调函数
function complete() 
{
	if (req.readyState == 4 && req.status == 200)
	{
		//给返回的json串加上圆括号，转变成json对象
		
	}
}