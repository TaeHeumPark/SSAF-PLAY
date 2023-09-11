<template>
  <div class="sports-view">
    <button @click="loadData()">불러오기</button>
    <div>
      <label for="aaa">어떤 운동을 하고싶니?</label><br />
      <select v-model="sports" id="aaa" aria-readonly="">
        <option disabled value="">스포츠 선택</option>
        <option disabled value="3">농구 (3인)</option>
        <option disabled value="5">농구 (5인)</option>
        <option disabled value="11">축구</option>
      </select>
    </div>
    <label for="title">제목 : </label>
    <input id="title" type="text" v-model="matchDt.title" placeholder="제목" readonly/>
    <label for="content">내용 : </label>
    <input id="content" type="text" v-model="matchDt.content" placeholder="내용" readonly/>
    <label for="address">내용 : </label>
    <input id="address" type="text" v-model="matchDt.address" placeholder="내용" readonly/>
    <b-calendar
      v-model="cal.value"
      label-help=""
      label-no-date-selected="날짜를 선택하세요"
      label-selected="선택된 날짜" readonly
    ></b-calendar>
    <div>{{ cal.value }}</div>
    <b-time
      v-model="timer.value"
      label-no-time-selected="시간을 선택하세요"
      label-selected="선택된 시간"
      value="HH:mm:ss" readonly
    ></b-time>
    <div>현재 정원 : {{ head }}</div>
    <soccer-field
      v-if="sports == 11"
      :user="user"
      :isChecked1="isChecked1"
      :isChecked2="isChecked2"
      :team1="team1"
      :team2="team2"
      @setName="setName"
    ></soccer-field>
    <basketball-field
      v-else-if="sports == 5 || sports == 3"
      :sports="sports"
      :isChecked1="isChecked1"
      :isChecked2="isChecked2"
      :team1="team1"
      :team2="team2"
      @setName="setName"
    ></basketball-field>
    <div v-if="sports != 0" class="player-list">
      <h3>TEAM 1 :</h3>
      <div class="player-list-box player-grid">
        <div v-for="(p, idx) in Number(sports)" :key="idx" @click="clickCard($event)">
          <div :class="`player-card card-${idx}`">
            {{ idx + 1 }}
            <div class="player-card-profile"></div>
            <span class="" v-if="isChecked1[idx]"> {{ positions[idx] }} </span>
            <span class="" v-if="isChecked1[idx]"> {{ team1[idx].name }} </span>
          </div>
        </div>
      </div>
    </div>
    <div v-if="sports != 0" class="player-list">
      <h3>TEAM 2 :</h3>
      <div class="player-list-box player-grid">
        <div v-for="(p, idx) in Number(sports)" :key="idx" @click="clickCard($event)">
          <div :class="`player-card card-${idx}`">
            {{ idx + 1 }}
            <div class="player-card-profile"></div>
            <span class="" v-if="isChecked2[idx]"> {{ positions[idx] }} </span>
            <span class="" v-if="isChecked2[idx]"> {{ team2[idx].name }} </span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BasketballField from "../components/BasketballField.vue";
import SoccerField from "../components/SoccerField.vue";
import { mapState } from "vuex";

