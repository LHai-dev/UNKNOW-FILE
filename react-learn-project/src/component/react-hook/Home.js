import {useState} from "react";
import CardComponentDestructuring from "../CardComponentDestructuring";
import {Link} from "react-router-dom";

export default function Home() {
    const [count, setCount] = useState(0)
    const [products, setProducts] = useState([])
    if (count === -1) {
        console.log("error")
    }
    const fetchProducts = () => {
        fetch("https://fakestoreapi.com/products?limit=9")
            .then(res => res.json())
            .then(resp => setProducts(resp))
    }
    useState(() => {
        //call to api
        fetchProducts()
    }, [])
    return (
        <>
            <div>
                <h1>You have click {count} time</h1>
                {/*<h1>{JSON.stringify(products)}</h1>*/}
                <button onClick={() => setCount(count + 1)}>Click Me</button>
                <button onClick={() => setCount(count - 1)}>Click Me</button>
            </div>
            <div className={"row g-4"}>
                {
                    products.map((product) => (
                        <div
                            key={product.id}
                            className={" col-12 col-sm-6 col-md-4 col-lg-3"}>
                            <Link to={`/detail/${product.id}`}
                            className={'text-decoration-none'}
                            >
                                <CardComponentDestructuring
                                    imageURL={product.image}
                                    description={product.description}
                                    title={product.title}
                                    rating={product.rating.rate}
                                />
                            </Link>

                        </div>


                    ))
                }
            </div>


        </>
    )
}
