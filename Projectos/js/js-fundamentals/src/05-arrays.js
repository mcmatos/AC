/**
 * Determine the location of an item in the array
 */
exports.indexOf = function (arr, item) {
    return arr.indexOf(item);
};

/**
 * Sum the items of an array
 */
exports.sum = function (arr) {

    return arr.reduce(function (accumulator, num){
        return accumulator + num;
    });

    /*
    var num = 0;
    for (var i = 0; i <  arr.length; i++) {
        num += arr[i];
    }
    return num;
    */
};

/**
 * Remove all instances of an item from an array
 */
exports.remove = function (arr, item) {

    return arr.filter(function (value){
        return value !== item;
    });
};

/**
 * Remove all instances of an item from an array by mutating original array
 */
exports.removeWithoutCopy = function (arr, item) {

    for (var i = 0; i < arr.length; i++) {
        if (arr[i] === item) {
            arr.splice(i, 1)
            i--;
        }
    }
    return arr;
};
/**
 * Add an item to the end of the array
 */
exports.append = function (arr, item) {
    arr.push(item);
    return arr;
};

/**
 * Remove the last item of an array
 */
exports.truncate = function (arr) {
    arr.pop();
    return arr;
};

/**
 * Add an item to the beginning of an array
 */
exports.prepend = function (arr, item) {
    arr.unshift(item);
    return arr;
};

/**
 * Remove the first item of an array
 */
exports.curtail = function (arr) {
    arr.shift();
    return arr;
};

/**
 * Join two arrays together
 */
exports.concat = function (arr1, arr2) {
    return arr1.concat(arr2);
};

/**
 * Add an item to an array in the specified position
 */
exports.insert = function (arr, item, index) {
    arr.splice(index, 0, item);
    return arr;
};

/**
 * Count the number of occurrences of an item in an array
 */
exports.count = function (arr, item) {

    return arr.filter(value => value === item).length;
};

/**
 * Find all items which container multiple occurrences in the array
 */
exports.duplicates = function (arr) {

    var set = new Set();
    arr = arr.sort();
    for (var i = 0; i < arr.length - 1; i++) {
        if (arr[i] === arr[i + 1]) {
            set.add(arr[i]);
        }
    }
    return Array.from(set);
};

/*
 * Square each number in the array
 */
exports.square = function (arr) {
    for (var i = 0; i < arr.length; i++) {
        arr[i] = arr[i] * arr[i];
    }
    return arr;

};

/**
 * Find all occurrenes of an item in an array
 */
exports.findAllOccurrences = function (arr, target) {

    var arr1 = [];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] === target){
            arr1.push(i)
        
        }
    }
    return arr1;
};
