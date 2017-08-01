function initTableId(){
    var oTable = document.getElementsByTagName('table')[0];
    var aList = oTable.getElementsByClassName('deleteBtn');
    for(var i = 0; i < aList.length; i++){
      aList[i].setAttribute('id', (i+1));
    }  
}

function deleteOneRow(){
 var deleteBtns = document.getElementsByClassName('deleteBtn');

 for(var i = 0, len = deleteBtns.length; i < len; i++){
     deleteBtns[i].onclick = function(){
      var obj = deleteBtns[i];
      var oTable = document.getElementsByTagName('table')[0];

      oTable.deleteRow(this.getAttribute("id"));
      console.log(this.getAttribute("id"));
      var musicList = document.getElementsByTagName('tr');
      var aList = oTable.getElementsByClassName('deleteBtn');
      for(var i = 0; i < aList.length; i++){
        aList[i].setAttribute('id', (i+1));
        musicList[i+1].getElementsByTagName('td')[0].innerHTML = i+1;
      }
    } 
 }        
} 


