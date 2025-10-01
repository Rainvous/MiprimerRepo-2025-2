using SoftBase.model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftBasePersistance.DAO
{
    public interface VideojuegoDAO
    {

        int insertar(VideojuegosDTO videojuego);
        VideojuegosDTO obtenerPorId(int videojuegoId);
        BindingList<VideojuegosDTO> ListarTodos();
        int modificar(VideojuegosDTO videojuego);
        int eliminar(VideojuegosDTO videojuego);
    }
}
