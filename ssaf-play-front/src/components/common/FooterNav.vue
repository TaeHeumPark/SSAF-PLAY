<template>
  <div class="d-flex flex-column align-items-center footer-nav">
    <div
      class="d-flex align-items-center justify-content-between my-3 footer-button"
    >
      <a href="#">SSAF-PLAY 소개</a> |
      <router-link to="/notice">공지사항</router-link> |
      <router-link to="/terms">이용약관</router-link> |
      <router-link to="/persnalinfo">개인정보처리방침</router-link>
    </div>
    <hr class="driver" />
    <div
      class="d-flex flex-column align-items-center justify-content-between my-3"
    >
      <div class="footer-bar-logo mt-5 mb-4">ѕѕaғ play</div>
      <div>© SSAF PLAY. All Rights Reserved</div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0%;
  padding: 0;
}

a {
  text-decoration: none;
  color: rgb(199, 199, 199);
}

a:hover {
  color: aliceblue;
}

.driver {
  width: 100%;
}

hr {
  background: rgb(199, 199, 199);
  height: 1px;
  border: 0;
}

.footer-nav {
  background-color: #171a23;
  width: 100%;
}

.footer-button {
  width: 60%;
  color: rgb(199, 199, 199);
}

.footer-bar-logo {
  font-size: 50px;
  color: rgb(83, 83, 255);
}
</style>
