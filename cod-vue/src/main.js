// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import 'babel-polyfill'
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'

const axios = require('axios');
axios.defaults.baseURL = 'http://localhost:8443/api'
axios.defaults.withCredentials = true

Vue.config.productionTip = false
Vue.prototype.$axios = axios
/* eslint-disable no-new */
Vue.use(ElementUI)



router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) {
      if (store.state.user.username!=='') {
        axios.get('/authentication').then(resp => {
          if (resp) next()
          else {
            next({
              path: 'login',
              query: {redirect: to.fullPath}

            })
          }
        })
      } else {

        next({
          path: 'login',
          query: {redirect: to.fullPath}

        })
      }
    } else {
      next()
    }
  }
)

new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
