const input = document.getElementById("myInput");
const label = document.getElementById("charCount");
var maxLength = 50;

input.addEventListener("input", function() {
    var remaining = maxLength - input.value.length;
    label.textContent = remaining + " characters remaining";
});
