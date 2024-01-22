
'use client';

import {Button, Checkbox, FileInput, Label, Select, Textarea, TextInput} from 'flowbite-react';
import {useEffect, useState} from "react";
import {fetchCategories, insertProduct} from "./service-api/ProducActionApiComponent";
import {Link} from "react-router-dom";

export default function InsertDataComponent () {
    const [product,setProduct] = useState({
        title: '',
        price: 0,
        description: '',
        category: '',
        image: 'https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png'

    });
    const [categories,setCategories] = useState([])

    const onChangeHandler = (e) =>{
        console.log(e.target.value)
        const {name,value} = e.target
        console.log(name)
        console.log(value)
        setProduct(prevstate=>{
            return{
                ...prevstate,
                [name] : value
            }
        })
        console.log(product && product)
    }
    const handleOnClick= ()=>{
        console.log("on submit")
        insertProduct(product).then(resp => console.log(resp))
            // .then(resp =>
            // {
            //     if (resp.status === 201){
            //         alert("Created")
            //     }
            // })
            // .then(resp =>setCategories(resp))
    }
    useEffect(()=>{
        fetchCategories()
            .then(resp=>setCategories(resp))
            .then(resp=>console.log(resp))
    },[])
    return (
        <div className={"h-screen flex items-center justify-center"}>
            <div className={"justify-center"}>
                <div>
                    <div className="mb-2 block">
                        <Label htmlFor="title"
                               className={"text-black"} value="title" />
                    </div>
                    <TextInput name="title" type="text"
                               placeholder={"mouse cat"}
                               onChange={onChangeHandler} sizing="sm" />
                </div>
                <div>
                    <div className="mb-2 block">
                        <Label htmlFor="price"
                               className={"text-black"} value="price" />
                    </div>
                    <TextInput name="price" type="text"
                               placeholder={"9090$"}
                               onChange={onChangeHandler} sizing="sm" />
                </div>
                {/*<div>*/}
                {/*    <div className="mb-2 block">*/}
                {/*        <Label htmlFor="category"*/}
                {/*               className={"text-black"} value="category" />*/}
                {/*    </div>*/}
                {/*    <TextInput name="category" type="text"*/}
                {/*               placeholder={"men's clothing"}*/}
                {/*               onChange={onChangeHandler} sizing="sm" />*/}
                {/*</div>*/}
                <div className="max-w-md">
                    <div className="mb-2 block">
                        <Label htmlFor="description"  className={"text-black"} value="description" />
                    </div>
                    <Textarea onChange={onChangeHandler} name="description" placeholder="Leave a description..." required rows={4} />
                </div>
                <div className="max-w-md">
                    <div className="mb-2 block">
                        <Label htmlFor="countries"  className={"text-black"} value="Select your rating" />
                    </div>
                    <Select onChange={onChangeHandler} name="category" required>
                        <option>rate</option>
                        {
                           categories && categories.map((cat =>(
                              <option className={"text-white"} value={cat.id}>{cat}</option>
                            )))
                        }
                    </Select>
                </div>
                <div id="fileUpload" className="max-w-md">
                    <div className="mb-2 block">
                        <Label htmlFor="file"  className={"text-black"} value="Upload image file" />
                    </div>
                    <FileInput id="file" helperText="A profile picture is useful to confirm your are logged into your account" />
                </div>
                <div className="flex items-center gap-2 text-black mb-3">
                    <Checkbox id="agree" />
                    <Label htmlFor="agree" className="flex">
                        I agree with the&nbsp;
                        <Link href="#" className="dark:text-black hover:underline ">
                            terms and conditions
                        </Link>
                    </Label>
                </div>
                <Button onClick={()=>handleOnClick()} type="button">Insert Data</Button>
            </div>

        </div>
    );
}



