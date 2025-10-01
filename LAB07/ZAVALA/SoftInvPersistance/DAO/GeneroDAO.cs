using SoftInvModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvPersistance.DAO
{
    public interface GeneroDAO
    {

        int Insertar(Genero genero);
        int Modificar(Genero genero);
        int Eliminar(Genero genero);
        Genero ObtenerPorId(int id);
        BindingList<Genero> ListarTodos();



    }
}
