var m = require("mithril")
var Scene = require("../models/Scene")

module.exports = {
    oninit: function(vnode) {Scene.load(vnode.attrs.id)},
    view: function () {
        return [
        m(Menu),
        m("div.scene", [
            m("span", Scene.current.name),
            m("img", {src: "media/" + Scene.current.image, width: '100px'}),
            m("img", {src: "media/" + Scene.current.thumbs, width: '100px'}),
        ])
        ];
    }
}
