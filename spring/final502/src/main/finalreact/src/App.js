import mainimg from './mainimage.png';
import './App.css';
import error from './error.png';

function App() {
  return (
    <div className="App">
      <img alyt='' src={mainimg} 
      style={{width:'400px'}}/>
      <br/><br/>
      <img alyt='' src={error} 
      style={{width:'400px'}}/>

      <h2><b>React+SpringBoot 자동배포실습!!!</b></h2>
    </div>
  );
}

export default App;
