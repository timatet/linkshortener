<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <ShortUrlCreater></ShortUrlCreater>
  </div>
</template>

<script>
import ShortUrlCreater from './components/CreateShortUrl.vue'
export default {
  name: 'App',
  components: {
    ShortUrlCreater
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>