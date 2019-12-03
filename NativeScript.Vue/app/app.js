import Vue from 'nativescript-vue';

import Calculator from './components/Calculator';

// Uncommment the following to see NativeScript-Vue output logs
// Vue.config.silent = false;

new Vue({

    template: `
        <Frame>
            <Calculator />
        </Frame>`,

    components: {
        Calculator
    }
}).$start();