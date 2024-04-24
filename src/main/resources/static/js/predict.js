// AJAX 요청 보내는 함수
function sendAjaxRequest(side) {
    // AJAX 요청 설정
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'your-api-endpoint-url', true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    // 요청 바디 데이터 설정 (예시로 간단하게 설정)
    var data = { side: side };

    // 요청 보내기
    xhr.send(JSON.stringify(data));

    // 요청 완료 후 처리
    xhr.onload = function() {
        if (xhr.status == 200) {
            console.log('요청이 성공적으로 완료되었습니다.');
            // 성공적으로 요청을 처리한 후 추가적인 로직을 수행할 수 있습니다.
        } else {
            console.error('요청이 실패했습니다.');
            // 요청에 실패한 경우에 대한 처리를 수행할 수 있습니다.
        }
    };
}
