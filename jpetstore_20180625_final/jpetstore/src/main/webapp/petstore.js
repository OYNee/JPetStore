function optionVisable() {
	if(document.getElementById("opt_list").style.display!='none')
		document.getElementById("opt_list").style.display='none';
	else
		document.getElementById("opt_list").style.display='block';
}
function useMileage(cMileage, price) {
	m = document.getElementById("uMileage").value;
	price -= m;
	cMileage -= m;
	if(cMileage<0) {
		alert('사용할 마일리지가 보유 마일리지를 초과했습니다.');
		return;
	}
	else if(price < 0) {
		alert('결재할 금액보다 많이 사용할 수 없습니다!');
		return;
	}
	else if(m<0) {
		alert('적절한 값이 아닙니다.');
		return;
	}
	
	document.getElementById("finalSubTotal").innerHTML = 'Final Sub Total:' + price;

}

//function tabFunc(i) {
////	for(idx=1; idx<4; i++) {
////		document.getElementById(idx).className='';
////		document.getElementById("tab"+idx).style.display='none';
////	}
////	document.getElementById(i).className='active';
////	document.getElementById("tab"+i).style.display='block';
//	
//	if(i==1){
//		document.getElementById("tab1").style.display='block';
//		document.getElementById("tabn1").style.display='block';
//		document.getElementById("tab2").style.display='none';
//		document.getElementById("tabn2").style.display='none';
//		document.getElementById("tab3").style.display='none';
//		document.getElementById("tabn3").style.display='none';
//	}
//	if(i==2) {
//		document.getElementById("tab1").style.display='none';
//		document.getElementById("tabn1").style.display='none';
//		document.getElementById("tab2").style.display='block';
//		document.getElementById("tabn2").style.display='block';
//		document.getElementById("tab3").style.display='none';
//		document.getElementById("tabn3").style.display='none';
//	}
//	if(i==3) {
//		document.getElementById("tab1").style.display='none';
//		document.getElementById("tabn1").style.display='none';
//		document.getElementById("tabn2").style.display='none';
//		document.getElementById("tab2").style.display='none';
//		document.getElementById("tab3").style.display='block';
//		document.getElementById("tabn3").style.display='block';
//	}
//	
//	
//	return false;
//}

function viewContent(id) {
	var s = document.getElementById(id).style.display;
	if(s=='none')
		document.getElementById(id).style.display='block';
	else
		document.getElementById(id).style.display='none';
}

function allChk(obj){
	var chkObj = document.getElementsByName("rowCheck");
	var rowCnt = chkObj.length - 1;
	var check = obj.checked;
	if (check) {﻿
		for (var i=0; i<=rowCnt; i++){
			if(chkObj[i].type == "checkbox")
			chkObj[i].checked = true; 
		}
	} else {
		for (var i=0; i<=rowCnt; i++) {
			if(chkObj[i].type == "checkbox"){
				chkObj[i].checked = false; 
			}
		}
	}
} 

﻿ ﻿ 

function fn_userDel(){
	var userid = "";
	var memberChk = document.getElementsByName("rowCheck");
	var chked = false;
	var indexid = false;
	for(i=0; i < memberChk.length; i++){
		if(memberChk[i].checked){
			if(indexid){
	  			userid = userid + '-';
			}
			userid = userid + memberChk[i].value;
			indexid = true;
		}
	}
	if(!indexid){
		alert("삭제할 사용자를 체크해 주세요");
		return false;
	}

	var agree=confirm("삭제 하시겠습니까?");
	 if (agree){
		document.getElementById("checkList").value = userid;
	 	return true;
	 }
	 else {
		 return false;
	 }
}

function fn_adApproval(){
	var adid = "";
	var adChk = document.getElementsByName("rowCheck");
	var chked = false;
	var indexid = false;
	for(i=0; i < adChk.length; i++){
		if(adChk[i].checked){
			if(indexid){
	  			adid = adid + '-';
			}
			adid = adid + adChk[i].value;
			indexid = true;
		}
	}
	if(!indexid){
		alert("승인할 광고를 체크해 주세요");
		return false;
	}

	var agree=confirm("승인 하시겠습니까?");
	 if (agree){
		document.getElementById("approvalList").value = adid;
	 	return true;
	 }
	 else {
		 return false;
	 }
}

function fn_adReject(){
	var adid = "";
	var adChk = document.getElementsByName("rowCheck");
	var chked = false;
	var indexid = false;
	for(i=0; i < adChk.length; i++){
		if(adChk[i].checked){
			if(indexid){
	  			adid = adid + '-';
			}
			adid = adid + adChk[i].value;
			indexid = true;
		}
	}
	if(!indexid){
		alert("거부할 광고를 체크해 주세요");
		return false;
	}

	var agree=confirm("거부 하시겠습니까?");
	 if (agree){
		document.getElementById("rejectList").value = adid;
	 	return true;
	 }
	 else {
		 return false;
	 }
}
