using Microsoft.VisualStudio.TestTools.UnitTesting;
using Softbase.Db;
using SoftBase.model;
using SoftBasePersistance.DAO;
using SoftBasePersistance.DAOImpl;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data.Common;

namespace SoftBaseTest
{
    [TestClass]
    public class BDManagerTest
    {   

        protected DbConnection conexion;
        [TestMethod]
        public void TestInstancia()
        {
            Console.WriteLine("TESTEO DE INSTANCIA!");
            DBManager dBManager1 = DBManager.Instance;
            Assert.IsNotNull(dBManager1);

        }
        [TestMethod]
        public void TestConnectMYSQL()
        {
            Console.WriteLine("TESTEO DE getconection!");
            DBManager dBManager2 = DBManager.Instance;
            this.conexion = dBManager2.Connection;
            //System.Console.WriteLine("conexion en el test:"+this.conexion.ConnectionString);
            Console.WriteLine(AppDomain.CurrentDomain.SetupInformation.ConfigurationFile);
            Console.WriteLine("AppSettings count: " + ConfigurationManager.AppSettings.Count);
            
            Assert.IsNotNull(this.conexion);
        }
        [TestMethod]
        public void TestDAOGenero()
        {
            GeneroDAOImpl generodao = new GeneroDAOImpl();
            GenerosDTO genero= new GenerosDTO();
            genero.DescripcionGenero = "INSERT_BD";
            int valida= generodao.insertar(genero);
            Assert.IsTrue(valida>0);
            Console.WriteLine("Genero insertado con id: "+valida);
            genero.DescripcionGenero = "UPDATE_BD";
            genero.IdGenero = valida;
            valida = generodao.modificar(genero);
            Assert.IsTrue(valida > 0);
            System.Console.WriteLine("Genero elimando: " + valida);
            genero.IdGenero = valida;
            valida = generodao.eliminar(genero);

            BindingList<GenerosDTO> lista = generodao.ListarTodos();
            Assert.IsTrue(lista.Count > 0);

        }
        [TestMethod]
        public void TestDAOCategoria()
        {
            //CategoriasDTO categoria = new CategoriasDTO();
            //CategoriaDAOImpl categoriadao = new CategoriaDAOImpl();
            //categoria.DescripcionCategoria = "INSERT_BD";
            //categoria.IdCategoria = "M";
            //int valida = categoriadao.insertar(categoria);
            //Console.WriteLine("Categoria insertada con id: " + valida);
            //Assert.IsTrue(valida > 0);
            
            //categoria.DescripcionCategoria = "UPDATE_BD";
            
            //valida = categoriadao.modificar(categoria);
            //Assert.IsTrue(valida > 0);

            //BindingList<CategoriasDTO> lista = categoriadao.ListarTodos();
            //Assert.IsTrue(lista.Count > 0);

        }
        [TestMethod]
        public void TestDAOVideojuego()
        {
            VideojuegosDTO juego = new VideojuegosDTO();
            VideojuegoDAOImpl dao = new VideojuegoDAOImpl();
            GenerosDTO gen= new GenerosDTO();
            gen.IdGenero = 3; //Asegurarse de que este ID exista en la base de datos
            CategoriasDTO cat = new CategoriasDTO();
            cat.IdCategoria = "M"; //Asegurarse de que este ID exista en la base de datos
            juego.Genero = gen;
            juego.Categoria = cat;
            juego.NombreVideojuego = "Nuevo Juego Test";
            juego.FechaLanzamiento = new DateTime(2025, 10, 1, 19, 30, 0, DateTimeKind.Utc);
            juego.PreciAproxMercado = 1200;
            juego.NumJugadores = 100;
            int valida= dao.insertar(juego);
            Assert.IsTrue(valida > 0);

        }
    }
}
