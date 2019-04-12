/**
 * Best Practices
 */

/**
 * Obtain user details
 */
exports.getUser = function() {
   
    var myObject = {
        name: 'Pedro',
        email: 'pedro.antoninho@academiadecodigo.org'
    };

    Object.defineProperty(myObject, 'name', {

        writable: false,
        enumerable: false,
        configurable: true
    });

    console.log(myObject);

    return myObject;
};

/**
 * Convert String to Numbe
 */
exports.parseNumber = function(num) {
    return parseInt(num, 10);
};

/**
 * Tests for equality 
 */
exports.isEqual = function(val1, val2) {
    return val1 === val2;
};
