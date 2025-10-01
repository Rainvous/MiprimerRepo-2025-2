
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Softbase.Db
{
    public abstract class DBManager
    {
        protected DbConnection conexion;
        protected string baseDeDatos;
        protected string nombreDeHost;
        protected string puerto;
        protected string usuario;
        protected string contraseña;
        protected static DBManager dbManager;

        protected DBManager()
        {
            //constructor protegido para evitar que se creen instancias.
            //Solo se podrá crear una instancia y esta debe hacerse usando el 
            //método getInstance()
        }
        public static DBManager Instance
        {
            get
            {
                if (dbManager == null)
                {
                    DBManager.CreateInstance();
                }
                return dbManager;
            }
        }
        private static void CreateInstance()
        {
            if (DBManager.dbManager == null)
            {
                DBManagerMySQL.CreateConcreteInstance();
                dbManager.LeerArchivoDeConfiguracion();
            }
        }
        private void LeerArchivoDeConfiguracion()
        {
            this.baseDeDatos = ConfigurationManager.AppSettings["baseDeDatos"];
            this.nombreDeHost = ConfigurationManager.AppSettings["nombreDeHost"];
            this.puerto = ConfigurationManager.AppSettings["puerto"];
            this.usuario = ConfigurationManager.AppSettings["usuario"];
            this.contraseña = ConfigurationManager.AppSettings["contraseña"];
            System.Console.WriteLine("baseDeDatos:" + this.baseDeDatos);
            System.Console.WriteLine("nombreDeHost:" + this.nombreDeHost);
            System.Console.WriteLine("puerto:" + this.puerto);
            System.Console.WriteLine("usuario:" + this.usuario);
        }
        public DbConnection Connection
        {
            get
            {
                string cadenaDeConexion = this.ObtenerCadenaDeConexion();
                //System.Console.WriteLine(cadenaDeConexion);
                this.RealizarConexionABaseDeDatos(cadenaDeConexion);
                return this.conexion;
            }
        }
        protected abstract void RealizarConexionABaseDeDatos(string cadenaDeConexion);

        protected abstract string ObtenerCadenaDeConexion();

        public abstract DbCommand CrearComando();

        public abstract string RetornarSQLParaUltimoAutoGenerado();

    }
}
