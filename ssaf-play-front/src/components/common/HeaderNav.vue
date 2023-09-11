<template>
  <div class="header-nav px-3">
    <router-link to="/">
      <div class="logo">𝙎𝙎𝘼𝙁-𝙋𝙇𝘼𝙔</div>
    </router-link>

    <div>
      <div>
        <router-link to="/regist" class="mx-3" v-if="loginUser == null">
          <b-icon icon="person-plus" variant="light" scale="2.5"></b-icon>
        </router-link>
        <router-link to="/mypage" class="mx-3" v-else>
          <b-icon icon="person" variant="light" scale="2.5"></b-icon>
        </router-link>

        <button v-b-toggle.sidebar-backdrop class="mx-3">
          <b-icon icon="text-left" variant="light" scale="2.5" />
        </button>

        <b-sidebar id="sidebar-backdrop" :backdrop-variant="variant" backdrop shadow right no-header>
          <!-- side-bar의 header 시작 -->
          <div class="d-flex justify-content-between align-items-center side-bar">
            <router-link to="/login" class="d-flex">
              <b-icon icon="power" variant="dark" scale="1.7" class="px-4 mt-1"></b-icon>
              <strong v-if="loginUser == null">LOGIN</strong>
              <button v-else @click="logout">
                <strong class="ml-5">LOGOUT</strong>
              </button>
            </router-link>
            <div>|</div>
            <router-link to="/regist" class="d-flex" v-if="loginUser == null">
              <b-icon icon="person-plus" variant="dark" scale="1.7" class="px-4 mt-1"></b-icon>
              <strong>JOIN</strong>
            </router-link>
            <router-link to="/mypage" v-else>
              <b-icon icon="person" variant="dark" scale="1.7" class="px-4 mt-1"></b-icon>
              <strong>MYPAGE</strong>
            </router-link>
            <button v-b-toggle.sidebar-backdrop class="side-bar-x-Btn">X</button>
          </div>
          <hr />
          <!-- side-bar의 header 끝 -->

          <!-- side-bar 아이템들 flex로 중앙정렬 -->
          <div class="container d-flex flex-column my-5 justify-content-center align-items-center side-bar-items">
            <div class="side-bar-logo mb-5">ѕѕaғ play</div>
            <button class="side-bar-item" @click="setSportInSession(1)">축구</button>
            <hr class="divider" />
            <button class="side-bar-item" @click="setSportInSession(2)">농구</button>
            <hr class="divider" />
            <div class="side-bar-item">SSAF-PLAY 소개</div>
            <hr class="divider" />
            <router-link to="/notice" class="side-bar-item">공지사항</router-link>
            <hr class="divider" />
            <router-link to="/terms" class="side-bar-item">이용약관</router-link>
            <hr class="divider" />
            <router-link to="/persnalinfo" class="side-bar-item">개인정보처리방침</router-link>
          </div>
        </b-sidebar>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HeaderNav",
  data() {
    return {
      loginUser: "",
    };
  },
  methods: {
    logout() {
      this.$store.commit("DO_LOGOUT");
      sessionStorage.removeItem("access-token");
      sessionStorage.removeItem("email");
      alert("로그아웃");
    },
    mypage() {
      if (sessionStorage.getItem("access-token") == null || sessionStorage.getItem("email") == null) {
        alert("로그인을 해주세요.");
      }
      this.$router.push("/mypage/");
    },
    setSportInSession(number) {
      let sport = "";
      if (number == 1) {
        sport = "축구";
      } else {
        sport = "농구";
      }
      sessionStorage.setItem("sport", sport);
      this.$router.push("/sports");
    },
  },
  created() {
    this.loginUser = sessionStorage.getItem("access-token");
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

button {
  background: inherit;
  border: none;
  box-shadow: none;
  border-radius: 0;
  padding: 0;
  overflow: visible;
  cursor: pointer;
}

button:hover {
  /* hover 스타일 제거 */
  border: none;
  outline: none;
}

a {
  text-decoration: none;
}

a:hover {
  color: aliceblue;
}

.logo {
  color: aliceblue;
  font-size: 40px;
}

.header-nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: fixed;
  height: 80px;
  background-color: rgba(105, 105, 105, 0.4);
  width: 100%;
  z-index: 10;
}

/* 사이드바 */

.side-bar a {
  color: black;
}

.side-bar-x-Btn {
  background-color: black;
  color: white;
  width: 70px;
  height: 70px;
  font-size: 30px;
}

.side-bar-logo {
  font-size: 50px;
  color: rgb(62, 62, 214);
}

.side-bar-items a {
  text-decoration: none;
  color: black;
}

.side-bar-items:hover a {
  color: black;
}

.side-bar-item {
  font-size: 20px;
  font-weight: bold;
}

/* hr */
.divider {
  width: 80%;
  margin-top: 25px;
  margin-bottom: 25px;
}
</style>
