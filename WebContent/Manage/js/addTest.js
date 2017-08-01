$(document).ready(function(){
	var $fun = function(){
	alert(2143235);
	var $len = $('table tr').length;
	alert($len); 
	var $str = "<tr><td><input type='text'  class='question' name='question"+ ($len-1) + "'  placeholder='请填写题目'><br>"
					+"<input type='text'  class='answer' name='question" + ($len-1) + "1' placeholder='请填写A答案'>"
				+"<input type='text'  class='answer' name='question" + ($len-1) + "2' placeholder='请填写B答案'>"
				+"<input type='text'  class='answer' name='question" + ($len-1) + "3' placeholder='请填写C答案'>"
					+"<a class='addQuestion' href='#'> 添加题目</a></td></tr>";
	alert($str);
	$('table').append($str);
	$('.addQuestion').click($fun);
	};

	$('.addQuestion').click(function(){
		$fun();
	});	
});

