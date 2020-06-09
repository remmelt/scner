const m = require('mithril');

const Scene = {
  list: [],
  loadList: function() {
    return m.request({
      method: 'GET',
      url: 'http://localhost:7000/scene',
      withCredentials: true,
    })
        .then(function(result) {
          Scene.list = result;
        });
  },

  current: {},
  load: function(id) {
    return m.request({
      method: 'GET',
      url: 'http://localhost:7000/scene/' + id,
      withCredentials: true,
    })
        .then(function(result) {
          Scene.current = result;
        });
  },
};

module.exports = Scene;
