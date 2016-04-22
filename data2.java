package bab5;



public class data2 {
    int id_tamu;
    String pesan,kepada;

    public data2() {
    }

    public data2(int id_tamu, String pesan, String kepada) {
        this.id_tamu = id_tamu;
        this.pesan = pesan;
        this.kepada = kepada;
    }

    public int getId_tamu() {
        return id_tamu;
    }

    public void setId_tamu(int id_tamu) {
        this.id_tamu = id_tamu;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getKepada() {
        return kepada;
    }

    public void setKepada(String kepada) {
        this.kepada = kepada;
    }
}    

