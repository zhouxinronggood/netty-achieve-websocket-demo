<!-- 
    vue3组合式API编写风格演示
-->

<template>
  <button @click="increment">vue3组合式编写, count is {{ count }}</button>
</template>

<script setup>
import { ref, onMounted } from "vue";
const count = ref(0);

function increment() {
  count.value++;
}

onMounted(() => {
  console.log(`vue3组合式编写, 点击累加演示: ${count.value}`);
});
</script>