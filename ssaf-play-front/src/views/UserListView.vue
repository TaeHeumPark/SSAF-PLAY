<template>
  <div class="user-list-main">
    <table class="user-table">
      <thead>
        <tr>
          <th v-for="(property, idx) in property2korean" :key="idx">
            {{ property }}
          </th>
        </tr>
      </thead>
      <tbody>
        <tr class="user-list" v-for="(user, idx) in users" :key="idx">
          <!-- <td class="user" v-for="(properties, key, idx2) in user" :key="idx2"> -->
          <td>{{ idx + 1 }}</td>
          <td>{{ user.email }}</td>
          <td>{{ user.name }}</td>
          <td>{{ user.phone_number }}</td>
          <td>{{ user.profile_img }}</td>
          <td>{{ user.birth_date }}</td>
          <td>{{ user.reg_date }}</td>
          <td>{{ user.gender_name }}</td>
          <td>{{ user.manner_score }}</td>
          <td>{{ user.match_count }}</td>
          <td>{{ user.record }}</td>
          <td>{{ user.grade_name }}</td>
          <td>{{ user.preferred_position_name }}</td>
          <!-- </td> -->
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  data() {
    return {
      property2korean: [
        "등록번호",
        "이메일",
        "이름",
        "전화번호",
        "프로필사진",
        "생년월일",
        "등록시간",
        "성별",
        "매너점수",
        "출전수",
        "전적",
        "등급",
        "선호포지션",
      ],
    };
  },
  created() {
    this.$store.dispatch("getUserList");
  },
  computed: {
    ...mapState(["users"]),
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

.user-list-main {
  width: 100%;
  height: 100%;
  /* background-color: sandybrown; */
  /* display: flex; */
  justify-content: center;
}

th,
td {
  padding: 5px;
}

th {
  border-bottom: 1px solid sandybrown;
}

tr {
  height: 20px;
}
td {
  text-align: center;
}
</style>
