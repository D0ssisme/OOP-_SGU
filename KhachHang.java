public class KhachHang {
    private String makh;
    private String hokh;
    private String tenkh;
    private String sdt;
    private double tongtien;
    public double getTongTien()
    {
       return tongtien;

    }
    public void tinhTongTien(DSHoaDon temp)
    {
        this.tongtien=temp.tinhTongTienTheoMaKH(this.makh);
    }
    public String getMaKh()
    {
        return makh;
    }
    public KhachHang()
    {

    }
    public KhachHang(String makh,String hokh,String tenkh,String sdt,DSHoaDon temp)
    {
        this.makh=makh;
        this.hokh=hokh;
        this.tenkh=tenkh;
        this.sdt=sdt;
        tinhTongTien(temp);
    }
    public KhachHang(KhachHang temp)
    {

    }



}
