﻿using System;
using System.Data;
using MySql.Data.MySqlClient;
namespace CMySql
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Acceso a dbprueba");

            IDbConnection dbConnection = new MySqlConnection("server=localhost;database=dbprueba;user=root;password=sistemas;ssl-mode=none");

            dbConnection.Open();

            //            IDbCommand dbCommand = dbConnection.CreateCommand();
            //          dbCommand.CommandText = "select * from categoria";
            //        IDataReader dataReader = dbCommand.ExecuteReader();

            //      while (dataReader.Read()){
            //        Console.WriteLine("id={0} nombre={1}", dataReader["id"], dataReader["nombre"]);

            //        }
            //dataReader.Close();

            //dbConnection.Close(); 



            IDbCommand dbCommand = dbConnection.CreateCommand();
            string nombre = "nuevo" + DateTime.Now;
            dbCommand.CommandText = "insert into categoria (nombre) values('-----')";
            dbCommand.ExecuteNonQuery();

            dbConnection.Close();

            //public static void ShowMetaInfo() {
                //IDbCommand dbCommand = dbConnection.CreateCommand();
                //  dbCommand.CommandText = "select * from categoria";
                //IDataReader dataReader = dbCommand.ExecuteReader();
                //Console.WriteLine("FieldCount={0}", dataReader.FieldCount);
                //for(int index = 0; index < dataReader.FieldCount;index++)
                    //Console.WriteLine("FieldCount={0,3} ={1,-15} Type={2}", index, dataReader.GetName(index), dataReader.GetFieldType(index));



        }


    }

    }
}