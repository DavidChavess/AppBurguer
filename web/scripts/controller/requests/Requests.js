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
                return response.json();
            }
            return response;
        })
    }

    static put(url, id, obj){
        return fetch(url + `/${id}`, {
            method: 'PUT',
            body: JSON.stringify(obj),
            headers: {"Content-Type":"Application/json"}
        })
        .then((response) => {
            return response.json();
        })
    }
    
    static delete(url, id){
        return fetch(url + `/${id}`, {
            method: 'DELETE',
            headers: {"Content-Type":"Application/json"}
        })
        .then((response) => {
            if(response.status === 400) return response.json()
            return response;
        })
    }
    
}