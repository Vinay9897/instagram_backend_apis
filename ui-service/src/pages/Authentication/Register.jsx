// import { FormControlLabel, Radio, RadioGroup, TextField } from '@mui/material';
// import { ErrorMessage, Field, Form, Formik } from 'formik';

// import { Button } from '@mui/material';
// import { useRegisterContext } from './RegisterContext';
import axios from 'axios';

// const Register = () => {
//     const { formData, handleChange, setLoading, setError } = useRegisterContext();

//     const handleSubmit = async (values) => {
//         console.log("handle Submit", values);
//         setLoading(true); 
//         try {
//             const response = await axios.post('http://localhost:8080/registration', values);
//             console.log("Registration ccessful", response.data);
//         } catch (error) {
//             setError(error.response.data.message);
//         } finally {
//             setLoading(false);
//         }
//     };

//     return (
//         <>
//             <Formik onSubmit={handleSubmit} initialValues={formData}>

//                 <Form className='space-y-5'>

//                     <div className='space-y-5'>
//                         <div>
//                             <Field as={TextField}
//                                 name="firstName"
//                                 placeholder="firstName"
//                                 type="text"
//                                 variant="outlined" fullWidth
//                             />
//                             <ErrorMessage name="firstName" component={"div"} className='text-red-500'></ErrorMessage>
//                         </div>

//                         <div>
//                             <Field as={TextField}
//                                 name="lastName"
//                                 placeholder="lastName"
//                                 type="text"
//                                 variant="outlined" fullWidth
//                             />
//                             <ErrorMessage name="lastName" component={"div"} className='text-red-500'></ErrorMessage>
//                         </div>

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

//                         <div>
//                             <RadioGroup
//                                 row
//                                 aria-labelledby="gender"
//                                 name="gender"
//                                 value={formData.gender}
//                                 onChange={handleChange}
//                             >
//                                 <FormControlLabel value="female" control={<Radio />} label="Female" />
//                                 <FormControlLabel value="male" control={<Radio />} label="Male" />
//                                 <FormControlLabel value="other" control={<Radio />} label="Other" disabled />
//                             </RadioGroup>
//                         </div>
//                         <Button sx={{ padding: ".8rem 0rem" }}
//                             fullWidth
//                             type="submit"
//                             variant="contained"
//                             color="primary">Register</Button>
//                     </div>

//                 </Form>
//             </Formik>
//         </>
//     )
// }

// export default Register

import React, { useState } from 'react';
import { Button, FormControlLabel, Radio, RadioGroup, TextField } from '@mui/material';
import { useRegisterContext } from './RegisterContext';

const Register = () => {
    const { formData, handleChange } = useRegisterContext();
    const [error, setError] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        // Perform form validation
        if (validateForm()) {
            console.log("Form submitted:", formData);
            // You can now send the form data to the server for registration
        }
    };

    const validateForm = () => {
        // Perform form validation here
        if (formData.firstName === "" || formData.lastName === "" || formData.email === "" || formData.password === "" || formData.gender === "") {
            setError("All fields are required");
            return false;
        }
        setError("");
        return true;
    };

    return (
        <form onSubmit={handleSubmit} className='space-y-5'>
            <div className='space-y-5'>
                <div>
                    <TextField
                        name="firstName"
                        value={formData.firstName}
                        onChange={handleChange}
                        placeholder="First Name"
                        type="text"
                        variant="outlined"
                        fullWidth
                    />
                </div>

                <div>
                    <TextField
                        name="lastName"
                        value={formData.lastName}
                        onChange={handleChange}
                        placeholder="Last Name"
                        type="text"
                        variant="outlined"
                        fullWidth
                    />
                    {/* <ErrorMessage name="lastName" component={"div"} className='text-red-500' /> */}
                </div>

                <div>
                    <TextField
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        placeholder="Email"
                        type="email"
                        variant="outlined"
                        fullWidth
                    />
                    {/* <ErrorMessage name="email" component={"div"} className='text-red-500' /> */}
                </div>

                <div>
                    <TextField
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        placeholder="Password"
                        type="password"
                        variant="outlined"
                        fullWidth
                    />
                    {/* <ErrorMessage name="password" component={"div"} className='text-red-500' /> */}
                </div>

                <div>
                    <RadioGroup
                        row
                        aria-labelledby="gender"
                        name="gender"
                        value={formData.gender}
                        onChange={handleChange}
                    >
                        <FormControlLabel value="female" control={<Radio />} label="Female" />
                        <FormControlLabel value="male" control={<Radio />} label="Male" />
                        <FormControlLabel value="other" control={<Radio />} label="Other" disabled />
                    </RadioGroup>
                    {error && <div className='text-red-500'>{error}</div>}
                </div>

                <Button
                    sx={{ padding: ".8rem 0rem" }}
                    fullWidth
                    type="submit"
                    variant="contained"
                    color="primary"
                >
                    Register
                </Button>
            </div>
        </form>
    );
};

export default Register;

