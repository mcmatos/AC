/**
 * Invoke the callback and return the amount of time in milliseconds it took to execute
 */
exports.profileFunc = function (cb) {
    var start = Date.now()
    cb();
    return Date.now() - start;
};

/**
 * Invoke the async callback with the provided value after some delay
 */
exports.returnWithDelay = function (value, delay, cb) {

    setTimeout(function () {
        cb(null, value)
    }, delay)
};

/**
 * Invoke the async callback with an error after some delay
 */
exports.failWithDelay = function (delay, cb) {

    setTimeout(function () {
        try {
            cb()
        } catch (error) {
            return new Error
        }
    })
};

/**
 * Return a promise that resolves after the specified delay
 * or rejects if the delay is negative or non-existent
 */
exports.promiseBasedDelay = function (delay) {

    return new Promise(function (resolve, reject) {
        if (delay >= 0) {
            setTimeout(function () {
                resolve()
            }, delay)
            return;
        }
        reject()
    })
};

/**
 * Use fetch to grab the contents of both urls and return
 * a promise resolving to the payload concatenation
 */
exports.concatBodies = async function (url1, url2) {

    let response = await fetch(url1);
    let response2 = await fetch(url2);

    return response + response2
};
