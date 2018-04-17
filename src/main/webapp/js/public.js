
Date.prototype.format=function(format){//format="yyyy-MM-dd"
	
	//定义js对象 ,按年月日分别绑定到一个属性.属性为正则表达式的格式
	var o={
		"M+":this.getMonth()+1,	
		"d+":this.getDate(),
		"y+":this.getFullYear()
	};
	//循环属性时,"(M+)"表示匹配到的结果进行分组放入$1. $0="yyyy-MM-dd"
	for(var k in o){
		if(new RegExp("("+k+")").test(format))
			format=format.replace(RegExp.$1,o[k]);
	}
	
	return format;
}

function mover(object) {

	for ( var i = 1; i < 6; i++) {
		if (i == object) {
			$("#m_" + i).attr("class", "m_li_a");
			$("#s_" + i).attr("class", "s_li_a");

		} else {
			$("#m_" + i).attr("class", "m_li");
			$("#s_" + i).attr("class", "s_li");
		}
	}
}