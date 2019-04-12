/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function (counter) {

    if (arguments.length === 0) {
        var counter = 0;
    }
    return {
        get: function () {
            return counter;
        },

        increment: function () {
            return counter++;
        },

        reset: function () {
            counter = 0;
        }
    }

};

/**
 * Creates a person module with name and age
 * An initial name value should be provided and
 * an exception thrown if not
 */
exports.createPerson = function (name) {

    if (!name || name.length === 0) {
        throw new Error
    }

    var age = 0;

    return {
        setAge: function (newAge) {
            age = newAge;
        },
        getAge: function () {
            return age;
        },
        getName: function () {
            return name;
        }
    }
};
