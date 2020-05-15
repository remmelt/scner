var m = require("mithril")
var Scene = require("../models/Scene")
var Menu = {
    view: function() {
        return m("nav", [
            m(m.route.Link, {href: "/"}, "Scenes"),
            m(m.route.Link, {href: "/people"}, "People"),
        ])
    }
    }

module.exports = {
    oninit: Scene.loadList,
    view: function () {
        return [
                       m(Menu),
                       m(".user-list", Scene.list.map(function(scene) {
            return m(m.route.Link, {
                            class: "user-list-item",
                            href: "/scene/" + scene.id,
                        }, scene.name)
        }))
        ]
    }
}
