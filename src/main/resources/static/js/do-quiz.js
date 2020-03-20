var iterator = 0;
$(document).ready(function () {
    getQuiz();
});

// Get's quiz via ajax call
function getQuiz() {
    var url = new URL(window.location.href);
    var quizId = url.searchParams.get("id");
    var data = "quizid=" + quizId;
    $.post('http://localhost:8080/getquiz', data, function (data, status) {
        displayData(data)
    })
}

function displayData(data) {
    document.getElementById("name").innerHTML = data.name;
    console.log(data);
    console.log("##########################");
    questionIterator(data, iterator);
}

function questionIterator(data, iterator) {
    document.getElementById("question").innerHTML = data.questions[iterator].question;
    displayAnswers(data.questions[iterator].incorrectAnswers);
}

function displayAnswers(answerList) {

    for (let i = 0; i < answerList.length ; i++) {
        var answer = document.createElement("p");
        var node = document.createTextNode(answerList[i].answer);
        answer.appendChild(node);
        document.getElementById("answer").appendChild(answer);
    }




}
