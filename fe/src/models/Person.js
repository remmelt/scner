var m = require("mithril")

var Person = {
    list: [],
    loadList: function() {
        return m.request({
            method: "GET",
            url: "http://localhost:7000/person",
            withCredentials: true,
        })
        .then(function(result) {
            Person.list = result
        })
    },

    current: {},
    load: function(id) {
        return m.request({
            method: "GET",
            url: "http://localhost:7000/person/" + id,
            withCredentials: true,
        })
        .then(function(result) {
            Person.current = result
        })
    }
}

module.exports = Person
