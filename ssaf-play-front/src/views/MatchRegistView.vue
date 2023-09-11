<template>
  <div class="sports-view">
    <div>
      <label for="aaa">어떤 운동을 하고싶니?</label><br />
      <select v-model="sports" id="aaa">
        <option disabled value="">스포츠 선택</option>
        <option value="3">농구 (3인)</option>
        <option value="5">농구 (5인)</option>
        <option value="11">축구</option>
      </select>
    </div>
    <label for="title">제목 : </label>
    <input id="title" type="text" v-model="match.title" placeholder="제목" />
    <label for="content">내용 : </label>
    <input id="content" type="text" v-model="match.content" placeholder="내용" />
    <b-calendar
      v-model="cal.value"
      label-help=""
      label-no-date-selected="날짜를 선택하세요"
      label-selected="선택된 날짜"
    ></b-calendar>

    <b-time
      v-model="timer.value"
      label-no-time-selected="시간을 선택하세요"
      label-selected="선택된 시간"
      value="HH:mm:ss"
    ></b-time>
    <b-button variant="outline-primary" @click="registMatch()">개최</b-button>

  </div>
</template>

<script>

import { mapState } from "vuex";

export default {
  data() {
    return {
      cal: {
        value: "",
      },
      timer: {
        value: "",
        context: {
          hour12: true,
        },
      },
      head: 0,
      sports: 0,
      match: {
        title: "",
        content: "",
        start_date: "",
        limit_head_count: 0,
        address: "aa",
        location: "aa",
        latitude: -1,
        longitude: -1,
        sport: "",
      },
    };
  },
  methods: {
    registMatch(){
      this.match.limit_head_count = Number(this.sports) * 2;
      this.match.start_date = this.cal.value + " " + this.timer.value;

      if (Number(this.sports) == 11) {
        this.match.sport = "축구";
      } else {
        this.match.sport = "농구";
      }
      this.$store.dispatch("registMatch", this.match);
      this.$router.push("/");
      this.$router.go(0);
    },
  },
  computed: {
    ...mapState(["user"]),
  },
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

html,
body {
  width: 100%;
  height: 100%;
}

.sports-view {
  height: 1500px;
  display: flex;
  flex-direction: column;
  padding-top: 130px;
}

.player-list-box {
  display: flex;
  background-color: aquamarine;
  padding: 10px;
  /* height: 180px; */
  border: 1px solid black;
  border-radius: 20px;
}

.player-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(120px, 1fr));
  padding: 10px;
}
.player-list-box .player-card {
  margin-right: 10px;
  background-color: #fff;
  width: 100px;
  height: 150px;
  border: 1px solid black;
  border-radius: 20px;
  display: flex;
  box-sizing: border-box;
  margin: 10px;
  padding: 10px;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}

.player-card-profile {
  width: 50px;
  height: 50px;
  object-fit: cover;
  border: 1px solid black;
  background-color: mistyrose;
  border-radius: 50%;
}

.player-card p {
  margin: 0;
}
</style>
