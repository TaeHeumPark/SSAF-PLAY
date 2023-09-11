<template>
  <div class="container notice">
    <div class="title pb-5">
      공지사항
    </div>
    <hr>
    <div class="container">
      <strong class="float-left">이제 마스크 벗고 뛰세요~</strong>
      <div class="float-right">2023-05-17</div>
    </div>
    <hr>
    <div class="container">
      <strong class="float-left">5월 다중 매칭왕 선발 중</strong>
      <div class="float-right">2023-05-02</div>
    </div>
    <hr>
  </div>
</template>

<script scoped>
export default {
  name: "NoticePage",
}
</script>

<style>
.notice {
  padding-top: 130px;
  height: 800px;
}

.title {
  font-weight: 900;
  font-size: 40px;
}
</style>