import http from '../http-common.js'

class LinkShortService {
    getOrigUrl(shortUrl) {
        return http.get(`/${shortUrl}`)
    }

    createShortUrl(origUrl) {
        return http.post('/', origUrl)
    }
}
export default new LinkShortService()