import '../styles/App.css'
import { useFetchPeliculas } from '../hooks/useFetchPeliculas'
// import { Link } from 'react-router-dom';
import { NavBar } from '../components/Navbar';

export const Inicio = () => {

    const { peliculas } = useFetchPeliculas ();

  return (
    <>
      <NavBar />
      <div className='titulo_principal'>
        <h3>INICIO</h3>
      </div>

      <div>
        <input className='input_buscar_pelicula' type="text" name="" id=""
        placeholder='Buscar pelicula por id' />
      </div>

      <div className='card-grid'>

              { peliculas.map(peli => { 
                return (
                <div className='card' key={peli.id_pelicula}>
                  <p>{peli.titulo}</p>
                  <p>{peli.nacionalidad}</p>
                  <p>{peli.productores}</p>
                  <p>{peli.fecha}</p>
                </div>
                      ) 
              } )  }
        
      </div>
    </>
  )
} 