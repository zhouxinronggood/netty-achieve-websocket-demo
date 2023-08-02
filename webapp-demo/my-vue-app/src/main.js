// 【全局引入组件】在main.js中引入
import { createApp } from 'vue'
import './style.css'
// 从一个但文件组件中导入根组件
import App from './App.vue'
// 引入axios组件
//import request from './axiosInstance'
import axios from 'axios'
import VueAxios from 'vue-axios'
// 引入element-plus组件
import ElementPlus from 'element-plus'
// 引入elementPlus样式
import 'element-plus/dist/index.css'
// 根组件 vue的实例对象，在一个vue项目中，有且只有一个vue的实例对象
const app = createApp(App)

// 在这中间 写组件的注入 app.component("其他需引用该组件的名称", "本文件内import时的名称")
app.use(ElementPlus, { size: 'small', zIndex: 3000 })
//app.use(VueAxios, axios)

// 将axios 绑定到vue对象上
// vue3 取消了Vue.prototype, 官方推荐使用globalProperties 
// app.prototype.$http = axios ==> app.config.globalProperties.$http = axios
app.config.globalProperties.$axios = axios
axios.defaults.baseURL = '/api';
axios.defaults.headers.post['Content-Type'] = 'application/json';
// 挂载应用：渲染应用，加载.vue文件，将.vue文件 挂载在容器中
// #app 对应的是index.html 中 <div> 中的id，所有的内容都是在这个<div>里面，所有index.html为入口
app.mount('#app')
