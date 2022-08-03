import http from './http-common.js'

class LinkShortService {
    
    getOrigUrl(shortUrl) {
        return http.get(`/${shortUrl}`)
    }

    createShortUrl(origUrl) {
        const options = {
            headers: {
                'Content-Type': 'application/json',
            }
          };

        return http.post('/', origUrl, options)
    }
}
export default new LinkShortService()