﻿using System;
using System.Collections.Generic;

namespace CConsola
{
    public class Menu

    {
        private bool exit = false;
        private string menuLabel;
        private IList<string> labels = new List<string>();
        private IDictionary<string, Action> actions = new Dictionary<string, Action>();



        public static Menu Create(string menuLabel)
        {
            return new Menu(menuLabel);
        }


        private Menu(string menuLabel)
        {
            this.menuLabel = menuLabel;
        }


        public Menu Add(string label, Action action)
        {
            labels.Add(label);
            string option = label.Substring(0,1).ToUpper();
            actions.Add(option, action);
            return this;
        }


        public Menu ExitWhen(string label)
        {
            labels.Add(label);
            string option = label.Substring(0,1).ToUpper();
            actions.Add(option, () => exit = true);
            return this;

        }


        public void Loop()
        {
            while(!exit)
            {
                Console.WriteLine(menuLabel);
                foreach (string label in labels)
                    Console.WriteLine(label);
                string option = Console.ReadLine();
                if (actions.ContainsKey(option))
                    actions[option]();
                else
                    Console.WriteLine("Opcion invalida.Vuelve a introducir.");
            }
        }



    }
}
