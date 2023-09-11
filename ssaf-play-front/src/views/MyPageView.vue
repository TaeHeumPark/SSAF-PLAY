<template>
  <div class="mypage-top">
    <div class="container d-flex mypage-main">
      <aside class="p-5 d-flex flex-column align-items-center">
        <img
          :src="
            'http://localhost:9999/api-user/display?filename=' +
            `${user.file_name}`
          "
        />
        <div class="title mt-5">{{ user.name }}</div>
        <div class="my-2">
          <b-icon icon="telephone-fill" aria-hidden="true" />
          {{ user.phone_number }}
        </div>
        <div class="grade-name-box my-3">
          <div class="grade-name-content">{{ user.grade_name }}</div>
        </div>
        <div class="user-delete-btn" @click="delete_user">회원탈퇴</div>
      </aside>
      <!-- 여기부터 오른쪽(main) -->
      <main class="p-5">
        <div class="title">나의 기록</div>
        <div class="d-flex justify-content-between mx-5 cards">
          <b-card
            border-variant="primary"
            header="매너점수"
            header-bg-variant="primary"
            header-text-variant="white"
            align="center"
            class="b-card"
          >
            <b-card-text class="card-content">{{
              user.manner_score
            }}</b-card-text>
          </b-card>

          <b-card
            border-variant="secondary"
            header="출전"
            header-border-variant="secondary"
            align="center"
            class="b-card"
          >
            <b-card-text class="card-content">{{
              user.match_count
            }}</b-card-text>
          </b-card>
          <b-card
            border-variant="dark"
            header="승 무 패"
            align="center"
            class="b-card"
          >
            <b-card-text class="card-content">{{ user.record }}</b-card-text>
          </b-card>
        </div>
      </main>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "MyPage",
  methods: {
    delete_user() {
      let email = sessionStorage.getItem("email");
      this.$store.dispatch("deleteUser", email);
    },
  },
  created() {
    this.$store.dispatch("mypage");
  },
  computed: {
    ...mapState(["user"]),
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

.mypage-top {
  padding-top: 130px;
  padding-bottom: 40px;
  background-color: rgb(243, 243, 243);
}

aside {
  width: 25%;
  background-color: #1b4cec;
  color: white;
  border-radius: 25px 0 0 25px;
}

main {
  width: 70%;
  background-color: white;
  border-radius: 0 25px 25px 0;
}

.grade-name-box {
  width: 210px;
  height: 70px;
  background-color: white;
  border-radius: 15px;
  text-align: center;
}

.grade-name-content {
  color: black;
  font-weight: 700;
  font-size: 32px;
  padding-top: 13px;
}

.user-delete-btn {
  text-decoration: underline;
  cursor: pointer;
}

.cards {
  padding-top: 70px;
}

.b-card {
  width: 25%;
  font-weight: bold;
  font-size: 20px;
}

.card-content {
  font-size: 40px;
}

img {
  width: 100%;
  height: auto;
}
</style>
