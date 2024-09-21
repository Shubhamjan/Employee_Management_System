import React, { useEffect, useState } from 'react'
import { deleteEmployee, listEmployees } from '../Services/EmployeeService'
import { useNavigate } from 'react-router-dom'
export default function ListOfEmployee() {

    const [emp, setEmp] = useState([])
    const navigator = useNavigate();
    useEffect(() => {
        getAllEmployees();

    }, [])

    function getAllEmployees() {
        listEmployees().then((r) => {
            setEmp(r.data);
        }).catch(error => {
            console.error(error);
        })
    }
    function removeEmployee(id) {
        console.log(id);

        deleteEmployee(id).then((response) => {
            getAllEmployees()
        }).catch((error) => {
            console.log(error);
        })
    }
    function newEmployee() {
        navigator('/add-employee')
    }

    function updateEmp(id) {
        navigator(`/updateEmployee/${id}`)
    }
    return (
        <div className='container'>
            <button className='bu head' onClick={newEmployee}>Add Employee</button>
            <h2 className='head'>List Of Employee</h2>
            <table className='table table-striped table'>
                <thead>
                    <tr>
                        <th>Employee Id</th>
                        <th>Employee First Name</th>
                        <th>Employee Last Name</th>
                        <th>Employee Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        emp.map(emp =>
                            <tr key={emp.id}>
                                <td>{emp.eid}</td>
                                <td>{emp.firstName}</td>
                                <td>{emp.lastName}</td>
                                <td>{emp.email}</td>
                                <td>
                                    <button class="btn btn-outline-warning" style={{marginRight:'10px'}} onClick={() => updateEmp(emp.eid)}>Update</button>
                                    <button className='btn btn-outline-danger' onClick={() => removeEmployee(emp.eid)}>Delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
}
