/**
 * 로그인 및 장바구니 및 구매에 대한 모든 스크립트
 */
const KR = /[가-힣ㄱ-ㅎㅏ-ㅣ]/;

$(function() {
	console.log("hayeonPHY.js페이지 도착");
});


function loginAction() {
	let id = document.querySelector('#id').value;
	let pw = document.querySelector('#pw').value;
	console.log(id+' '+pw);
	if (id && pw) {
		if (!KR.test(id)) {
			//아작스 실행
			//loginconfig.do?id=test&pw=test
			$.ajax({
				url: 'loginconfig.do',
				data: { id: id, pw: pw },
				method: "POST",
				dataType: "json"	//서버에서 가져온 결과값 // 문자열을 자바스크립트의 객체로 자동으로 파싱해줌
			})
			.done(function(result) {
				if (result.retCode == 'buyer') {
					console.log('성공');
					window.location.href = '/NotCoupang/main.do';
				}else if (result.retCode == 'seller') {
					console.log('성공');
					window.location.href = '/NotCoupang/admin.do';
				} else if (result.retCode == 'FAIL') {
					console.log('실패');
					document.querySelector('#pwconfig').innerHTML = "ID와 PW 가 다릅니다 다시 시도해주세요!";
				}
			})
			.fail(function(err) {
				console.log(err);
			});
		}
	}
}//function loginAction()

function joinAction(division) {
	console.log(division);
	window.location.href = '/NotCoupang/join.do?division='+division;
}

//아이디 있는지 안내 뛰워주는거
function foucsOutId() {
	let id = document.querySelector('#id').value;
	if (!id) {
		document.querySelector('#idconfig').innerHTML = "ID를 입력 해주세요";
	} else {
		if (KR.test(id)) {
			document.querySelector('#idconfig').innerHTML = "ID는 영문과 숫자로 입력해주세요";
		} else {
			document.querySelector('#idconfig').innerHTML = "";
		}
	}
}
//비밀번호 있는지 안내 뛰워주는거
function foucsOutPw() {
	let pw = document.querySelector('#pw').value;
	if (!pw) {
		document.querySelector('#pwconfig').innerHTML = "PW를 입력 해주세요";
	} else {
		document.querySelector('#pwconfig').innerHTML = "";
	}
}

//회원가입페이지 아이디확인
function foucsOutjoinId(){
	let id = document.querySelector('#id').value;
	if (!id) {
		document.querySelector('#idconfig').innerHTML = "ID를 입력 해주세요";
		return;
	} else {
		if (KR.test(id)) {
			document.querySelector('#idconfig').innerHTML = "ID는 영문과 숫자로 입력해주세요";
			return;
		} else {
			$.ajax({
				url: 'joinconfig.do',
				data: { id: id },
				method: "POST",
				dataType: "json"	//서버에서 가져온 결과값 // 문자열을 자바스크립트의 객체로 자동으로 파싱해줌
			})
			.done(function(result) {
				if (result.retCode == 'OK') {
					console.log('성공');
					document.querySelector('#idconfig').innerHTML = "동일한 ID가 존재합니다";
					return;
				} else if (result.retCode == 'FAIL') {
					console.log('실패');
				}
			})
			.fail(function(err) {
				console.log(err);
			});
			document.querySelector('#idconfig').innerHTML = "";
		}
	}
}