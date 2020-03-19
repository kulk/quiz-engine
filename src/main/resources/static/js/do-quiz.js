$(document).ready(function () {
    getQuiz();
});

// Get's quiz via ajax call
function getQuiz() {
    var url = new URL(window.location.href);
    var quizId = url.searchParams.get("id");
    var data = "quizid=" + quizId;
    $.post('http://localhost:8080/getquiz', data, function (data, status) {
        parseResponse(data)
    })
}

function parseResponse(data){
    //var quiz = JSON.parse(data);
    console.log(data.name);
    console.log(data.questions);
}
