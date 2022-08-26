import { createRouter, createWebHistory} from 'vue-router';
import Hello from '../pages/Hello.vue';
import SignupPage from'../pages/SignupPage.vue';
import SigninPage from '../pages/SigninPage.vue';
import FormsPage from '../pages/FormsPage.vue';
import FormPage from '../pages/FormPage.vue';
import FormNewPage from '../pages/FormNewPage.vue';
import FormUpdatePage from '../pages/FormUpdatePage.vue';
import FormAnswersPage from '../pages/FormAnswersPage.vue';
import FormResponsesPage from '../pages/FormResponsesPage.vue';
import FormResponsePage from '../pages/FormResponsePage.vue';

const routes = [
    {
        path : "/",
        component : Hello
    },
    {
        path : "/signup",
        component : SignupPage
    },
    {
        path : "/signin",
        component : SigninPage
    },
    {
        path : "/forms",
        component : FormsPage
    },
    {
        path : "/forms/:id",
        component : FormPage
    },
    {
        path : "/forms/new",
        component : FormNewPage
    },
    {
        path : "/forms/:id/update",
        component : FormUpdatePage
    },
    {
        path : "/forms/:id/answers",
        component : FormAnswersPage
    },
    {
        path : "/forms/:id/responses",
        component : FormResponsesPage,
    },
    {
        path : "/forms/:id/responses/:resId",
        component : FormResponsePage
    }
]

const router = createRouter({
    history : createWebHistory(),
    routes
});

export default router;