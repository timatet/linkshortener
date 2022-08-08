import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ShortUrlView from '../views/ShortUrlView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: HomeView
  },
  {
    path: '/:shortUrl',
    component: ShortUrlView
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
