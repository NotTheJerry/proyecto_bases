import { useState } from 'react';
import { NavBar } from "../components/Navbar"
import '../styles/guardar_pelicula.css'

export const GuardarPelicula = () => {
    // Estado local para almacenar los valores de los campos del formulario
    const [pelicula, setPelicula] = useState({
        titulo: '',
        nacionalidad: '',
        productores: '',
        fecha: ''
    });

    const [actor, setActor] = useState({
        nombre: '',
        nacionalidad: '',
        correo: '',
        telefono: '',
        sexo: 'H' 
    });

    const [ejemplares, setEjemplares] = useState({
        cantidad: '',
        estado: 'Bueno'
    });

    const [director, setDirector] = useState({
        nombre: '',
        nacionalidad: '',
        correo: ''
    });

    const [clienteSocio, setClienteSocio] = useState({
        fechaComienzo: '',
        fechaDevolucion: '',
        direccion: '',
        telefono: '',
        sociosPresentados: ''
    });

    const [empresa, setEmpresa] = useState({
        nombre: '',
        direccion: '',
        correo: '',
        telefono: ''
    });

    const handlePeliculaChange = (e) => {
        setActor({
            ...pelicula,
            [e.target.name]: e.target.value
        });
    };

    const handleActorChange = (e) => {
        setActor({
            ...actor,
            [e.target.name]: e.target.value
        });
    };

    const handleEjemplaresChange = (e) => {
        setEjemplares({
            ...ejemplares,
            [e.target.name]: e.target.value
        });
    };

    const handleDirectorChange = (e) => {
        setDirector({
            ...director,
            [e.target.name]: e.target.value
        });
    };

    const handleClienteSocioChange = (e) => {
        setClienteSocio({
            ...clienteSocio,
            [e.target.name]: e.target.value
        });
    };

    const handleEmpresaChange = (e) => {
        setEmpresa({
            ...empresa,
            [e.target.name]: e.target.value
        });
    };

    // Método para enviar los datos del formulario al servidor
    const handleSubmit = (e) => {
        e.preventDefault();
        
        // Aquí puedes enviar los datos al servidor, por ejemplo:
        fetch('url_del_servidor', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                actor: actor,
                ejemplares: ejemplares,
                director: director,
                clienteSocio: clienteSocio,
                empresa: empresa
            })
        })
        .then(response => response.json())
        .then(data => {
            console.log('Respuesta del servidor:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    };

    return (
        <>
            <NavBar />

            <form>
                <div className="seccion">
                    <h3>Pelicula</h3>
                    <label>Pelicula</label>
                    <input type="text" name="titulo" value={pelicula.titulo} onChange={handlePeliculaChange} />
                    <label>Nacionalidad</label>
                    <input type="text" name="nacionalidad" value={pelicula.nacionalidad} onChange={handlePeliculaChange} />
                    <label>Productores</label>
                    <input type="text" name="productores" value={pelicula.productores} onChange={handlePeliculaChange} />
                    <label>Fecha</label>
                    <input type="text" name="telefono" value={pelicula.telefono} onChange={handlePeliculaChange} />
                </div>
                <div className="seccion">
                    <h3>Actor</h3>
                    <label>Nombre</label>
                    <input type="text" name="nombre" value={actor.nombre} onChange={handleActorChange} />
                    <label>Nacionalidad</label>
                    <input type="text" name="nacionalidad" value={actor.nacionalidad} onChange={handleActorChange} />
                    <label>Correo</label>
                    <input type="text" name="correo" value={actor.correo} onChange={handleActorChange} />
                    <label>Telefono</label>
                    <input type="text" name="telefono" value={actor.telefono} onChange={handleActorChange} />
                    <label>Sexo</label>
                    <select name="sexo" value={actor.sexo} onChange={handleActorChange}>
                        <option value="H">Hombre</option>
                        <option value="M">Mujer</option>
                    </select>
                </div>
                <div className="seccion">
                    <h3>Ejemplares</h3>
                    <label>Cantidad</label>
                    <input type="number" name="cantidad" value={ejemplares.cantidad} onChange={handleEjemplaresChange} />
                    <label>Estado</label>
                    <select name="estado" value={ejemplares.estado} onChange={handleEjemplaresChange}>
                        <option value="Bueno">Bueno</option>
                        <option value="Malo">Malo</option>
                        <option value="Regular">Regular</option>
                    </select>
                </div>
                <div className="seccion">
                    <h3>Director</h3>
                    <label>Nombre</label>
                    <input type="text" name="nombre" value={director.nombre} onChange={handleDirectorChange} />
                    <label>Nacionalidad</label>
                    <input type="text" name="nacionalidad" value={director.nacionalidad} onChange={handleDirectorChange} />
                    <label>Correo</label>
                    <input type="text" name="correo" value={director.correo} onChange={handleDirectorChange} />
                </div>
                <div className="seccion">
                    <h3>Cliente Socio</h3>
                    <label>Fecha de comienzo</label>
                    <input type="date" name="fechaComienzo" value={clienteSocio.fechaComienzo} onChange={handleClienteSocioChange} />
                    <label>Fecha de devolución</label>
                    <input type="date" name="fechaDevolucion" value={clienteSocio.fechaDevolucion} onChange={handleClienteSocioChange} />
                    <label>Dirección</label>
                    <input type="text" name="direccion" value={clienteSocio.direccion} onChange={handleClienteSocioChange} />
                    <label>Teléfono</label>
                    <input type="text" name="telefono" value={clienteSocio.telefono} onChange={handleClienteSocioChange} />
                    <label>Socios presentados</label>
                    <input type="text" name="sociosPresentados" value={clienteSocio.sociosPresentados} onChange={handleClienteSocioChange} />
                </div>
                <div className="seccion">
                    <h3>Empresa</h3>
                    <label>Nombre</label>
                    <input type="text" name="nombre" value={empresa.nombre} onChange={handleEmpresaChange} />
                    <label>Dirección</label>
                    <input type="text" name="direccion" value={empresa.direccion} onChange={handleEmpresaChange} />
                    <label>Correo</label>
                    <input type="text" name="correo" value={empresa.correo} onChange={handleEmpresaChange} />
                    <label>Teléfono</label>
                    <input type="text" name="telefono" value={empresa.telefono} onChange={handleEmpresaChange} />
                </div>

                <div className='boton'>
                    <button>Enviar</button>
                </div>
            </form>


        </>
    )

}

                    