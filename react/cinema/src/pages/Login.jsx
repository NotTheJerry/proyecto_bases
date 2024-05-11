import { useState } from "react";
import { B4_Inicio_NavBar } from "../components/B4_Inicio_NavBar"
import '../styles/login.css'
import { Alerta } from "../components/Alerta";

export const Login = () => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [mensaje, setMensaje] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username,
                password,
            })
        });
        if (response.ok) {
            const data = await response.json();
            const token = data.token;
            localStorage.setItem('token', token);
            window.location.href = '/inicio';
        } else {
            console.error('Error de inicio de sesión:', response.statusText);
            setMensaje("Ocurrio un error");
            setTimeout(() => {
                setMensaje('');
            }, 3000);
        }
        } catch (error) {
            console.error('Error de inicio de sesión:', error);
            setMensaje("Ocurrio un error externo");
            setTimeout(() => {
                setMensaje('');
            }, 3000);
        }
    };



    return (
        <>
            <B4_Inicio_NavBar />
            
            <Alerta mensaje={mensaje} />
            <div className="container">
                <form className="login-form" onSubmit={handleSubmit} >
                    <div className="subtitulo_formulario">
                        <h2 className="sub">Login</h2>
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
                        <button type="submit">Iniciar sesión</button>
                    </div>
                </form>
            </div>

        </>
    )
} 