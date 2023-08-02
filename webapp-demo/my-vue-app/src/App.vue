<script scoped>
  // 第一步：引入组件 【局部引用组件】
  import MyCustom from "./components/MyCustomApp.vue"

  export default {
    // 第二步：注入组件
    components:{
      MyCustom
    }
  }
</script>

<!-- 组件中 <template/> 标签 必须存在的 -->
<template>
  <!-- 第三部：显示组件 -->
  <!-- <my-custom /> or <MyCustom />-->
  <my-custom />
</template>

<style>
</style>