export default {
  components: {
    SoccerField,
    BasketballField,
  },
  data() {
    return {
      isShow: false,
      head: 0,
      sports: 0,
      matchDt:{},
      match: {
        user_id: 0,
        match_id: 0,
        match_positions: 0,
        team: 0,
        team_idx: 0,
      },
      cal:{
        value: "",
      },
      timer:{
        value: "",
      },
      teamNo: 0,
      target: "",
      isChecked1: [false, false, false, false, false, false, false, false, false, false, false],
      isChecked2: [false, false, false, false, false, false, false, false, false, false, false],
      team1: ["", "", "", "", "", "", "", "", "", "", ""],
      team2: ["", "", "", "", "", "", "", "", "", "", ""],
      positions: ["GK", "DF", "DF", "MF", "MF", "MF", "MF", "FW", "FW", "FW", "FW"],
      positions2: ["GK", "DF", "DF", "MF", "MF", "MF", "MF", "FW", "FW", "FW", "FW"],
      numbers: ["one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"],
    };
  },
  methods: {
    setName(teamNo, number) {
      this.match.user_id = sessionStorage.getItem("id");
      this.match.match_id = sessionStorage.getItem("match_id");
      this.match.team = teamNo;
      this.match.team_idx = number;
      if (this.sports == 11) {
        // 축구
        if (this.match.team_idx == 0) {
          this.match.match_positions = 4; // 골키퍼
        } else if (this.match.team_idx >= 1 && this.match.team_idx <= 4) {
          this.match.match_positions = 3; // 수비수
        } else if (this.match.team_idx >= 5 && this.match.team_idx <= 8) {
          this.match.match_positions = 2; // 미드
        } else if (this.match.team_idx >= 9 && this.match.team_idx <= 10) {
          this.match.match_positions = 1; // 공격수
        }
      } else {
        // 농구
        if (this.match.team_idx == 0) {
          this.match.match_positions = 7; // 센터
        } else if (this.match.team_idx == 1 || this.match.team_idx == 3) {
          this.match.match_positions = 6; // 포워드
        } else if (this.match.team_idx == 2 || this.match.team_idx == 4) {
          this.match.match_positions = 5; // 가드
        }
      }
      console.log(this.match);
      if (teamNo == 1) {
        if (!this.isChecked1[number]) {
          this.$set(this.team1, number, sessionStorage.getItem("name"));
          this.$set(this.isChecked1, number, true);
          console.log(this.team2[number]);
        }
      } else if (teamNo == 2) {
        if (!this.isChecked2[number]) {
          this.$set(this.team2, number, sessionStorage.getItem("name"));
          this.$set(this.isChecked2, number, true);
          console.log(this.team2[number]);
        }
      }

      this.$store.dispatch("registUserMatch", this.match);
      alert("참여 완료!");
      this.$router.push("/sports");
      this.$router.go(0);
    },
    loadData(){
      this.matchDt = this.matchDetail;
      if (this.matchDt.limit_head_count == 6) {
        this.sports = 3;
      } else if (this.matchDt.limit_head_count == 10) {
        this.sports = 5;
      } else {
        this.sports = 11;
      }
      let date = this.matchDetail.start_date.split(" ");
      // let date = this.matchDetail.start_date;
      // console.log(date);
      this.cal.value = date[0];
      this.timer.value = date[1];
    }
  },
  created() {
    console.log("!created!");
    if (sessionStorage.getItem("sport") == "축구") {
      console.log("축구");
      console.log(sessionStorage.getItem("sport"));
    }

    // 팀 가져오기
    let tmp1 = JSON.parse(sessionStorage.getItem("team1"));
    console.log(tmp1);
    if (tmp1 != null) {
      this.team1 = tmp1;
    }

    let tmp2 = JSON.parse(sessionStorage.getItem("team2"));
    console.log(tmp2);
    if (tmp2 != null) {
      this.team2 = tmp2;
    }

    // 가져온 팀의 출석 반영
    let head = 0;
    for (let i = 0; i < this.team1.length; i++) {
      if (this.team1[i].length != 0) {
        head += 1;
        this.isChecked1[i] = true;
      }
    }

    for (let i = 0; i < this.team2.length; i++) {
      if (this.team2[i].length != 0) {
        head += 1;
        this.isChecked2[i] = true;
      }
    }

    this.head = head;
    console.log(this.$store.state.user);
    console.log(this.$store.state.user.name);
    this.match.user_id = Number(sessionStorage.getItem("user_id"));
    this.match.match_id = Number(sessionStorage.getItem("match_id"));

    if (this.$store.state.match.limit_head_count == 22) {
      this.sports == 11;
    } else if (this.$store.state.match.limit_head_count == 10) {
      this.sports == 5;
    } else if (this.$store.state.match.limit_head_count == 6) {
      this.sports == 3;
    }
  },
  computed: {
    ...mapState(["user", "matchDetail"]),
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
  height: 2000px;
  display: flex;
  flex-direction: column;
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
