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

    static post(url, obj){
        return fetch(url, {
            method: 'POST',
            body: JSON.stringify(obj),
            headers: {"Content-Type":"Application/json"}
        })
        .then((response) => {
            if(response.status === 201){
                return response;
            }
        })
    }    
}