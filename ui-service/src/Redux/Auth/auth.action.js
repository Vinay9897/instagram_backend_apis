import { API_BASE_URL } from "../../config/api";
import { LOGIN_FAILURE, LOGIN_REQUEST, LOGIN_SUCCESS, REGISTER_FAILURE, REGISTER_REQUEST, REGISTER_SUCCESS } from "./auth.actionType";
import axios  from "axios";

export const loginUserAction = (loginData) => async(dispatch) =>{
    dispatch({type:LOGIN_REQUEST})
    try {
        console.log("inside login");
        const {data} = await axios.post(`${API_BASE_URL}/login`,loginData.data)
        
        if(data.jwt)
        {
            localStorage.setItem("jwt",data.jwt)
        }
        console.log("Login : ", data)
        dispatch({type:LOGIN_SUCCESS, payload:data.jwt})
    } catch (error) {

        console.log("--------",error)
        dispatch({type:LOGIN_FAILURE, payload:error})
        
    }
}

export const registerUserAction = (loginData) => async(dispatch) =>{
    dispatch({type:REGISTER_REQUEST})
    try {
        console.log("inside register");
        const {data} = await axios.post(`${API_BASE_URL}/registration`,loginData.data)
        
        if(data.jwt)
        {

            localStorage.setItem("jwt",data.jwt)
        }
        console.log("Register : ", data)
        dispatch({type:REGISTER_SUCCESS, payload:data.jwt})
    } catch (error) {

        console.log("--------",error)
        dispatch({type:REGISTER_FAILURE, payload:error})
        
    }
}