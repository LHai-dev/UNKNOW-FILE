export const  fetchCategories = async ()=>{
    let resp = await fetch(`https://fakestoreapi.com/products/categories`,{
        method: "GET"
    })
    return resp.json()
}

export const insertProduct = async  (product)=>{
    let resp = await fetch('https://fakestoreapi.com/products/',{
        method: "POST",
        headers:    {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(product)
    })
    return resp.json()
}