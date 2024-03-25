// LoginContext.js
import React, { createContext, useContext, useState } from 'react';

const LoginContext = createContext();

export const useLoginContext = () => useContext(LoginContext);

export const LoginProvider = ({ children }) => {
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const state = {
        loading,
        setLoading,
        error,
        setError
    };

    return (
        <LoginContext.Provider value={state}>
            {children}
        </LoginContext.Provider>
    );
};

// const RegisterContext = createContext();

// export const useRegisterContext = () => useContext(RegisterContext);

// export const RegisterProvider = ({ children }) => {
//     const [loading, setLoading] = useState(false);
//     const [error, setError] = useState(null);

//     const state = {
//         loading,
//         setLoading,
//         error,
//         setError
//     };

//     return (
//         <RegisterContext.Provider value={state}>
//             {children}
//         </RegisterContext.Provider>
//     );
// };

