import { useState } from "react";
import { B4_Inicio_NavBar } from "../components/B4_Inicio_NavBar"
import '../styles/login.css'
import { Alerta } from "../components/Alerta";


export const Register = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [mensaje, setMensaje] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        if(password.includes("soyadmin")){ 
            console.log("Paso por aqui 1")
            const token = localStorage.getItem('token');
            if(token){
                console.log("Paso por aqui 2")
                const admin = true;
                try {
                    console.log("Paso por aqui 3");
                    const response = await fetch('http://localhost:8080/api/users', {
                        method: 'POST',
                        headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${token}`
                        },
                        body: JSON.stringify({
                        username,
                        password,
                        admin
                        })
                    });
                    setMensaje("Se creo correctamente el admin");
                    setTimeout(() => {
                        setMensaje('');
                    }, 3000);
                } catch (error) {
                    console.error('Error registro:', error);
                    setMensaje("Ocurrio un error");
                    setTimeout(() => {
                        setMensaje('');
                    }, 3000);
                }
                return;
            }
         }


        try {
        const response = await fetch('http://localhost:8080/api/users/register', {
            method: 'POST',
            headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({
            username,
            password
            })
        });
        if (response.ok) {
            window.location.href = '/login';
        } else {
            console.error('Error de registro:', response.statusText);
            setMensaje("Ocurrio un error");
            setTimeout(() => {
                setMensaje('');
            }, 3000);
        }
        } catch (error) {
            console.error('Error registro:', error);
        }
    };

    return (
        <>
            <B4_Inicio_NavBar />

            <Alerta mensaje={mensaje}/>

            <div className="container">
                <form className="login-form" onSubmit={handleSubmit} >
                    <div className="subtitulo_formulario">
                        <h2 className="sub">Registro</h2>
                    </div>
                    <div className="form-group">
                        <label htmlFor="username">Usuario:</label>
                        <input type="text" id="username" name="username" required value={username} onChange={(e) => setUsername(e.target.value)} />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Contraseña:</label>
                        <input type="password" id="password" name="password" required value={password} onChange={(e) => setPassword(e.target.value)} />
                    </div>
                    <div className="div_boton">
                        <button type="submit">Registrarse</button>
                    </div>
                </form>
            </div>
        </>
    )

}