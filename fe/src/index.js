// src/index.js
var m = require("mithril")

var SceneList = require("./views/SceneList")
var SceneView = require("./views/Scene")
var SceneView = require("./views/PeopleList")

m.route(document.body, "/", {
    "/": SceneList,
    "/scene/:id": SceneView,
    "/people": PeopleList
})
