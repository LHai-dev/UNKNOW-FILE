
'use client';

import { Card } from 'flowbite-react';

export default function CardComponentStructuring(props) {
    return (
        <Card
            className="  max-w-sm mr-6  w-[300px]  "
            imgAlt="Meaningful alt text for an image that is not purely decorative"
            imgSrc={props.imageURL}
        >
            <h5 className="text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
                {props.title}
            </h5>
            <p className="font-normal text-gray-700 dark:text-gray-400">
                {props.description}
            </p>
        </Card>
    );
}
