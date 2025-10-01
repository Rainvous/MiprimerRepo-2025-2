using System.ComponentModel;
using System.Data.Common;
using SoftInv.DAOImpl.Util;
using SoftInv.DAOImpl;
using SoftInvModel;
using SoftInvPersistance.DAO;
using GeneroDAO = SoftInvPersistance.DAO.GeneroDAO;



namespace SoftInvPersistance.DAOImpl.Util
{ 
    public class GeneroDAOImpl : DAOImplBase, GeneroDAO
    {
        private Genero genero;

        public GeneroDAOImpl() : base("genero")
        {
            this.retornarLlavePrimaria = true;
            this.genero = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("id_genero", true, true));
            this.listaColumnas.Add(new Columna("descripcion_genero", false, false));
        }

        protected override void IncluirValorDeParametrosParaInsercion()
        {
            AgregarParametro("@Nombre", this.genero.Descripcion_genero);
            
        }

        protected override void IncluirValorDeParametrosParaModificacion()
        {
            AgregarParametro("@Nombre", this.genero.Descripcion_genero);
            AgregarParametro("@id_genero", this.genero.Id_genero);
        }

        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            AgregarParametro("@Id", this.genero.Id_genero);
        }

        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            AgregarParametro("@Id", this.genero.Id_genero);
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            this.genero = new Genero
            {
                Id_genero = lector.GetInt32(0),
                Descripcion_genero = lector.GetString(1)
            };
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.genero = null;
        }

        protected override void AgregarObjetoALaLista(BindingList<object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.genero);
        }

        public int Insertar(Genero genero)
        {
            this.genero = genero;
            return base.Insertar();
        }

        public int Modificar(Genero genero)
        {
            this.genero = genero;
            return base.Modificar();
        }

        public int Eliminar(Genero genero)
        {
            this.genero = genero;
            return base.Eliminar();
        }

        public Genero ObtenerPorId(int id)
        {
            this.genero = new Genero { Id_genero = id };
            base.ObtenerPorId();
            return this.genero;
        }

        public new BindingList<Genero> ListarTodos()
        {
            BindingList<object> lista = base.ListarTodos();
            BindingList<Genero> resultado = new BindingList<Genero>();

            foreach (Genero p in lista)
            {
                resultado.Add(p);
            }

            return resultado;
        }
    }
}