
'use client';

import { Card } from 'flowbite-react';

export default function CardComponentDestructuring({imageURL,title,description}) {
    // destructuring object
    // const {imageURL,title,description} = props
    return (
        <Card
            className=" ml-3 mt-3  max-w-sm w-[300px] "
            imgAlt="Meaningful alt text for an image that is not purely decorative"
            imgSrc={imageURL}
        >
            <h5 className="text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
                {title}
            </h5>
            <p className="font-normal text-gray-700 dark:text-gray-400">
                {description}
            </p>
        </Card>
    );
}
