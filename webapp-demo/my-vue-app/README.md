# Vue 3 + Vite

# 入门学习视频：
### https://www.bilibili.com/video/BV1Rs4y127j8?p=6&vd_source=de27893913a72f8dd4c5ad7d2dbb608a
### https://www.bilibili.com/video/BV1TT411V7dW?p=12&vd_source=de27893913a72f8dd4c5ad7d2dbb608a


<script setup>
import HelloWorld from './views/HelloWorld.vue'
import DynamicModification from './views/DynamicModification.vue'
import HelloVue2Code from './views/HelloVue2Code.vue'
import HelloVue3Code from './views/HelloVue3Code.vue'
import TalkOtherDemo from './views/TalkOtherDemo.vue'
</script>

<template>
  <div>
    <a href="https://vitejs.dev" target="_blank">
      <img src="/vite.svg" class="logo" alt="Vite logo" />
    </a>
    <a href="https://vuejs.org/" target="_blank">
      <img src="./assets/vue.svg" class="logo vue" alt="Vue logo" />
    </a>
  </div>
  <HelloWorld msg="Vite + Vue" />
  <DynamicModification msg="DynamicModification" />
  <HelloVue2Code msg="HelloVue2Code" />
  <HelloVue3Code msg="HelloVue3Code" />
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
