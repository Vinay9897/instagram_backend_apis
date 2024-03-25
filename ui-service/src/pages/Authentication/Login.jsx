// import { TextField } from '@mui/material';
// import { ErrorMessage, Form, Formik } from 'formik';
// import { Field } from 'formik';
// import { useState } from 'react';
// import React from 'react';

// import { Button } from '@mui/material';


// const initialValues = { email: "", password: "" }

// export const Login = () => {
 
//     const handleSubmit = (values) => {
//         console.log("handle Submit",values);
//     };

//     return (
//         <>
//             <Formik onSubmit={handleSubmit} initialValues={initialValues}>
//                 <Form className='space-y-5'>

//                     <div className='space-y-5'>

//                         <div>
//                             <Field as={TextField}
//                                 name="email"
//                                 placeholder="Email"
//                                 type="email"
//                                 variant="outlined" fullWidth
//                             />
//                             <ErrorMessage name="email" component={"div"} className='text-red-500'></ErrorMessage>
//                         </div>

//                         <div>
//                             <Field as={TextField}
//                                 name="password"
//                                 placeholder="password"
//                                 type="password"
//                                 variant="outlined" fullWidth
//                             />
//                             <ErrorMessage name="password" component={"div"} className='text-red-500'></ErrorMessage>
//                         </div>

//                         <Button sx={{ padding: ".8rem 0rem" }}
//                             fullWidth
//                             type="submit"
//                             variant="contained"
//                             color="primary">Login</Button>

                            
//                     </div>

//                 </Form>
//             </Formik>
//         </>
//     )
// }
// ===================================================================


// import React, { createContext, useContext } from 'react';
// import { ErrorMessage, Field, Form, Formik } from 'formik';
// import { Button, TextField } from '@mui/material';

// // Create a context for managing login state
// const LoginContext = createContext();

// // Custom hook to use LoginContext
// export const useLoginContext = () => useContext(LoginContext);

// const initialValues = { email: "", password: "" };

// export const LoginProvider = ({ children }) => {
//     const handleSubmit = (values) => {
//         console.log("handle Submit", values);
//         // Add logic for handling login here, e.g., dispatch action, API call, etc.
//     };

//     const state = {
//         handleSubmit,
//     };

//     return (
//         <LoginContext.Provider value={state}>
//             {children}
//         </LoginContext.Provider>
//     );
// };

// export const Login = () => {
//     const { handleSubmit } = useLoginContext();

//     return (
//         <Formik onSubmit={handleSubmit} initialValues={initialValues}>
//             <Form className='space-y-5'>
//                 <div className='space-y-5'>
//                     <div>
//                         <Field as={TextField}
//                             name="email"
//                             placeholder="Email"
//                             type="email"
//                             variant="outlined" fullWidth
//                         />
//                         <ErrorMessage name="email" component={"div"} className='text-red-500'></ErrorMessage>
//                     </div>
//                     <div>
//                         <Field as={TextField}
//                             name="password"
//                             placeholder="Password"
//                             type="password"
//                             variant="outlined" fullWidth
//                         />
//                         <ErrorMessage name="password" component={"div"} className='text-red-500'></ErrorMessage>
//                     </div>
//                     <Button sx={{ padding: ".8rem 0rem" }}
//                         fullWidth
//                         type="submit"
//                         variant="contained"
//                         color="primary">Login</Button>
//                 </div>
//             </Form>
//         </Formik>
//     );
// };



// Login.js
import React from 'react';
import { ErrorMessage, Field, Form, Formik } from 'formik';
import { Button, TextField } from '@mui/material';
import axios from 'axios';
import { useLoginContext } from './LoginContext'; // Import the LoginContext

const initialValues = { email: "", password: "" };

const Login = () => {
    const { loading, setLoading, error, setError } = useLoginContext(); // Access context values

    const handleSubmit = async (values) => {
        setLoading(true); // Set loading state to true
        try {
            const response = await axios.post('http://localhost:8080/login', values);
            console.log("Login Successful", response.data);
            // Handle successful login
        } catch (error) {
            setError(error.response.data.message); // Set error message
        } finally {
            setLoading(false); // Set loading state back to false
        }
    };

    return (
        <Formik onSubmit={handleSubmit} initialValues={initialValues}>
            <Form className='space-y-5'>
                <div className='space-y-5'>
                    <div>
                        <Field as={TextField}
                            name="email"
                            placeholder="Email"
                            type="email"
                            variant="outlined" fullWidth
                        />
                        <ErrorMessage name="email" component={"div"} className='text-red-500'></ErrorMessage>
                    </div>
                    <div>
                        <Field as={TextField}
                            name="password"
                            placeholder="Password"
                            type="password"
                            variant="outlined" fullWidth
                        />
                        <ErrorMessage name="password" component={"div"} className='text-red-500'></ErrorMessage>
                    </div>
                    {error && <div className='text-red-500'>{error}</div>}
                    <Button sx={{ padding: ".8rem 0rem" }}
                        fullWidth
                        type="submit"
                        variant="contained"
                        color="primary"
                        disabled={loading}> {/* Disable button when loading */}
                        {loading ? 'Logging in...' : 'Login'}
                    </Button>
                </div>
            </Form>
        </Formik>
    );
};

export default Login;
