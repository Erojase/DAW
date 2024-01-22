<script lang="ts">
export default {
  name: 'HelloWorld',
  props: {
    msg: String,
    mensaje: String,
    logo: String,
    add: ()=>Number,
  },
  data() {
    let jamon = 0;
    return {
      jamon,
      Myadd: this.add
    }
  },
  methods: {
    add() {
      this.$emit('add')
      console.log(this.add);
      if (this.Myadd != undefined) {
        this.jamon = this.Myadd();
      }
    }
  }
}
let jamon = 0;
</script>

<template>
  <div class="hello">
    <img alt="Vue logo" src="@/assets/logo.svg">
    <h1>{{ mensaje }}</h1>
    <button @click="add">Contador: {{jamon}}</button>

  </div>
</template>



<!-- Add "scoped" attribute to limit CSS to this component only -->
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
</style>
