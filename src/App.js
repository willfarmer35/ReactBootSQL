import { Route,Routes } from 'react-router-dom';
import './App.css';
import User from './components/user'
import AddJob from './components/addJob'

function App() {
  return (
    <div className="App">
        <Routes>
   
    <Route path ="/" element={<User/>} />
   
    <Route path ="/update/:id" element={<AddJob/>}/>

     </Routes>
    </div>
  );
}

export default App;
