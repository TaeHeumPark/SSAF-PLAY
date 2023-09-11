import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "../router";

Vue.use(Vuex);

const REST_API = `http://localhost:9999/api`;

export default new Vuex.Store({
  state: {
    user: {},
    users: [],
    video: {},
    videos: [],
    match: {},
    matchDetail: {},
    // matches : 전체 경기 정보
    matches: [],
    // usermatch : 한 경기에 누가누가 참여하는지에 대한 정보
    usermatch: [],
  },
  getters: {},
  mutations: {
    // admin-controller
    GET_USERS: function (state, userList) {
      state.users = userList;
    },

    // match-board-controller
    GET_MATCHES_BY_SPORT: function (state, matches) {
      state.matches = matches;
    },
    GET_MATCH_DETAIL: function (state, matchDetail) {
      state.matchDetail = matchDetail;
    },
    REGIST_MATCH: function (state, match) {
      state.matches.push(match);
    },

    // user-controller
    DO_LOGIN: function (state, user) {
      state.user = user;
    },
    DO_LOGOUT: function (state) {
      state.user = "";
    },
    MY_PAGE(state, user) {
      state.user = user;
    },
    REGIST_USER: function (state, user) {
      state.users.push(user);
    },

    // user-match-controller
    GET_USER_MATCH: function (state, usermatch) {
      state.usermatch = usermatch;
      console.log(JSON.stringify(usermatch));
      sessionStorage.setItem("userMatch", JSON.stringify(usermatch));
    },

    // video-controller
    GET_VIDEOS_BY_SPORT: function (state, videos) {
      state.videos = videos;
    },
    GET_VIDEO_DETAIL: function (state, video) {
      state.video = video;
    },
  },
  actions: {
    // admin-controller
    getUserList({ commit }) {
      const API_URL = `${REST_API}-admin/userList`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log("getUserList : " + res.data);
          commit("GET_USERS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    // match-board-controller
    getMatchesBySport({ commit }, sport) {
      const API_URL = `${REST_API}-match/board/${sport}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("GET_MATCHES_BY_SPORT", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getMatchDetail({ commit }, match_id) {
      const API_URL = `${REST_API}-match/board/detail/${match_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log("getMatchDetail : " + res.data);
          commit("GET_MATCH_DETAIL", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    deleteMatch({ commit }, match_id) {
      commit;
      const API_URL = `${REST_API}-match/board/detail/delete/${match_id}`;
      axios({
        url: API_URL,
        method: "POST",
      })
        .then((res) => {
          console.log("deleteMatch : " + res.data);
          alert("경기 삭제 완료!");
          // 일단 임시로 홈으로 가게한다.
          alert("작업 완료 후 라우팅 미완성");
          router.push(`/`);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    updateMatch({ commit }) {
      commit;
      const API_URL = `${REST_API}-match/board/detail/update`;
      axios({
        url: API_URL,
        method: "POST",
      })
        .then((res) => {
          console.log("updateMatch : " + res.data);
          alert("경기 수정 완료!");
          // 일단 임시로 홈으로 가게한다.
          alert("작업 완료 후 라우팅 미완성");
          router.push(`/`);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    registMatch({ commit }, match) {
      const API_URL = `${REST_API}-match/board/regist`;
      axios({
        url: API_URL,
        method: "POST",
        params: match,
      })
        .then(() => {
          commit("REGIST_MATCH", match);
          alert("경기 등록 완료!");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    // user-controller
    doLogin({ commit }, user) {
      const API_URL = `${REST_API}-user/login`;
      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
        .then((res) => {
          commit("DO_LOGIN", user); // 필요하다면 데이터도 같이 올려보내라
          // console.log(user);
          console.log(JSON.stringify(res.data));
          sessionStorage.setItem("access-token", res.data["access-token"]);
          sessionStorage.setItem("email", user.email);
          sessionStorage.setItem("name", res.data.name);
          alert("환영합니다!");
          router.push("/");
          router.go(0);
        })
        .catch((err) => {
          console.log(err);
          alert("아이디, 비밀번호를 다시 확인해주세요.");
        });
    },
    doLogout({ commit }) {
      const API_URL = `${REST_API}-user/logout`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          sessionStorage.setItem("access-token", res.data["access-token"]);
          sessionStorage.removeItem("access-token");
          commit("DO_LOGOUT"); // 필요하다면 데이터도 같이 올려보내라
        })
        .catch((err) => {
          console.log(err);
        });

      router.push("/");
      router.go(0);
    },

    mypage({ commit }) {
      let tmp = sessionStorage.getItem("email");
      const API_URL = `${REST_API}-user/mypage/` + tmp;
      axios({
        url: API_URL,
        method: "POST",
      })
        .then((res) => {
          commit("MY_PAGE", res.data);
          sessionStorage.setItem("id", res.data["user_id"]);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    deleteUser({ commit }, email) {
      commit;
      const API_URL = `${REST_API}-user/mypage/delete/${email}`;
      axios({
        url: API_URL,
        method: "POST",
      })
        .then(() => {
          alert("그동안 저희 서비스를 이용해주셔서 감사합니다.");
          sessionStorage.removeItem("access-token");
          sessionStorage.removeItem("email");
          router.push("/");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    registUser({ commit }, formData) {
      const API_URL = `${REST_API}-user/regist`;
      axios({
        url: API_URL,
        method: "POST",
        data: formData,
        headers: { "Content-Type": "multipart/form-data" },
      })
        .then(() => {
          console.log("registUser : " + formData);
          commit("REGIST_USER", formData);
          alert("가입을 환영합니다!");
          router.push(`/`);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    // user-match-controller
    getUserMatch({ commit }, match) {
      // 경기에 누가누가 참여하나 정보가 들어있음
      // getMatchDetail과는 다르다.
      const API_URL = `${REST_API}-match/${match.match_id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log(match);
          console.log("getUserMatch : " + JSON.stringify(res.data));
          // router.push(`/match-detail/${match.match_id}`);
          commit("GET_USER_MATCH", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    deleteUserMatch({ commit }) {
      commit;
      const API_URL = `${REST_API}-match/cancel`;
      axios({
        url: API_URL,
        method: "POST",
      })
        .then(() => {
          alert("경기 삭제.");
          router.push("/");
          console.log("삭제 완료");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    registUserMatch({ commit }, match) {
      const API_URL = `${REST_API}-match/regist`;
      axios({
        url: API_URL,
        method: "POST",
        params: match,
      })
        .then(() => {
          console.log(match);
          commit("REGIST_MATCH", match);
          alert("등록 완료.");
          console.log("등록 완료");
        })
        .catch((err) => {
          console.log(err);
        });
    },

    // video-controller
    getVideosBySport({ commit }, sport) {
      const API_URL = `${REST_API}-video/${sport}`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          console.log("getVideosBySport : " + res.data);
          commit("GET_VIDEOS_BY_SPORT", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    getVideoDetail({ commit }, video) {
      const API_URL = `${REST_API}-video/detail/${video.video_no}`;
      axios({
        url: API_URL,
        method: "GET",
        params: video,
      })
        .then(() => {
          console.log("getVideoDetail : " + video);
          commit("GET_VIDEO_DETAIL", video);
        })
        .catch((err) => {
          console.log(err);
        });
    },

    registVideo({ commit }, video) {
      const API_URL = `${REST_API}-video/regist`;
      axios({
        url: API_URL,
        method: "POST",
        params: video,
      })
        .then(() => {
          console.log("registVideo : " + video);
          commit("REGIST_VIDEO", video);
          alert("영상 등록 완료!");
        })
        .catch((err) => {
          console.log(err);
        });

      alert("작업 완료 후 라우팅 미완성");
      router.push("/");
    },
  },
  modules: {},
});
