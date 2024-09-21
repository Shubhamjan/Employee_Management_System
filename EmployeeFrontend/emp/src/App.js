import logo from './logo.svg';
import './App.css';
import Hello from './Hello';
import ListOfEmployee from './Component/ListOfEmployee';
import Header from './Component/Header';
import Footer from './Component/Footer';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import EmployeeComponent from './Component/EmployeeComponent';
function App() {
  return (
    <div>
      <BrowserRouter>
        <Header></Header>
        <div className='container'>
        <Routes>
          <Route path='/'element={<ListOfEmployee/>}> </Route>
          <Route path='add-employee'element={<EmployeeComponent/>}> </Route>
          <Route path='/updateEmployee/:id' element={<EmployeeComponent/>}></Route>
        </Routes>
        </div>
       
       
        <Footer></Footer>
      </BrowserRouter>
      </div>


  );
}

export default App;
