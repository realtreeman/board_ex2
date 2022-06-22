$(function(){
	let bnoValue = $('input[name="bno"]').val();
	let replyUL = $('.chat');
	
	function showList(page){
		replyService.getList({bno:bnoValue, page:page},function(list){
			let str = "";
			for(let r of list){				
				str += `
			        <li data-rno='${r.rno}'>
			            <div>
			                <div class='header'>
			                    <strong class='primary-font'>${r.replyer}</strong>
			                    <small class='pull-right text-muted'>${displayTime(r.regDate)}</small>
			                </div>
			                <p>${r.reply}</p>
			            </div>
			        </li>`
			}
			replyUL.html(str);
		});
	}
	showList(1);
	
	function displayTime(timeValue){
//		console.log("2022,06,22".split(","))
//		console.log(timeValue);
//		console.log(timeArr);
//		console.log(typeof(timeValue))
//		let test = "abcdefg";
		//[2022] 위치임
//		console.log(test.substr(1));
//		console.log(timeArr[0]);
//		console.log(timeArr[1]);
//		console.log(timeArr[2]);
		let timeArr = JSON.stringify(timeValue).substr(1).split(",");
		return `${timeArr[0]}년 ${timeArr[1]}월 ${timeArr[2]}일`;
	}
})