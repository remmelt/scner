const m = require('mithril');
const Scene = require('../models/Scene');

module.exports = {
  oninit: Scene.loadList,
  view: function() {
    return [
      m('.user-list', Scene.list.map(function(scene) {
        return m(m.route.Link, {
          class: 'user-list-item',
          href: '/scene/' + scene.id,
        }, scene.name);
      })),
    ];
  },
};
