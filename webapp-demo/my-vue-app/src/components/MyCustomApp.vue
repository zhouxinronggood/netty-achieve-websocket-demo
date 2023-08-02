<template>
    <div class="container">{{ message }}</div> 
    <!-- <TalkOtherDemo msg="TalkOtherDemo" /> -->
</template>

<script setup>

    import { getCurrentInstance} from 'vue';

    const {proxy} = getCurrentInstance()
    console.log(getCurrentInstance(), proxy)
    /*axios.get("http://10.31.88.155:8088/msg/send/online/list").then(
        res => {
            console.log(res)
        }
    ).catch(err => {
         console.log(err)
    })*/
    //import TalkOtherDemo from '../views/TalkOtherDemo.vue'
    const data = () => {
            return {
                message: "组件基础组成"
            }
        }
    proxy.$axios.post("/api/msg/send/online/list").then(
        res => {
            console.log(res)
        }
    ).catch(err => {
         console.log(err)
    })
</script>

<!-- scoped: 让当前样式只在当前组件中生效 -->
<style scoped>
    .container{
        font-size: 30px;
        color: red;
    }
</style>