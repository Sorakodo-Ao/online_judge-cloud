<template>
  <div id="loginView">
    <h2 class="title">用户注册</h2>
    <a-form
      :model="form"
      label-align="left"
      auto-label-width
      style="max-width: 450px; margin: 0 auto"
      @submit="handleSubmit"
    >
      <a-form-item field="userAccount" label="账号">
        <a-input v-model="form.userAccount" placeholder="请输入账号" />
      </a-form-item>
      <a-form-item field="userPassword" label="密码">
        <a-input-password
          v-model="form.userPassword"
          placeholder="请输入密码"
        />
      </a-form-item>
      <a-form-item field="userPassword" label="确认密码">
        <a-input-password
          v-model="form.checkPassword"
          placeholder="请确认密码"
        />
      </a-form-item>
      <a-form-item>
        <a-space>
          <a-button type="primary" style="width: 100px" html-type="submit"
            >注册
          </a-button>
          <a-link
            :hoverable="false"
            href="/user/login"
            style="margin-left: 36px"
            >已有账号？登录
          </a-link>
        </a-space>
      </a-form-item>
    </a-form>
  </div>
</template>
<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserRegisterRequest } from "../../../generated";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";
import message from "@arco-design/web-vue/es/message";

const router = useRouter();
const route = useRoute();
const store = useStore();

const form = reactive({
  userAccount: "",
  userPassword: "",
  checkPassword: "",
} as UserRegisterRequest);
const handleSubmit = async () => {
  const res = await UserControllerService.userRegister(form);
  if (res.code === 0) {
    message.success("注册成功!");
    await router.push({
      path: "/user/login",
      replace: true,
    });
  }
};
</script>
<style>
#loginView .title {
  color: aliceblue;
  margin-bottom: 15px;
}
</style>
