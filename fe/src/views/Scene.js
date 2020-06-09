const m = require('mithril');
const Scene = require('../models/Scene');
const app = require( '../app.js' )

module.exports = {
  oninit: function(vnode) {
    Scene.load(vnode.attrs.id);
  },

  view: function() {
    scene = Scene.current;

    return [
      m('div.scene', [
        m('.persons', Scene.current.name)
      ]),
    ];
  },
};
