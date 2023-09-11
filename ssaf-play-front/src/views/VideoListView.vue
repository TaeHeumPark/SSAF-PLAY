<template>
  <div class="video-list-main">
    <div class="video-grid">
      <div @click="goVideoDetail(video)" class="video" v-for="(video, idx) in videos" :key="idx">
        <div class="video-container">
          <img :src="`https://img.youtube.com/vi/${video.id}/0.jpg`" />
          <div class="video-info">
            {{ video.title }}
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  created() {
    this.$store.dispatch("getVideosBySport", sessionStorage.getItem("sport"));
  },
  computed: {
    ...mapState(["videos"]),
  },
  methods: {
    goVideoDetail(video) {
      this.$store.dispatch("getVideoDetail", video);
      this.$router.push(`/videolist/id=${video.video_no}`);
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

html,
body {
  width: 100%;
  height: 100%;
}

img {
  width: 250px;
  height: 200px;
  border-radius: 20px 10px;
}

a {
  text-decoration: none;
  color: black;
}

.video-list-main {
  padding: 30px 50px;
  padding-top: 80px;
}

.video-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  padding: 10px;
}

.video {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 320px;
  height: 300px;
  margin: 10px;
  padding: 10px;
  border: 1px solid black;
  border-radius: 50px;
}

.video-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.video-info {
  display: flex;
  flex-direction: row;
  width: 220px;
  margin-top: 10px;
  text-align: center;
}
</style>
