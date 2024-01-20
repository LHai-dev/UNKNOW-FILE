import logo from './logo.svg';
import './App.css';
import CardComponentStructuring from "./component/CardComponentStructuring";
import React from "react";
import CardComponentDestructuring from "./component/CardComponentDestructuring";
import {products} from "./component/data-json-static/DataJson";
import Home from "./component/react-hook/Home";
import {Route, Routes} from "react-router-dom";
import KafkaComponent from "./component/KafkaComponent";
import MicroserviceComponent from "./component/MicroserviceComponent";
import SpringBooTComponent from "./component/SpringBooTComponent";
function App() {
  const data = products
    console.log(data)
    return (

    <>

      <Routes>
        <Route path={'/'} element={<Home/>}/>
        <Route path={'/kafka'} element={<KafkaComponent/>}/>
        <Route path={'/microservice'} element={<MicroserviceComponent/>}/>
        <Route path={'/spring-boot'} element={<SpringBooTComponent/>}/>
        <Route />
      </Routes>

        {/*<div className={"flex mt-10 flex-wrap justify-center  "}>*/}
            {/*{*/}
            {/*    // dynamic api*/}
            {/*    products.map((product) => (*/}
            {/*            <CardComponentDestructuring*/}
            {/*                key={product.id}*/}
            {/*                imageURL={product.image}*/}
            {/*                description={product.description}*/}
            {/*                title={product.title}*/}
            {/*            />*/}
            {/*        )*/}
            {/*    )*/}
            {/*}*/}
            {/*//static data */}
        {/*    <CardComponentDestructuring*/}
        {/*        description={"Speedily say has suitable disposal add boy. On forth doubt miles of child. Exercise joy man children rejoiced. Yet uncommonly his ten who diminution astonished."}*/}
        {/*        title={"javaScript with me"}*/}
        {/*        imageURL={"https://eduport.webestica.com/assets/images/courses/4by3/09.jpg"}/>*/}
        {/*</div>*/}

        {/*<Home/>?*/}
    </>
  );
}

export default App;
