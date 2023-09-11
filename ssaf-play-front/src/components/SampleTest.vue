<template>
  <div>
    <form v-on:submit.prevent="onSubmit(`${answer}`)">
      <div v-for="(player, idx) in 11" :key="idx">
        <input
          type="radio"
          name="radioBtn"
          :id="`r${idx + 1}`"
          v-if="!isChecked[idx]"
          @change="radioChange($event)"
          :value="`${idx}`" />
        <br />
        <label :for="`r${idx + 1}`">{{ setName(idx) }} </label>
        <hr />
      </div>
      <br />
      <input type="submit" ref="submit" />
    </form>
    <p>현재 선택된 것 : {{ this.answer }}</p>
    <p>최종 선택된 것 : {{ this.real }}</p>
  </div>
</template>

<script>
export default {
  name: 'SampeTest',
  props : {
    isChecked: Array,
    names: Array,
    position: Array,
    numbers: Array,
    radioChange: Function,
    setName: Function,
    answer: Number,
    real: String,
  }
};
</script>

<style></style>
