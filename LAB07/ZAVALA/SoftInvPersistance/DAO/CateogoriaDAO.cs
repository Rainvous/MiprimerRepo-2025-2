using SoftInvModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvPersistance.DAO
{
    public interface CategoriaDAO
    {

        int Insertar(Categoria categoria);
        int Modificar(Categoria categoria);
        int Eliminar(Categoria categoria);
        Categoria ObtenerPorId(int id);
        BindingList<Categoria> ListarTodos();



    }
}
