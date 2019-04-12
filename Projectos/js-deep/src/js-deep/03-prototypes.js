/**
 * Create a developer person object with a code method
 * that delegates to the provided person object
 */
exports.createDelegate = function (person) {

    var result = Object.create(person);
    result.code = function () { }
    return result;
};

/**
 * Borrow and invoke the person say method on top of the company object
 */
exports.borrowSayMethod = function (person, company) {

    return person.say.call(company);
};

/**
 * Iterate over all of the provided object own properties,
 * returning an array of key: value strings
 */
exports.iterate = function (obj) {

    return obj;
};

/**
 * Add a repeatify method to all JavaScript Strings
 * 'string'.repeatify(3) should equal 'stringstringstring'
 * NOTE: This exercise exists for a pedagogic purpose only,
 * do not think doing stuff like this is a good idea...
 *
 * String already contains a repeat method, let's NOT use that one.
 */
exports.extendString = function () {

    if (String.prototype.repeatify != null) {
        return;
    }
    String.prototype.repeatify = String.prototype.repeat
};
