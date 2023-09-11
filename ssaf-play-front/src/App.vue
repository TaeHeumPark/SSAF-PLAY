<template>
  <div id="app" v-cloak>
    <header-nav></header-nav>
    <router-view />
    <footer-nav></footer-nav>
  </div>
</template>

<script>
import HeaderNav from "./components/common/HeaderNav.vue";
import FooterNav from "./components/common/FooterNav.vue";
export default {
  name: "App",
  components: {
    HeaderNav,
    FooterNav,
  },
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
  width: 100%;
  height: 80%;
}
</style>
