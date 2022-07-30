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
                        <button class="btn btn-outline-primary" @click="createShortUrl" type="button" id="button-addon2">Generate</button>
                      </div>
                </div>
              </div>
        </div>
        
        <div v-if="isUrlGenerated" class="row mt-3 shadow">
            <div class="card">
                <div class="card-body">
                  <div v-if="isUrlGenerated">
                        <h4>Short URL : </h4>
                    </div>
                  <div v-else>
                  <div class="alert alert-danger" role="alert">
                        Input url is not good
                      </div>
                  </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script>
import LinkShortService from '../services/LinkShortService'

export default{
  name: 'short-url',
  methods: {
        createShortUrl() {
          var data = {
            origUrl: this.origUrl,
          }
          LinkShortService.createShortUrl(data)
            .then(() => {
                this.isErrorGenerated = false;
            })
            .catch(() => {
                this.isErrorGenerated = true;
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
