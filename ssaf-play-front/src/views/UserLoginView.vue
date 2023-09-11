<template>
  <div class="login-container">
    <div class="login-card">
      <h1 class="login-title">로그인</h1>
      <form @submit.prevent="login">
        <div class="form-group">
          <label for="email">이메일:</label>
          <input type="email" id="email" v-model="email" required />
        </div>
        <div class="form-group">
          <label for="password">비밀번호:</label>
          <input type="password" id="password" v-model="password" required />
        </div>
        <button type="submit" class="login-button">로그인</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserLogin",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    login() {
      // 로그인 로직 작성
      let user = {
        email: this.email,
        password: this.password,
      };
      console.log(user);
      this.$store.dispatch("doLogin", user);
    },
  },
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #c5e4ff;
}

.login-card {
  max-width: 400px;
  padding: 40px;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-title {
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

input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #cccccc;
  border-radius: 3px;
}

.login-button {
  width: 100%;
  padding: 10px;
  background-color: #3399ff;
  border: none;
  color: #ffffff;
  font-weight: bold;
  border-radius: 3px;
  cursor: pointer;
}

.login-button:hover {
  background-color: #0088ff;
}
</style>
