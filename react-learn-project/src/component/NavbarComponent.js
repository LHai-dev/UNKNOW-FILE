
'use client';

import { Button, Navbar } from 'flowbite-react';
import {Link, useNavigate} from "react-router-dom";

function NavbarComponent() {
    const navigate = useNavigate()
    return (
        <Navbar className={"bg-white"}  rounded>
            <Navbar.Brand href="/">
                <span className="self-center whitespace-nowrap mr-3 text-xl font-semibold text-white">Dev-Cam</span>
                <img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F0768a380-ff8f-4b2a-8454-a29d71d8e6c9%2Flogo.png?table=block&id=067dd719-a912-471e-a9a3-ac10710e7fdf&cache=v2" className="mr-3 h-6 sm:h-9" alt="Dev-Kh Logo" />
                <h2 className={"text-black mr-2" }>X</h2>
                <img src="/master-01.png" className="mr-3 h-6 sm:h-9" alt="Dev-Kh Logo" />

            </Navbar.Brand>
            <div className="flex md:order-2 ">
                    <Button onClick={()=> navigate("/insert-data")}>Insert Book</Button>
                <Navbar.Toggle />
            </div>
            <Navbar.Collapse >
                <Navbar.Link href="/" active>
                    <div className={"text-black"}>Home</div>
                </Navbar.Link>
                <Navbar.Link href="/kafka">Kafka</Navbar.Link>
                <Navbar.Link href="/microservice">Microservice</Navbar.Link>
                <Navbar.Link href="/spring-boot">Spring Boot</Navbar.Link>
            </Navbar.Collapse>
        </Navbar>
    );
}
export default NavbarComponent