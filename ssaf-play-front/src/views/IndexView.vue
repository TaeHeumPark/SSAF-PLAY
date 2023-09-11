<template>
  <div>
    <div class="main" :style="{ height: height + 'px' }">
      <div class="main-img" id="main-soccer" @click="setSportInSession(1)">
        <div class="hover-box">
          <div class="btn">
            <span>축구</span>
          </div>
          <div class="introduce">혼자서 슛 연습은 그만!<br />SSAF-PLAY에서 함께 즐기세요</div>
        </div>
      </div>
      <div class="main-img" id="main-basketball" @click="setSportInSession(2)">
        <div class="hover-box">
          <div class="btn">
            <span>농구</span>
          </div>
          <div class="introduce">혼자서 반코드 농구는 그만!<br />SSAF-PLAY에서 함께 즐기세요</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 크롬 브라우저 최소 가로일 때 값
      height: 700,
    };
  },
  components: {},
  methods: {
    setSportInSession(number) {
      console.log(number);
      let sport = "";
      if (number == 1) {
        sport = "축구";
      } else {
        sport = "농구";
      }
      sessionStorage.setItem("sport", sport);
      this.$router.push("/sports");
    },
    handleResize() {
      let width = window.innerWidth;
      console.log(width + "가로");
      if (width < 650) {
        this.height = width - 100;
      } else if (width < 900) {
        this.height = width - 150;
      } else if (width < 1050) {
        this.height = width - 200;
      } else if (width < 1500) {
        this.height = width - 300;
      } else if (width >= 1500) {
        this.height = width - 400;
      }
    },
  },
  mounted() {
    window.addEventListener("resize", this.handleResize);
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.handleResize);
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

a {
  text-decoration: none;
  color: black;
}
.main {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 100%;
}
.main-img {
  width: 50%;
  height: 100%;
  background-size: cover;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  transition: all 0.5s ease-in-out;
}
.main-img:hover .hover-box {
  /* font-size: 50px; */
  transition: all 0.5s ease-in-out;
  opacity: 1;
  translate: 0px -20px;
}

.main-img:not(:hover) .hover-box {
  transition: all 0.5s ease-in-out;
}
#main-basketball {
  background-image: url("https://lh3.googleusercontent.com/u/1/drive-viewer/AFGJ81om3Hpsw5DY-_4Vx-6JOcATLPAQzwdeik1rQaQU_iaEDWyCFNCZbqxsH5rHEgMEwqO-Vc1nc2AZ9YzqHLheS6fyqr4Yvw=w3754-h1616");
}
#main-soccer {
  background-image: url("https://lh3.googleusercontent.com/u/1/drive-viewer/AFGJ81qIeyyWVL1dcwe3yNZ3dtaEOO7MLHcNx8Yg-X7vpBw5-IHXH_o5QJuR54Dsx6tjrL2ZE8vr4LjNIuNvUhkVmRHkS9B7fg=w3754-h1730");
}
#main-basketball:hover {
  width: 70%;
  transition: all 0.5s;
}
#main-soccer:hover {
  width: 70%;
  transition: all 0.5s;
}

.hover-box {
  opacity: 0;
}

.btn {
  width: 230px;
  height: 98px;
  background-image: url("../assets/main_btn_hover.png");
  background-repeat: no-repeat;
  background-position: 50% 50%;
  line-height: 65px;
  display: flex;
  justify-content: center;
}

.introduce {
  font-size: 22px;
  letter-spacing: 2px;
  color: white;
  text-align: center;
  transform: translateX(-3.1rem);
  text-shadow: -0.3px 0 #000, 0 0.3px #000, 0.3px 0 #000, 0 -0.3px #000;
  font-weight: 600;
}
</style>
