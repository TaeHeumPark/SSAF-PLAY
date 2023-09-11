<template>
  <div class="video-main">
    <div class="video-item" v-if="`video.title.length > 0`">
      <iframe
        width="1280"
        height="720"
        :src="`https://www.youtube.com/embed/${video.id}`"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        allowfullscreen
      ></iframe>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState(["video"]),
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
body,

.video-item {
  width: 100%;
  height: 100%;
}

.video-main {
  width: 100%;
  height: 800px;
}
.video-item {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
