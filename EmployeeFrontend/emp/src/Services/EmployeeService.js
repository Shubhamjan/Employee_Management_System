import axios from "axios";

const REST_API_BASE_URL="http://localhost:8080/employee";


export const listEmployees=()=>{
    return axios.get(REST_API_BASE_URL+"/get");
}

export const createEmp=(e)=>{
    return axios.post(REST_API_BASE_URL+"/create",e);
}

export const updateEmp=(e,employee)=>{
    return axios.put(REST_API_BASE_URL+"/"+e,employee);
}

export const getEmployee=(employeeId)=>axios.get(REST_API_BASE_URL+"/get/"+employeeId)

export const deleteEmployee=(employeeId)=>axios.delete(REST_API_BASE_URL+"/delete/"+employeeId);