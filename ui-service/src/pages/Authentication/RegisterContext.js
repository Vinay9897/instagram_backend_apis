import React, { createContext, useContext, useState } from 'react';

const RegisterContext = createContext();

export const useRegisterContext = () => useContext(RegisterContext);

export const RegisterProvider = ({ children }) => {
    const [formData, setFormData] = useState({
        firstName: "",
        lastName: "",
        email: "",
        password: "",
        gender: ""
    });

    const handleChange = (event) => {
        console.log(event.target.value);
        setFormData({
            ...formData,
            [event.target.name]:event.target.value
        })
    };

    const state = {
        formData,
        handleChange,
    };

    return (
        <RegisterContext.Provider value={state}>
            {children}
        </RegisterContext.Provider>
    );
};


