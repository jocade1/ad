using System;
using System.Data;
namespace CMySql
namespace CArticulo
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Acceso a CArticulo");

            IDbConnection dbConnection = new MySqlConnection("servet=localhost;database=CArticulo;user=root;password=sistemas;ssl-mode=none");

            dbConnection.Open();

        }
    }

    internal interface IDbConnection
    {
    }
}
