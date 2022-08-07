<template>
  <div class="container">
        <div class="row">
          <h4 class="text-center text-primary m-3"> Short URL</h4>
        </div>
    
        <div class="row shadow mt-3">
            <div class="card">
                <div class="card-body">
                    <div class="input-group mb-1 mt-1">
                        <input type="text" v-model="origUrl" class="form-control" placeholder="Enter original url">
                    </div>
                    <div class="input-group mb-1 mt-1">
                        <input type="text" v-model="shortUrlField" class="form-control" placeholder="Enter short url (only if a specific url needed)">
                    </div>
                    <div class="d-grid gap-2">
                        <button type="button" class="btn btn-outline-primary" @click="createShortUrl()" id="button-addon2">Generate</button>
                    </div>
                </div>
              </div>
        </div>
        
        <div class="row mt-3 shadow">
          <div class="card">
            <div class="card-body">
              <div v-show="isUrlGoodGenerated">
                <h4>Short URL : <a v-bind:href="'http://localhost:8080/' + shortUrl">http://localhost:8080/{{shortUrl}}</a></h4>
              </div>
              <div v-show="isUrlErrGenerated">
                <div class="alert alert-danger" role="alert">
                    {{errorMessage}}
                </div>
              </div>
            </div>
          </div>
        </div>
    </div>
</template>


<script>
import axios from 'axios';

export default{
  name: 'short-url',
  data() {
    return {
      isUrlGoodGenerated: false,
      isUrlErrGenerated: false,
      shortUrl: "",
      errorMessage: "Input url is not good",
      errors: []
    }
  },
  methods: {
    createShortUrl() {      
      axios.post('http://localhost:8080/', {
        origUrl: this.origUrl,
        shortUrl: this.shortUrlField
      })
      .then(response => {
        if (response.data == null || response.data == ""){
          this.isUrlErrGenerated = true;
          this.isUrlGoodGenerated = false;
        } else {
          this.isUrlGoodGenerated = true;
          this.isUrlErrGenerated = false;
          this.shortUrl = response.data;
        }
      })
      .catch(e => {
        this.isUrlGoodGenerated = false;
        this.isUrlErrGenerated = true;
        this.errors.push(e)
      })
    },
  }  
}
</script>


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