using System;

namespace CConsola
{

    class MainClass{

        public static void Main(string[] args) {
            //int entero =readInteger("Introduce un numero: ");
            //Console.WriteLine("entero={0}", entero);
            //int option = readOption("Elige opcion [012]: ", "012");

            Menu.Create("Menu Categorias")
                .Add("1 - Nuevo", nuevo)
                .Add("2 - Nuevo", editar)
                .Add("3 - Nuevo", borrar)
                .ExitWhen("0 - Salir")
                .Loop();

        }



        private static void nuevo() {
            Console.WriteLine("Ha entrado en nuevo");
            Console.ReadLine();
        
        }


        private static void editar()
        {
            Console.WriteLine("Ha entrado en editar");
            Console.ReadLine();


        }


        private static void borrar()
        {
            Console.WriteLine("Ha entrado en borrar");
            Console.ReadLine();

        }


        private static void salir()
        {
            Console.WriteLine("Ha entrado en salir");
            Console.ReadLine();

        }
        //public static int readInteger(string label)
        //{
        //    while (true)
        //    {
        //        Console.Write(label);
        //        string linea = Console.ReadLine();
        //        try
        //        {
        //            return Int32.Parse(linea);
        //        }
        //        catch
        //        {
        //            Console.WriteLine("Formato invalido. Vuelve a introducir");
        //        }




        //    };




        //}

        //public static int readOption(string label, string options)
        //{
        //    while(true)
        //    {
        //        Console.Write(label);
        //        string linea = Console.ReadLine();
        //        if (options.Contains(option))
        //    }



        //}
    }
}