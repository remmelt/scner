const m = require('mithril');

const SceneList = require('./views/SceneList');
const SceneView = require('./views/Scene');
const PeopleList = require('./views/PeopleList');

m.route(document.body, '/', {
    '/': SceneList,
    '/scene/:id': SceneView,
    '/people': PeopleList
})
