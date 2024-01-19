import logo from './logo.svg';
import './App.css';
import CardComponentStructuring from "./component/CardComponentStructuring";
import React from "react";
import CardComponentDestructuring from "./component/CardComponentDestructuring";
import {products} from "./data-json-static/DataJson";
function App() {
  const data = products
    console.log(data)
    return (

    <>
        <div className={"flex mt-10 flex-wrap justify-center  "}>
            {
                // dynamic api
                products.map((product) => (
                        <CardComponentDestructuring
                            key={product.id}
                            imageURL={product.image}
                            description={product.description}
                            title={product.title}
                        />
                    )
                )
            }
            {/*//static data */}
            <CardComponentDestructuring
                description={"Speedily say has suitable disposal add boy. On forth doubt miles of child. Exercise joy man children rejoiced. Yet uncommonly his ten who diminution astonished."}
                title={"javaScript with me"}
                imageURL={"https://eduport.webestica.com/assets/images/courses/4by3/09.jpg"}/>
        </div>
    </>
  );
}

export default App;
