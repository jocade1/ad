using System;
namespace CGtk
{
    public partial class EditarWindow : Gtk.Window
    {
        public EditarWindow() :
                base(Gtk.WindowType.Toplevel)
        {
            this.Build();
        }
    }
}
