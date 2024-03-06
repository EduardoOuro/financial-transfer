<template>
  <div class="transaction">
    <h2>{{ msg }}</h2>

  <form v-if="newTranfer" @submit.prevent="agendarTransferencia" class="transfer-form">

  <div class="container">
    <div class="form-group">
      <label for="contaOrigem">Conta de Origem:</label>
      <input type="text" id="contaOrigem" v-model="transfer.contaOrigem" required>
    </div>

    <div class="form-group">
      <label for="contaDestino">Conta de Destino:</label>
      <input type="text" id="contaDestino" v-model="transfer.contaDestino" required>
    </div>
  </div>
    
  <div class="container">
    <div class="form-group">
      <label for="valor">Valor:</label>
      <input type="number" id="valor" v-model="transfer.valor" required>
    </div>

    <div class="form-group">
      <label for="dataTransferencia">Data da Transferência:</label>
      <input type="date" id="dataTransferencia" v-model="transfer.dataTransferencia" required>
    </div>
  </div>

    <div class="form-submit">
      <button type="submit">Agendar Transferência </button>
    </div>
  </form>
    <div v-if="erroEnvio" class="alert-danger" role="alert">
      Ocorreu um erro ao enviar a transferência. Por favor, tente novamente.
    </div>
  
    <button class="form-submit" @click="toggleNewTranfer">
      {{ newTranfer ? 'voltar' : 'Nova transação' }}
    </button>
 
    <button class="form-submit" @click="toggleTabela">
      {{ mostrarTabela ? 'Esconder Histórico' : 'Mostrar Histórico' }}
    </button>
    <table v-if="mostrarTabela">
      <thead>
        <tr>
          <th>Conta de Origem</th>
          <th>Conta de Destino</th>
          <th>Valor</th>
          <th>Taxa</th>
          <th>Data da Transferência</th>
          <th>Data de Agendamento</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(history, index) in historyList" :key="index">
          <td>{{ history.sourceAccount  }}</td>
          <td>{{ history.destinationAccount  }}</td>
          <td>{{ history.amount  }}</td>
          <td>{{ history.tax  }}</td>
          <td>{{ history.transferDate  }}</td>
          <td>{{ history.schedulingDate  }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'FinancialTransfer',
  props: {
    msg: String
  },
    data() {
    return {
      historyList: [],
      transfer: {
        contaOrigem: '',
        contaDestino: '',
        valor: null,
        dataTransferencia: ''
      },
      erroEnvio: false,
      mostrarTabela: false,
      newTranfer: false
    };
  },
  methods: {
        toggleNewTranfer() {
      this.newTranfer = !this.newTranfer;

    },
    agendarTransferencia() {
      this.erroEnvio = true; 
        setTimeout(() => {
          this.erroEnvio = false;
        }, 3000);
    },

    toggleTabela() {
      this.mostrarTabela = !this.mostrarTabela;
      if (this.mostrarTabela) {
        this.getTransferencias();
      }
    },
    async getTransferencias() {
      try {
        const response = await axios.get('http://localhost:8180/financial-transfer');
          this.historyList = response.data;
        return response.data;
      } catch (error) {
          console.error('Erro ao buscar transferências:', error);
        throw error;
      }
    }

  }
}
</script>


<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #dddddd;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f2f2f2;
}

.transfer-form {
  max-width: 400px;
  margin: 0 auto;
}

.form-group {
  margin-bottom: 20px;
}
.form-submit {
  margin-bottom: 30px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"],
input[type="number"],
input[type="date"] {
  width: 100%;
  padding: 8px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

.alert-danger {
  color: #721c24;
  background-color: #f8d7da;
  border-color: #f5c6cb;
  padding: .75rem 1.25rem;
  margin-bottom: 1rem;
  border: 1px solid transparent;
  border-radius: .25rem;
}
.container {
  display: flex;
}
</style>
