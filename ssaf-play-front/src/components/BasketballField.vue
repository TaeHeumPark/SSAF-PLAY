<template>
  <div>
    <section class="b-pitch">
      <div class="b-field b-left">
        <div class="b-penalty-area"></div>
        <div class="b-left-circle"></div>
        <div class="b-left-area"></div>
        <div class="b-left-half"></div>
        <div class="b-goal"></div>
      </div>
      <div class="b-field b-right">
        <div class="b-penalty-area"></div>
        <div class="b-right-circle"></div>
        <div class="b-right-area"></div>
        <div class="b-right-half"></div>
        <div class="b-goal"></div>
      </div>
      <div class="b-center-circle"></div>
      <div class="b-home-team">
        <div
          v-for="(p, idx) in Number(sports)"
          :key="idx"
          :class="`b-player ${numbers[idx]}`"
          @click="setNow(idx, $event)">
          <p class="b-pname" v-if="isChecked1[idx]"> {{ team1[idx].name }} </p>
        </div>
      </div>
      <div class="b-visitor-team">
        <div
          v-for="(p, idx) in Number(sports)"
          :key="idx"
          :class="`b-player ${numbers[idx]}`"
          @click="setNow(idx, $event)">
          <p class="b-pname" v-if="isChecked2[idx]"> {{ team2[idx].name }} </p>
        </div>
      </div>
    </section>
    <div v-if="current != 0">현재 선택 : {{ current + 1 }} 번째</div>
    <input type="submit" @click="tellMama(current)" value="개설"/>
  </div>
</template>

<script>
import "../assets/basketballField.css";
export default {
  props: {
    user: Object,
    sports: String,
    isChecked1: Array,
    isChecked2: Array,
    team1: Array,
    team2: Array,
  },
  data() {
    return {
      teamNo: 0,
      current: 0,
      target: "",
      numbers: ["one", "two", "three", "four", "five"],
    };
  },
  methods: {
    setNow(number, event) {
      if (event.target.parentElement._prevClass == "b-home-team") {
        this.teamNo = 1;
        if (!this.isChecked1[Number(number)]) {
          this.current = Number(number);
          this.target = event.target;
        } else {
          alert("이미 선택된 자리입니다.");
        }
      }
      
      if (event.target.parentElement._prevClass == "b-visitor-team") {
        this.teamNo = 2;
        if (!this.isChecked2[Number(number)]) {
          this.current = Number(number);
          this.target = event.target;
        } else {
          alert("이미 선택된 자리입니다.");
        }
      }
    },
    tellMama(number){
      this.$emit("setName", this.teamNo, number)
    },
  },
};
</script>

<style></style>
