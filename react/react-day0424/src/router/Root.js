import React from 'react';
import RouterMain from './RouterMain';
import { BrowserRouter } from 'react-router-dom';

const Root = () => {
    return (
        <BrowserRouter>
            <RouterMain/>
        </BrowserRouter>
    );
};

export default Root;