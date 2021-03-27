public class Pemain{
    private String Nama;
    private Kartu[] ListKartu; 
    private Boolean Giliran;
    
    public Pemain(String nama, Kartu[] listKartu){
        this.Nama = nama;
        this.ListKaru = listKartu;
        this.Giliran = false;
    }
    public getKartu(int kartuKe){
        return ListKartu[kartuKe];
    }
    public giliranJalan(Boolean jalan){
        this.Giliran = jalan;
    }

}