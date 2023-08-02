<!--
    本文件，演示vue 动态内容加载
-->

<template>
  <div class="hello">
    <h3>HelloWorld!</h3>
    <p>{{ message }}</p>
    <!-- 双大括号会将数据解释为普通文本而非HTML代码, 需要使用v-html属性-->
    <div>{{ rawHtml }}</div>
    <div v-html="rawHtml"></div>
    
    <!-- 动态设置属性值需要使用 v-bind , 可使用:属性 代替 v-bind-->
    <div v-bind:id="dynamitcId"></div>
    <div :id="dynamitcId"></div>
  </div>
</template>

<script>
  export default {
    name: 'HelloWorld',
    data() {
      return {
        message: "演示",
        rawHtml: "<a href='https://www.baidu.com/index.php?tn=monline_3_dg'>百度</a>",
        dynamitcId: 10001
      }
    }
  }
</script>

