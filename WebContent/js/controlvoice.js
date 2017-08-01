var clickCount = new Array();
function audioPlay() {
	var oAudioList = document.getElementsByClassName("audioMusic");
	var oSpanList = document.getElementsByClassName("spanControlPlay");
	for (var j = 0; j < oSpanList.length; j++) {
		clickCount[j] = 0;
		oSpanList[j].index = j;
		oSpanList[j].onclick = function() {
			clickCount[this.index]++;
			
			if(clickCount[this.index] % 2 == 1){
				oAudioList[this.index].play();				
			}else{
				oAudioList[this.index].pause();				
			}
		}
	}
}

function setPageNumClass() {
	var musicId = document.getElementById("tdMusicId").innerHTML;
	var pageId = parseInt(musicId / 5);
	var pageSortArray = document.getElementById("ulPageSort")
			.getElementsByTagName("li");
	for (var i = 0, len = pageSortArray.length; i < len; i++) {
		pageSortArray[i].getElementsByTagName("a")[0].setAttribute("class",
				"bgColorNomorl");
		pageSortArray[pageId + 1].getElementsByTagName("a")[0].setAttribute(
				"class", "bgColorNormal");
	}
	pageSortArray[pageId + 1].getElementsByTagName("a")[0].setAttribute(
			"class", "bgColorActive");
	pageSortArray[pageId + 1].getElementsByTagName("a")[0].style.background = "#3cc";
}

function checkWhichActive() {
	var pageSortArray = document.getElementById("ulPageSort")
			.getElementsByTagName("li");
	for (var i = 0, len = pageSortArray.length; i < len; i++) {
		var oA = pageSortArray[i].getElementsByTagName("a")[0].className;
		if (oA == "bgColorActive" && i > 1) {
			var str = "http://localhost:8080/%E5%BF%83%E4%B9%8B%E9%A6%A8%E5%AE%B6/VoiceServlet?pagenum="
					+ (i - 1);
		}
	}

	alert(this.tagName);
}
