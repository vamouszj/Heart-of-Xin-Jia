$(document).ready(function(){
$(".btn").click(function(){
    $.ajax({
        type: "POST",
        url: "index.html",
        dataType: "json",
        async: true,
        beforeSend: function(){
            var arr = new Array('mp3', 'mp4');
            var $val = $('#oneMusic').val().toLowerCase();
            var flag = 0;
            var fileType = $val.substring($val.lastIndexOf('.')+1, $val.length);
            for(var index in arr){
                if(fileType == arr[index]){
                    flag = 1;
                    return true;
                }
            }
            $('#oneMusic').val("");
            $("#sendSuccess").hide();
            $("#sendWarning").show();
            return false;           
        },
        data: {
            file: $('#oneMusic').val()
        },
        success: function(){
            console.log("成功");
        },
        complete: function(){
            $('#oneMusic').val("");

        },
        error: function(){
            console.log("出错了");
        }
    });       
});      
});


$(document).ready(function(){
    $("#sendSuccess").hide();
    $("#sendWarning").hide();
});