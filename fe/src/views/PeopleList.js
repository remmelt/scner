var m = require("mithril")
var Person = require("../models/Person")

module.exports = {
    oninit: Person.loadList,
    view: function () {
        return [
                       m(".user-list", Person.list.map(function(person) {
            return m(m.route.Link, {
                            class: "user-list-item",
                            href: "/person/" + person.id,
                        }, person.name)
        }))
        ]
    }
}
