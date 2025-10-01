using SoftBase.model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftBasePersistance.DAO
{
    public interface CategoriaDAO
    {
        int insertar(CategoriasDTO categoria);
        CategoriasDTO obtenerPorId(string categoriaId);
        BindingList<CategoriasDTO> ListarTodos();
        int modificar(CategoriasDTO categoria);
        int eliminar(CategoriasDTO categoria);
    }
}
