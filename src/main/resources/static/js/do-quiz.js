var iterator = 0;
var chosenAnswers = new Map();

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

function questionIterator(data) {
    if(iterator < data.questions.length){
        document.getElementById("question-nr").innerHTML = ("Question " + (iterator + 1) + ":");
        document.getElementById("question").innerHTML = data.questions[iterator].question;
        displayAnswers(data.questions[iterator].incorrectAnswers, data);
    } else {
        submitAnswers(data);
    }
}

function displayAnswers(answerList, data) {
    for (let i = 0; i < answerList.length; i++) {
        var answer = document.createElement("p");
        answer.className = answerList[i].answerId;
        var node = document.createTextNode(answerList[i].answer);
        answer.appendChild(node);
        document.getElementById("answer").appendChild(answer);
        answer.addEventListener("click", function(){
            addClickEvent(data, answerList[i].answerId);
        });
    }
}

function addClickEvent(data, answerId) {
    console.log("questionId = " + data.questions[iterator].questionId, "answerId = " + answerId);
    chosenAnswers.set(data.questions[iterator].questionId, answerId)
    iterator++;
    document.getElementById("answer").innerHTML = "";
    questionIterator(data)
}

function submitAnswers(data){
    //Todo: Submit answers to the backend
    var answers = mapToJson(chosenAnswers);
    var localData = "chosenanswers=" + answers + "&quizid=" + data.quizId;
    $.post('http://localhost:8080/result', localData, function (localData, status) {
        console.log(status);
        if(status === "success"){
            
        }
    });
}

function showResult(){

}

function mapToJson(map) {
    return JSON.stringify([...map]);
}