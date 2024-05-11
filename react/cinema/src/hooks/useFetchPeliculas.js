import { useState, useEffect } from "react"
    
export const useFetchPeliculas = () => {

    const [peliculas, setPeliculas] = useState([])

    const fetchPeliculas = async () => {
        const token = localStorage.getItem('token');
        const response = await fetch("http://localhost:8080/api/pelicula/all", {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });
        if(!response.ok){ throw new Error("No se pudieron recolectar las peliculas!!");   }
        else { 
          const json = await response.json();
        //   console.log( json );
          setPeliculas( json ); 
        }  
    }

    useEffect(() =>{

      fetchPeliculas();

    }, [])


    return {
        peliculas
    };
            
}    
