import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Scanner;

public class HoaDon {
    private String mahd;
    private String ngaylaphd;
    private String manv;
    private String makh;
    private double tongtien;
    public double getTongTien()
    {
        return tongtien;
    }

    public String getNgayLapHD()
    {
        return ngaylaphd;
    }
    public String getMaNV()
    {
        return manv;
    }

    public String getMaHD()
    {
        return mahd;
    }
    public String getMaKH()
    {
        return makh;
    }
    public void setMahd(String mahd)
    {
        this.mahd=mahd;
    }
    public void setngayLapHD(String ngaylaphd)
    {
        this.ngaylaphd=ngaylaphd;
    }
    public void setMaNV(String manv)
    {
        this.manv=manv;
    }
    public void setMaKH(String makh)
    {
        this.makh=makh;
    }
    public void setTongTien(double tongtien)
    {
        this.tongtien=tongtien;
    }
    public HoaDon()
    {

    }
    public HoaDon(String mahd,String ngaylaphd,String manv,String makh,double tongtien)
    {
        this.mahd=mahd;
        this.ngaylaphd=ngaylaphd;
        this.manv=manv;
        this.makh=makh;
        this.tongtien=tongtien;


    }
    public HoaDon(HoaDon temp)
    {
        this.mahd=temp.mahd;
        this.ngaylaphd=temp.ngaylaphd;
        this.manv=temp.manv;
        this.makh= temp.makh;
        this.tongtien=temp.tongtien;

    }

    public void nhap()
    {
        DSHoaDon ds=new DSHoaDon();
        ds.dshoadon= Arrays.copyOf(QLBH.dshoadon,QLBH.dshoadon.length);
        ds.n=QLBH.dshoadon.length;
        Scanner scanner=new Scanner(System.in);
        do{
        System.out.print("nhập mã hóa đơn : ");
        mahd=scanner.nextLine();
        if(ds.checkmahd(mahd)==false)
        {
            System.out.println(" mã hóa đơn đã tồn tại ! ");
        }
        }
        while(ds.checkmahd(mahd)==false);


        System.out.print("nhập ngày lập hóa đơn : ");
        ngaylaphd=scanner.nextLine();
        System.out.print("nhập mã nhân viên : ");
        manv=scanner.nextLine();
        System.out.print("nhập mã khách hàng ");
        makh=scanner.nextLine();
        System.out.print(" nhập tổng tien : ");
        tongtien=scanner.nextDouble();
    }



    public void nhap(String mahd)
    {
     Scanner scanner=new Scanner(System.in);
        this.mahd=mahd;
        System.out.print("nhập ngày lập hóa đơn : ");
        ngaylaphd=scanner.nextLine();
        System.out.print("nhập mã nhân viên : ");
        manv=scanner.nextLine();
        System.out.print("nhập mã khách hàng ");
        makh=scanner.nextLine();
        System.out.print(" nhập tổng tien : ");
        tongtien=scanner.nextDouble();
    }






    public void xuat() {
        System.out.println("                    HÓA ĐƠN BÁN HÀNG                  ");
        System.out.println("========================================================");
        System.out.printf("| %-25s | %-25s |\n", "Mã hóa đơn", mahd);
        System.out.printf("| %-25s | %-25s |\n", "Ngày lập hóa đơn", ngaylaphd);
        System.out.printf("| %-25s | %-25s |\n", "Mã nhân viên", manv);
        System.out.printf("| %-25s | %-25s |\n", "Mã khách hàng", makh);
        System.out.printf("| %-25s | %-21.0f VND |\n", "Tổng tiền", tongtien);
        System.out.println("========================================================");
        System.out.println("\n");
    }


}
