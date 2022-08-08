<template>
  <div class="home">
    <CreateShortUrl></CreateShortUrl>
  </div>
</template>

<script>
import CreateShortUrl from '@/components/CreateShortUrl.vue'

export default {
  name: 'HomeView',
  components: {
    CreateShortUrl
  }
}
</script>
