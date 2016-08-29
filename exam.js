// exam.js
// JavaScript library for TWU exams
// <twu@seanho.com>

// Toggle whether text in <i> is shown or not

function toggleAnswers() {
  if (!document.getElementsByTagName) return;
  var itals = document.getElementsByTagName("I");
  if (!itals) return;
  for (var i=0; i<itals.length; i++) {
    if (itals[i].style.display == "inline") {
      itals[i].style.display = "none";
    } else {
      itals[i].style.display = "inline";
    }
  }
}

