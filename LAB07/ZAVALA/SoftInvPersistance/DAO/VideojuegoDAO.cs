using SoftInvModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvPersistance.DAO
{
    public interface VideojuegoDAO
    {

        int Insertar(VideoJuego videojuego);
        int Modificar(VideoJuego videojuego);
        int Eliminar(VideoJuego videojuego);
        VideoJuego ObtenerPorId(int id);
        BindingList<VideoJuego> ListarTodos();



    }
}
