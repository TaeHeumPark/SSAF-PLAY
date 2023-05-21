<template>
  <div>
    <b-row class="bg-secondary nav-bar" :style="{ opacity: 0.5 }">
      <b-col class="justify-content-start">
        <router-link to="/" class="nav-item no-hover">SSAF-PLAY</router-link>
      </b-col>
      <b-col class="justify-content-center">
        <b-button v-b-toggle.sidebar-right>Toggle Sidebar</b-button>
      </b-col>
      <b-col class="justify-content-end">
        <b-button v-b-toggle.sidebar-right>Toggle Sidebar</b-button>
      </b-col>
    </b-row>

    <b-sidebar id="sidebar-right" title="Sidebar with backdrop" :backdrop-variant="variant" backdrop shadow right>
      <div class="px-3 py-2">ggg</div>
    </b-sidebar>
  </div>
</template>

<script>
export default {
  name: "HeaderNav",
};
</script>

<style>
.nav-bar {
  align-items: center;
}
.nav-item {
  text-decoration: none;
  color: white;
}
</style>
