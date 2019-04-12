/**
 * Return an array containing the function arguments
 */
exports.argsAsArray = function(...args) {
    return args;
};

/**
 * Return an array containing the function arguments,
 * but discarding the first two
 */
exports.lastArgs = function(a, b, ...args) {
    return args;
};

/**
 * Return a function which applies the provided transform function
 * on all arguments and returns an array with the results
 */
exports.transformArgs = function(transform) {
    
    return (...arg) => arg.map(function (value) {
        return transform(value)
    });
};

/**
 * Invoke the callback function passing each character
 * from the provided string as an argument
 */
exports.spreadChars = function(str, cb) {
    
};

/**
 * Concatenate the provided arrays using the spread operator
 */
exports.mergeArrays = function(arr1, arr2) {
};

/**
 * Return array of chars from the provided array of strings
 * using the spread operator
 */
exports.spreadArrayStrings = function(arr) {
};

/**
 * Flatten an array of arrays using the spread operator
 */
exports.flattenArray = function(arr) {
};

