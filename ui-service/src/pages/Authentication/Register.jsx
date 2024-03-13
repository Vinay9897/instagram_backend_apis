import { FormControlLabel, Radio, RadioGroup, TextField } from '@mui/material';
import { ErrorMessage,Field, Form, Formik } from 'formik';
import { useState } from 'react';
import React from 'react';
import * as Yup from 'yup';
import { Button } from '@mui/material';
import { loginUserAction, registerUserAction } from '../../Redux/Auth/auth.action';
import { useDispatch } from 'react-redux';

const initialValues = { firstName: "", lastName: "", email: "", password: "", gender: "" }
const validationSchema = {
    email: Yup.string().email("Invalid email").required("Email is Required"),
    password: Yup.string().min(6, "Password must be at least 6 characters").required("Password is Required")
}
const Register = () => {
    const [gender, setGender] = useState('');
    const dispatch = useDispatch()
    const handleSubmit = (values) => {
        values.gender = gender
        console.log("handle Submit",values); 
        dispatch(registerUserAction({data:values}))
    };

    const handleChange = (event) => {
        setGender(event.target.value);
        
    };
    return (
        <>
            <
                Formik
                onSubmit={handleSubmit}
                initialValues={initialValues}
            >
                <Form className='space-y-5'>

                    <div className='space-y-5'>
                        <div>
                            <Field as={TextField}
                                name="firstName"
                                placeholder="firstName"
                                type="text"
                                variant="outlined" fullWidth
                            />
                            <ErrorMessage name="firstName" component={"div"} className='text-red-500'></ErrorMessage>
                        </div>
                        <div>
                            <Field as={TextField}
                                name="lastName"
                                placeholder="lastName"
                                type="text"
                                variant="outlined" fullWidth
                            />
                            <ErrorMessage name="lastName" component={"div"} className='text-red-500'></ErrorMessage>
                        </div>

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
                                placeholder="password"
                                type="password"
                                variant="outlined" fullWidth
                            />
                            <ErrorMessage name="password" component={"div"} className='text-red-500'></ErrorMessage>
                        </div>

                        <div>
                            <RadioGroup
                                row
                                aria-labelledby="gender"
                                name="gender"
                                //values={value}
                                onChange={handleChange}
                            >
                                <FormControlLabel value="female" control={<Radio />} label="Female" />
                                <FormControlLabel value="male" control={<Radio />} label="Male" />
                                <FormControlLabel value="other" control={<Radio />} label="Other" disabled />
                                <ErrorMessage name="gender" component={"div"} className='text-red-500'></ErrorMessage>
                            </RadioGroup>
                        </div>
                        <Button sx={{ padding: ".8rem 0rem" }}
                            fullWidth
                            type="submit"
                            variant="contained"
                            color="primary">Register</Button>
                    </div>
                    
                </Form>
            </Formik>
        </>
    )
}

export default Register;