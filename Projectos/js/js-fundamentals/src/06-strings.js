/**
 * Reduce duplicate characters to a desired minimum
 */
exports.reduceString = function (str, amount) {
    
    var arr = str.split('');
    for (var i = 0; i < arr.length - amount; i++) {
        if (arr[i] === arr[i + amount]){
            arr.splice(i + amount, 1)
            i--;
        }
    }
    return arr.join('');
};

/**
 * Wrap lines at a given number of columns without breaking words
 */
exports.wordWrap = function (str, cols) {

    var arr = str.split('');
    var count = 0;
    for (var i = 0; i < arr.length; i++) {
        count++;
        if (arr[i] === ' ' && count >= cols){
            arr[i] = '\n';
            count = 0;
        }
    }
    return arr.join('');
};

/**
 * Reverse a String
 */
exports.reverseString = function (str) {

    return str.split('').reverse().join('')
};

/**
 * Check if String is a palindrome
 */
exports.palindrome = function (str) {

    return str === str.split('').reverse().join('');
};
