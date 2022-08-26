import { createApp } from 'vue'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/js/bootstrap.bundle.min.js';
import './assets/style/common.css';
import App from './App.vue'
import store from './store/index';
import router from './router/index';


createApp(App).use(store).use(router).mount('#app')
