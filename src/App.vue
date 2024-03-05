<template>
<div class="logo">
  <img alt="Vue logo" src="./assets/logo.png">
</div>  
  <FinancialTransfer msg="Lista de Transferências Financeiras"/>
</template>

<script>
import FinancialTransfer from './components/FinancialTransfer.vue'

export default {
  name: 'App',
  components: {
    FinancialTransfer
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.logo {
  background: black
}
</style>
