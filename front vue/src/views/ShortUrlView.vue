<template>
  <div class="home">
    <h4 class="text-center text-primary m-3">{{message}}</h4>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'ShortUrlView',
    data() {
        return {
            message: this.$route.params.shortUrl,
            errors: [],
        }
    },
    methods:{
        redirectTo: function() {
            axios.get('http://' + this.$root.hostip + ':' + this.$root.srvport + '/' + this.$route.params.shortUrl)
            .then(response => {
                var respData = JSON.parse(JSON.stringify(response.data));

                if (respData.message == "" || respData.message == "null"){
                    this.message = "Url http://" + this.$root.hostip + ":" + this.$root.webport + "/" + this.$route.params.shortUrl + " not exist!";
                    return;
                }

                window.location.href = respData.message;
            })
            .catch(e => {
                this.errors.push(e);
            })
            
        }
    },
    beforeMount(){
        this.redirectTo()
    },
}
</script>