import '../styles/alerta.css'

export const Alerta = ({mensaje}) => {
    if(!mensaje){ return; }

    return (
        <div className="alerta">
            <h1>{mensaje}</h1>
        </div>
    )
}