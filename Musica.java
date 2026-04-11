public class Musica {
    private String titulo;

    public Musica(String titulo){
        this.titulo = titulo;
    }   
 
    public String getTitulo() {
        return titulo;
    } 

    @Override
    public String toString() {
        return String.format("(%s)", titulo);
    }

    @Override
    public boolean equals(Object outraMusica) {
        Musica musica = (Musica) outraMusica;

        if (titulo.equals(musica.titulo)) {
            return true;
        } else {
            return false;
        }
    }
}
