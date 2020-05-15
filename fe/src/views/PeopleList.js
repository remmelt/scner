var m = require("mithril")
var Person = require("../models/Person")
var Menu = {
    view: function() {
        return m("nav", [
            m(m.route.Link, {href: "/"}, "Scenes"),
            m(m.route.Link, {href: "/person"}, "People"),
        ])
    }
    }

module.exports = {
    oninit: Person.loadList,
    view: function () {
        return [
                       m(Menu),
                       m(".user-list", Person.list.map(function(person) {
            return m(m.route.Link, {
                            class: "user-list-item",
                            href: "/person/" + person.id,
                        }, person.name)
        }))
        ]
    }
}
