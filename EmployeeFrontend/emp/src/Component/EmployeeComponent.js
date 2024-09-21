import React, { useState } from 'react'
import { createEmp } from '../Services/EmployeeService'
// import { createEmployee } from '../Services/EmployeeService'
import { useNavigate, useParams } from 'react-router-dom'
import { updateEmp } from '../Services/EmployeeService'
import { getEmployee } from '../Services/EmployeeService'
import { useEffect } from 'react'

export default function EmployeeComponent() {

  const [firstName, setFirstName] = useState('')
  const [lastName, setLastName] = useState('')
  const [email, setEmail] = useState('')

  const [error, setError] = useState({
    firstName: "",
    lastName: "",
    email: ""
  })
  const { id } = useParams();
  const navigator = useNavigate()
  function handleFirstName(e) {
    setFirstName(e.target.value)
  }

  useEffect(()=>{
    if(id){
      getEmployee(id).then((response)=>{
        setFirstName(response.data.firstName);
        setLastName(response.data.lastName);
        setEmail(response.data.email);
      }).catch(error=>{
        console.log(error);
      })
    }
  },[id])



  function handleLastName(e) {
    setLastName(e.target.value)
  }

  function handleEmail(e) {
    setEmail(e.target.value)
  }

  function saveOrUpdateEmployee(e) {
    e.preventDefault();
    if (validateForm()) {
      const employee = { firstName, lastName, email }
      console.log(employee)

      if (id) {
        updateEmp(id, employee).then((response) => {
          console.log(response.data)
          navigator('/')
        }).catch(error => {
          console.error(error);
        })
      } else {
        createEmp(employee).then((response) => {
          navigator('/')
          console.log(response.data)
        }).catch(error=>{
          console.error(error)
        })
      }




    }

  }


  function validateForm() {
    let valid = true;
    const errorsCopy = { ...error }
    if (firstName.trim()) {
      errorsCopy.firstName = ''
    } else {
      errorsCopy.firstName = 'first name is required'
      valid = false
    }


    if (lastName.trim()) {
      errorsCopy.lastName = ''
    } else {
      errorsCopy.lastName = 'last name is required'
      valid = false
    }

    if (email.trim()) {
      errorsCopy.email = ''
    } else {
      errorsCopy.email = 'email is required'
      valid = false
    }

    setError(errorsCopy)
    return valid
  }
  function pageTitle() {
    if (id) {
      return <h2 className='text-center '>Update Employee</h2>
    } else {
      return <h2 className='text-center '>Add Employee</h2>
    }
  }
  return (
    <div className='container'>
      <br></br>
      <div className='row'>
        <div className='card col-md-6 offset-md-3 '>
          {/* <h2 className='text-center '>Add Employee</h2> */}
          {
            pageTitle()
          }
          <div className='card-body'>
            <form>
              <div className='form-group' mb-2>
                <label className='from-label'>First Name:</label>
                <input type='text'
                  placeholder='Enter name'
                  name='firstname'
                  value={firstName}
                  className={`form-control ${error.firstName ? 'is-invalid' : ''}`}
                  onChange={handleFirstName}
                ></input>
                {error.firstName && <div className='invalid-feedback'>{error.firstName}</div>}
              </div>

              <div className='form-group' mb-2>
                <label className='from-label'>Last Name:</label>
                <input type='text'
                  placeholder='Enter name'
                  name='lastname'
                  value={lastName}
                  className={`form-control ${error.lastName ? 'is-invalid' : ''}`}
                  onChange={handleLastName}
                ></input>
                {error.lastName && <div className='invalid-feedback'>{error.lastName}</div>}
              </div>

              <div className='form-group' mb-2>
                <label className='from-label'>Email</label>
                <input type='text'
                  placeholder='Enter email'
                  name='email'
                  value={email}
                  className={`form-control ${error.email ? 'is-invalid' : ''}`}
                  onChange={handleEmail}
                ></input>
                {error.email && <div className='invalid-feedback'>{error.email}</div>}
              </div>
              <br></br>
              <button className='btn btn-outline-primary' onClick={saveOrUpdateEmployee}>submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}
