using System;
using Gtk;

using CGtk;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();

        treeView.AppendColumn("id", new CellRendererText(), "text", 0);   // permite añadir columnas al treeView
        treeView.AppendColumn("nombre", new CellRendererText(), "text", 1);


        ListStore listStore = new ListStore(typeof(string), typeof(string)); //crea un modelo para que se muestren las cabeceras del treeView 

        treeView.Model = listStore;

        listStore.AppendValues("1", "cat 1");//Añade los valores por fila
        listStore.AppendValues("2", "cat 2");


        newAction.Activated += (sender, e) => new CategoriaWindow(); //Lanza la nueva ventana

        editAction.Activated +=(sender, e) => ;
    

    }


    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
