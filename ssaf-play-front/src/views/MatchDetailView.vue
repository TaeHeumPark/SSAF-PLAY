<template>
  <div class="match-detail-main">
    <!-- entry start -->
    <table class="match-entry">
      <thead>
        <tr>
          <th v-for="(property, idx) in property2korean" :key="idx">
            <td> {{ property }} </td>
          </th>
        </tr>
      </thead>
      <tbody>
        <tr class="user-list" v-for="(user, idx) in team1" :key="idx">
          <td>{{ user.team }} </td>
          <td>{{ user.name }}</td>
          <td v-if="`${user.name}` != 'undefined'" style="width:150px"><img
          :src="'http://localhost:9999/api-user/display?filename=' + `${user.profile_img}`"
        /></td>
          <td>{{ user.match_count }}</td>
          <td>{{ user.record }}</td>
          <td>{{ user.position_name }}</td>
          <td>{{ user.grade_name }}</td>
          <td>{{ user.team_idx }}</td>
        </tr>
      </tbody>
    </table>
    <hr>
    <table class="match-entry">
      <thead>
        <tr>
          <th v-for="(property, idx) in property2korean" :key="idx">
            <td> {{ property }} </td>
          </th>
        </tr>
      </thead>
      <tbody>
        <tr class="user-list" v-for="(user, idx) in team2" :key="idx">
          <td>{{ user.team }} </td>
          <td>{{ user.name }}</td>
          <td v-if="`${user.name}` != 'undefined'" style="width:150px"><img
          :src="'http://localhost:9999/api-user/display?filename=' + `${user.profile_img}`"
        /></td>
          <td>{{ user.match_count }}</td>
          <td>{{ user.record }}</td>
          <td>{{ user.position_name }}</td>
          <td>{{ user.grade_name }}</td>
          <td>{{ user.team_idx }}</td>
        </tr>
      </tbody>
    </table>
    <!-- entry end -->
    <button @click="loadData()"> 데이터 불러오기 </button><br>
    <button v-if="isJoined" @click="goMatchRegister()"> 경기참여 </button>
    
  </div>
</template>

<script>
import {mapState} from "vuex"
export default {
  data() {
    return {
      isJoined: true,
      property2korean: [
        "팀",
        "이름",
        "프로필사진",
        "출전수",
        "전적",
        "포지션",
        "등급",
        "번호"
      ],
      team1: ["", "", "", "", "", "", "", "", "", "", ""],
      team2: ["", "", "", "", "", "", "", "", "", "", ""],
    };
  },
  methods: {
    getTeam() {
      let head = 0;
      for (let i = 0; i < this.usermatch.length; i++) {
        if (this.usermatch[i].team == 1) {
          head += 1;
          this.team1.splice(this.usermatch[i].team_idx, 1, this.usermatch[i]);
        } else if (this.usermatch[i].team == 2) {
          head += 1;
          this.team2.splice(this.usermatch[i].team_idx, 1, this.usermatch[i]);
        } 

        if (this.usermatch[i].name == sessionStorage.getItem("name")) {
          this.isJoined = false;
        }
      }

      if (this.matchDetail.limit_head_count == head) {
        this.isJoined = false;
        alert("이미 꽉 찼습니다!");
      }
      sessionStorage.setItem("team1", JSON.stringify(this.team1));
      sessionStorage.setItem("team2", JSON.stringify(this.team2));
      
    },
    loadData(){
      this.getTeam();
    },

    goMatchRegister(){
      this.$router.push("/match-update");
    },
  },
  computed:{
    ...mapState(['usermatch', 'matchDetail'])
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

html,
body {
  width: 100%;
  height: 100%;
}

.match-detail-main {
  padding-top: 80px;
  width: 100%;
}

th,
td {
  padding: 5px;
}

td {
  text-align: center;
}


img {
  width: 100%;
  height: auto;
}
</style>
