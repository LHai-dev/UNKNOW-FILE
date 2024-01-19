
'use client';

import { Button, Navbar } from 'flowbite-react';

function NavbarComponent() {
    return (
        <Navbar className={"bg-white"}  rounded>
            <Navbar.Brand href="https://flowbite-react.com">
                <span className="self-center whitespace-nowrap mr-3 text-xl font-semibold text-white">Dev-Cam</span>
                <img src="https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F0768a380-ff8f-4b2a-8454-a29d71d8e6c9%2Flogo.png?table=block&id=067dd719-a912-471e-a9a3-ac10710e7fdf&cache=v2" className="mr-3 h-6 sm:h-9" alt="Dev-Kh Logo" />
                <h2 className={"text-white mr-2" }>X</h2>
                <img src="/master-01.png" className="mr-3 h-6 sm:h-9" alt="Dev-Kh Logo" />

            </Navbar.Brand>
            <div className="flex md:order-2 ">
                {/*<Button>Get started</Button>*/}
                <Navbar.Toggle />
            </div>
            <Navbar.Collapse >
                <Navbar.Link href="#" active>
                    Home
                </Navbar.Link>
                <Navbar.Link href="#">Kafka</Navbar.Link>
                <Navbar.Link href="#">Microservice</Navbar.Link>
                <Navbar.Link href="#">Spring Boot</Navbar.Link>
            </Navbar.Collapse>
        </Navbar>
    );
}
export default NavbarComponent