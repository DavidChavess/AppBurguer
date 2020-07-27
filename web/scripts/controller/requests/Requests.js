class Requests{
    static get(url){
        return fetch(url, {
            method: 'GET',
            headers: {"Content-Type":"Application/json"}
        })
        .then((response) => {
            return response.json()
        })
    }
}