function isPalindrome(str) {
    let left = 0;
    let right = str.length - 1;

    while (left < right) {
        if (str[left] !== str[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
s="madam";
if(isPalindrome(s)){
console.log(s+" is Palindrome");
}
else{
    console.log(s+" is Not Palindrome");
}
