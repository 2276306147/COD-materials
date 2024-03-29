import Vue from 'vue'
import Router from 'vue-router'
import AppIndex from "../components/home/AppIndex"
import Login from '../components/Login'
import Home from '../components/Home'
import MaterialsIndex from "../components/materials/MaterialsIndex";
import Register from "../components/Register";
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'index',
      redirect: '/index',
      component: AppIndex,
      meta: {
        requireAuth: true
      }
    },

    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path:'/register',
      name:'Register',
      component: Register
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      // home页面并不需要被访问
      redirect: '/index',
      children: [
    {
      path: '/index',
      name: 'AppIndex',
      component: AppIndex,
      meta: {
        requireAuth: true
      }
    },
        {
          path: '/materials',
          name: 'Materials',
          component: MaterialsIndex,
          meta: {
            requireAuth: true
          }
        }
      ]
    }
  ]
})

