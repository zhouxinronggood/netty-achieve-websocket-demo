import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  transpileDependencies: true,
  devServer: {
   proxy: {
        '/api': { //请求路径关键字
         	target: 'http://localhost:8088', //对应自己的接口
           changeOrigin: true,  //是否允许跨域,在本地会创建一个虚拟服务端，然后发送请求的数据，
            pathRewrite: {
                '^/api': ''     //这里理解成用‘/api’代替target里面的地址，后面组件中我们掉接                                     口时直接用api代替
                // 比如我要调用'http://localhost:8024/management/user/add'，直接写‘/api/user/add’即可
            }
        }
    }
}
})
