import { TextField } from '@mui/material';
import { ErrorMessage, Form, Formik } from 'formik';
import { Field } from 'formik';
import { useState } from 'react';
import React from 'react';
import * as Yup from 'yup';
import { Button } from '@mui/material';
import { loginUserAction } from '../../Redux/Auth/auth.action';
import { useDispatch } from 'react-redux'

const initialValues = { email: "", password: "" }
const validationSchema = {
    email: Yup.string().email("Invalid email").required("Email is Required"),
    password: Yup.string().min(6, "Password must be at least 6 characters").required("Password is Required")
}
export const Login = () => {
    const [formValue, setFormValue] = useState(initialValues);
    const dispatch = useDispatch() 

    const handleSubmit = (formValue) => {
        console.log("handle Submit",formValue);
        dispatch(loginUserAction({data:formValue}))
    }
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

                        <Button sx={{ padding: ".8rem 0rem" }}
                            fullWidth
                            type="submit"
                            variant="contained"
                            color="primary">Login</Button>

                            
                    </div>

                </Form>
            </Formik>
        </>
    )
}

// export default Login;