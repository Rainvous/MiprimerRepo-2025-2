using SoftInv.DAOImpl.Util;
using SoftInv.DAOImpl;
using SoftInvModel;
using SoftInvPersistance.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CategoriaDAO = SoftInvPersistance.DAO.CategoriaDAO;

namespace SoftInvPersistance.DAOImpl
{
    public class CategoriaDAOImpl : DAOImplBase, CategoriaDAO
    {
        private Categoria categoria;

        public CategoriaDAOImpl() : base("categoria")
        {
            this.retornarLlavePrimaria = true;
            this.categoria = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("id_categoria", true, true));
            this.listaColumnas.Add(new Columna("descripcion_categoria", false, false));
        }

        protected override void IncluirValorDeParametrosParaInsercion()
        {
            AgregarParametro("@Nombre", this.categoria.Descripcion_categoria);

        }

        protected override void IncluirValorDeParametrosParaModificacion()
        {
            AgregarParametro("@descripcion_categoria", this.categoria.Descripcion_categoria);
            AgregarParametro("@id_categoria", this.categoria.Id_categoria);
        }

        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            AgregarParametro("@Id", this.categoria.Id_categoria);
        }

        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            AgregarParametro("@Id", this.categoria.Id_categoria);
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            this.categoria = new Categoria
            {
                Id_categoria = lector.GetInt32(0),
                Descripcion_categoria = lector.GetString(1)
            };
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.categoria = null;
        }

        protected override void AgregarObjetoALaLista(BindingList<object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.categoria);
        }

        public int Insertar(Categoria categoria)
        {
            this.categoria = categoria;
            return base.Insertar();
        }

        public int Modificar(Categoria categoria)
        {
            this.categoria = categoria;
            return base.Modificar();
        }

        public int Eliminar(Categoria categoria)
        {
            this.categoria = categoria;
            return base.Eliminar();
        }

        public Categoria ObtenerPorId(int id)
        {
            this.categoria = new Categoria { Id_categoria= id };
            base.ObtenerPorId();
            return this.categoria;
        }

        public new BindingList<Categoria> ListarTodos()
        {
            BindingList<object> lista = base.ListarTodos();
            BindingList<Categoria> resultado = new BindingList<Categoria>();

            foreach (Categoria p in lista)
            {
                resultado.Add(p);
            }

            return resultado;
        }
    }
}
