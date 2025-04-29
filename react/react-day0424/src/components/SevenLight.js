import React from 'react';

const SevenLight = ({room,on,toggle}) => {
    console.log(room,on);

    return (
        <div>
            <button onClick={toggle}>
                 {room} {on ? "💡" : "⬛"}
            </button>

        </div>
    );
};

export default React.memo(SevenLight);