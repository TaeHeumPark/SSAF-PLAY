<template>
  <div class="signup-container">
    <div class="signup-card">
      <h1 class="signup-title">회원가입</h1>
      <form @submit.prevent="doLogin">
        <div class="form-group">
          <label for="email">이메일:</label>
          <input type="email" id="email" v-model="email" required />
        </div>
        <div class="form-group">
          <label for="password">비밀번호:</label>
          <input type="password" id="password" v-model="password" required />
        </div>
        <div class="form-group">
          <label for="name">이름:</label>
          <input type="text" id="name" v-model="name" required />
        </div>
        <div class="form-group">
          <label for="phone_number">전화번호 : (숫자만 입력)</label>
          <!-- <input
            id="phone_number"
            type="tel"
            placeholder="전화번호"
            v-model.trim="phone_number"
            pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
            required
          /> -->
          <input type="text" pattern="\d*" maxlength="11" v-model="phone_number" />
        </div>
        <div class="form-group">
          <label for="birth_date">생년월일 :&nbsp;</label>
          <input id="birth_date" type="date" v-model.trim="birth_date" required />
        </div>
        <div class="form-group">
          <fieldSet
            >성별 : <label for="man">남 </label>&nbsp;
            <input id="man" type="radio" v-model.trim="gender_id" value="1" checked />&nbsp;
            <label for="woman">여 </label>&nbsp;
            <input id="woman" type="radio" v-model.trim="gender_id" value="2" />
          </fieldSet>
        </div>
        <div class="form-group">
          <label for="profile_image">이미지 : </label>
          <input multiple @change="onInputImage()" ref="serverImage" id="profile_image" type="file" />
        </div>
        <div class="form-group">
          <label for="profile_image">선호 포지션&nbsp;</label>
          <select>
            <option value="1">공격수</option>
            <option value="2">미드필더</option>
            <option value="3">수비수</option>
            <option value="4">골키퍼</option>
            <option value="5">가드</option>
            <option value="6">포워드</option>
            <option value="7">센터</option>
            <option value="8">자유</option>
          </select>
        </div>
        <button type="submit" class="signup-button">가입하기</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      password: "",
      name: "",
      phone_number: "",
      profile_img: "",
      birth_date: "",
      gender_id: 0,
      file_name: "",
    };
  },
  methods: {
    doLogin() {
      let num = this.phone_number;
      this.phone_number = num.substr(0, 3) + "-" + num.substr(3, 4) + "-" + num.substr(7);

      const formData = new FormData();

      formData.append("email", this.email);
      formData.append("password", this.password);
      formData.append("name", this.name);
      formData.append("phone_number", this.phone_number);
      formData.append("profile_img", this.profile_img);
      formData.append("birth_date", this.birth_date);
      formData.append("gender_id", this.gender_id);
      formData.append("file_name", this.file_name);

      this.$store.dispatch("registUser", formData);
    },
    onInputImage() {
      this.profile_img = this.$refs.serverImage.files[0];
      this.file_name = this.$refs.serverImage.files[0].name;
    },
  },
};
</script>

<style scoped>
.signup-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #c5e4ff;
}

.signup-card {
  max-width: 400px;
  padding: 40px;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.signup-title {
  text-align: center;
  color: #333333;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-weight: bold;
  color: #333333;
  margin-bottom: 5px;
}

input[type="text"],
input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #cccccc;
  border-radius: 3px;
}

.signup-button {
  width: 100%;
  padding: 10px;
  background-color: #3399ff;
  border: none;
  color: #ffffff;
  font-weight: bold;
  border-radius: 3px;
  cursor: pointer;
}

.signup-button:hover {
  background-color: #0088ff;
}
</style>
