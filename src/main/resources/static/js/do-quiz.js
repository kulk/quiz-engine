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

function displayData(data){
    document.getElementById("name").innerHTML = data.name;
    console.log(data);
    console.log("##########################");
    questionIterator(data, iterator);
}

function questionIterator(data, iterator){
    document.getElementById("question").innerHTML = data.questions[iterator].question;
    createAnswerList(data.questions[iterator].correctAnswer.answer, data.questions[iterator].incorrectAnswers);
}

function createAnswerList(correctAnswer, incorrectAnswers){
    // Create Array with correct answers

    // Shuffle correct answer array

    // Insert incorrectAnswer at random position

    // Create list with booleans


    console.log("Answers: " + correctAnswer, incorrectAnswers)

}

function displayAnswers(answerMap){
    // Create map of answers

}
