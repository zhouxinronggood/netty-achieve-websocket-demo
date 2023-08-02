<!--
    vue2选项式API编写风格演示
-->

<template>
    <button @click="increment"> vue2选项式编写, count is {{ count }}</button>
</template>

<script>
export default {
    data(){
        return {
            count: 0
        }
    },
    methods: {
        increment(){
            this.count++
        }
    },
    mounted(){
        console.log(`vue2选项式编写, 点击累加演示: ${this.count}`)
    }
}
</script>