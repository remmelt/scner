
var root = document.body
var count = 0

var increment = function() {
    m.request({
        method: "PUT",
        url: "https://rem-rest-api.herokuapp.com/api/tutorial/1",
        body: {count: count + 1},
        withCredentials: true,
    })
    .then(function(data) {
        count = parseInt(data.count)
    })
}
var User = {
    list: [],
    loadList: function() {
        return m.request({
            method: "GET",
            url: "https://rem-rest-api.herokuapp.com/api/users",
            withCredentials: true,
        })
        .then(function(result) {
            User.list = result.data
        })
    },
}
var Hello = {
    view: function() {
        return m("main", [
            m("h1", {
                class: "title"
            }, "My first app"),
            m("button", {
                onclick: increment
            }, count + " clicks"),
        ])
    }
}

m.mount(root, Hello)
