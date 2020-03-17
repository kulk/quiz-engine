window.onload = function() {
    setActiveMenu();
};

var urlArray = ["/", "/create-quiz", "/generate-quiz"]

function setActiveMenu(){
    urlArray.map(changeClassName);
}

function changeClassName(x){
    if(x === window.location.pathname){
        document.getElementById(x).className = "nav-item active";
    }
}


