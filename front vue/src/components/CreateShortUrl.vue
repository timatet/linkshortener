<template>
  <div class="container">
        <div class="row">
          <h4 class="text-center text-primary m-3"> Short URL</h4>
        </div>
    
        <div class="row shadow mt-3">
            <div class="card">
                <div class="card-body">
                    <div class="input-group mb-1 mt-1">
                        <input type="text" v-model="origUrl" class="form-control" placeholder="Enter url" aria-label="Recipient's username" aria-describedby="button-addon2">
                        <button class="btn btn-outline-primary" @click="createShortUrl()" type="button" id="button-addon2">Generate</button>
                      </div>
                </div>
              </div>
        </div>
        
        <div class="row mt-3 shadow">
          <div class="card">
            <div class="card-body">
              <div>
                <h4>Short URL : {{shortUrl}}</h4>
              </div>
              <div v-if="isUrlErrGenerated">
                <div class="alert alert-danger" role="alert">
                    Input url is not good
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
      errors: []
    }
  },
  methods: {
    createShortUrl() {
      var self = this;
      alert(self.origUrl)
      axios.post('http://localhost:8080/', self.origUrl)
      .then(response => {
        alert(response.data)
      })
      .catch(e => {
        alert(e)
        self.errors.push(e)
      })
    }
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
