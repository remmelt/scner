const m = require('mithril');
const Scene = require('../models/Scene');
const app = require( '../app.js' )

module.exports = {
  oninit: function(vnode) {
    Scene.load(vnode.attrs.id);
  },
  view: function() {
    scene = Scene.current

    return [
      m('div.scene', [
        m('span', scene.name),
        m('img', {src: scene.image == null ? app.placeholder : 'media/' + scene.image, width: '100px'}),
        m('img', {src: scene.thumbs == null ? app.placeholder : 'media/' + scene.thumbs, width: '100px'}),
        m('ul', scene.persons.map(function(person) {
            return m('.person', person.name)
        }))
      ]),
    ];
  },
};
