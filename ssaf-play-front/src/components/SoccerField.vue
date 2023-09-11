<template>
  <div class="soccer-field-main">
    <section class="pitch">
      <div class="field left">
        <div class="penalty-area"></div>
      </div>
      <div class="field right">
        <div class="penalty-area"></div>
      </div>
      <div class="center-circle"></div>
      <div class="home-team">
        <div
          v-for="(p, idx) in 11"
          :key="idx"
          :class="`player ${numbers[idx]}`"
          @click="setNow(idx, $event)">
          <span class="pname" v-if="isChecked1[idx]"> {{team1[idx].name}} </span>
        </div>
      </div>
      <div class="visitor-team">
        <div
          v-for="(p, idx) in 11"
          :key="idx"
          :class="`player ${numbers[idx]}`"
          @click="setNow(idx, $event)">
          <span class="pname" v-if="isChecked2[idx]"> {{team2[idx].name}} </span></div>
      </div>
    </section>
    <div v-if="current != 0">현재 선택 : {{ current + 1 }} 번째</div>
    <input v-if="!isDone" type="submit" @click="tellMama(current)" value="개설"/>
    <div class="test" ref="abc"></div>
  </div>
</template>

<script>
import "../assets/soccerField.css";
export default {
  props:{
    isChecked1: Array,
    isChecked2: Array,
    team1: Array,
    team2: Array,
  },
  data(){
    return{
      isDone: false,
      teamNo: 0,
      current: 0,
      target: "",
      positions: [
        "GK",
        "DF",
        "DF",
        "DF",
        "DF",
        "MF",
        "MF",
        "MF",
        "MF",
        "FW",
        "FW",
      ],
      numbers: [
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine",
        "ten",
        "eleven",
      ],
    }
  },
  methods: {
    setNow(number, event) {
      if (event.target.parentElement._prevClass == "home-team") {
          this.teamNo = 1;
          if(!this.isChecked1[Number(number)]) {
          this.current = Number(number);
          this.target = event.target;
          console.log(this.teamNo)
        } else {
          alert("이미 선택된 자리입니다.")
        }
      } else {
          this.teamNo = 2;
          if(!this.isChecked2[Number(number)]) {
          this.current = Number(number);
          this.target = event.target;
          console.log(this.teamNo)
        } else {
          alert("이미 선택된 자리입니다.")
        }
      }
    },
    tellMama(number){
      this.$emit("setName", this.teamNo, number)
    }
  },
}
</script>

<style>

</style>