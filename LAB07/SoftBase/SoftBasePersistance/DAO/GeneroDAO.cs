using SoftBase.model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftBasePersistance.DAO
{
    public interface GeneroDAO
    {
        int insertar(GenerosDTO genero);
        GenerosDTO obtenerPorId(int generoId);
        BindingList<GenerosDTO> ListarTodos();
        int modificar(GenerosDTO genero);
        int eliminar(GenerosDTO genero);
    }
}
