
'use client';

import { Card } from 'flowbite-react';

export default function CardComponentDestructuring({imageURL,title,description,rating}) {
    // destructuring object
    // const {imageURL,title,description} = props
    return (
        <Card
            className=" ml-3 mt-3  max-w-sm w-[300px] "
            imgAlt="Meaningful alt text for an image that is not purely decorative"
            imgSrc={imageURL}
        >
            <h5 className="text-2xl font-bold tracking-tight text-gray-900 dark:text-black">
                {title ? title :"No"}
            </h5>
            <p className="font-normal text-gray-700 dark:text-gray-400 truncate">
                {description ? description :"No"}
            </p> <p className="font-normal text-gray-700 ">
                {rating}
            </p>
        </Card>
    );
}
