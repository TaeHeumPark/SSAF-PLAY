import Vue from "vue";
import VueRouter from "vue-router";

import IndexView from "../views/IndexView.vue";
import SportsView from "../views/SportsView.vue";

import UserLoginView from "../views/UserLoginView.vue";
import UserRegistView from "../views/UserRegistView.vue";

import MatchDetailView from "../views/MatchDetailView.vue";
import MatchRegistView from "../views/MatchRegistView.vue";
import MatchUpdateView from "../views/MatchUpdateView.vue";

import MypageView from "../views/MyPageView.vue";
import UserList from "../views/UserListView.vue";
import Admin from "../views/AdminView.vue";
import VideoCreate from "../views/VideoCreateView.vue";
import VideoList from "../views/VideoListView.vue";
import VideoDetail from "../views/VideoDetailView.vue";

import NoticePage from "@/components/static page/NoticePage.vue";
import TermsCondition from "@/components/static page/TermsCondition.vue";
import PersonalInformation from "@/components/static page/PersonalInformation.vue";

Vue.use(VueRouter);

// 제자리로 가는 라우터를 실행 때 오류를 무시함
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => {
    if (err.name !== "NavigationDuplicated") throw err;
  });
};

const routes = [
  {
    path: "/",
    name: "index",
    component: IndexView,
  },
  {
    path: "/login",
    name: "login",
    component: UserLoginView,
  },
  {
    path: "/regist",
    name: "regist",
    component: UserRegistView,
  },
  {
    path: "/sports",
    name: "sports",
    component: SportsView,
  },
  {
    path: "/match-detail/:match_id",
    name: "MatchDetailView",
    component: MatchDetailView,
  },
  {
    path: "/match-regist",
    name: "MatchRegistView",
    component: MatchRegistView,
  },
  {
    path: "/match-update",
    name: "MatchUpdateView",
    component: MatchUpdateView,
  },
  {
    path: "/mypage",
    name: "MypageView",
    component: MypageView,
  },
  {
    path: "/videolist",
    name: "VideoList",
    component: VideoList,
  },
  {
    path: "/videolist/id=:videoNo",
    name: "VideoDetail",
    component: VideoDetail,
  },
  {
    path: "/admin",
    name: "Admin",
    component: Admin,
  },
  {
    path: "/admin/userList",
    name: "userList",
    component: UserList,
  },
  {
    path: "/admin/video/create",
    name: "videoCreate",
    component: VideoCreate,
  },
  {
    path: "/notice",
    name: "notice",
    component: NoticePage,
  },
  {
    // 이용약관
    path: "/terms",
    name: "terms",
    component: TermsCondition,
  },
  {
    // 개인정보처리방침
    path: "/persnalinfo",
    name: "persnalinfo",
    component: PersonalInformation,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
