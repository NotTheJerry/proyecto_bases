import '../styles/navbar.css'
import cinemaLogo from "../svg/cinema_logo.svg"

export const B4_Inicio_NavBar = () => {

    return (
        <div className="div_padre">
            <div className='nombre_del_sitio'>
                <img src={ cinemaLogo } alt="Cinema Logo" />
                <h1>CINEMA</h1>
            </div>
            <div className='secciones'>
                <a href="/register">Register</a>
                <a href="/login">Login</a>
                <a href="/inicio">Inicio</a>
            </div>
        </div>
    )

}