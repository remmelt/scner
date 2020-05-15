var Menu = {
    view: function() {
        return m("nav", [
            m(m.route.Link, {href: "/"}, "Scenes"),
            m(m.route.Link, {href: "/people"}, "People"),
        ])
    }
    }
