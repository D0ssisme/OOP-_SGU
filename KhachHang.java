import java.util.Arrays;
import java.util.Scanner;


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

    public String getMaKh()
    {
        return makh;
    }

    public void setMakh(String makh)
    {
        this.makh=makh;
    }
    public void setHoKH(String hokh)
    {
        this.hokh=hokh;
    }
    public void setTenKH(String tenkh)
    {
        this.tenkh=tenkh;
    }
    public void setSDT(String sdt)
    {
        this.sdt=sdt;
    }
    public void setTongTien(double tongtien)
    {
        this.tongtien=tongtien;
    }


    public KhachHang()
    {

    }
    public KhachHang(String makh,String hokh,String tenkh,String sdt,double tongtien)
    {
        this.makh=makh;
        this.hokh=hokh;
        this.tenkh=tenkh;
        this.sdt=sdt;
        this.tongtien=tongtien;
    }
    public KhachHang(KhachHang temp)
    {

        this.makh=temp.makh;
        this.hokh=temp.hokh;
        this.tenkh=temp.tenkh;
        this.sdt=temp.sdt;
        this.tongtien=temp.tongtien;

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        DSKH ds=new DSKH();
        ds.dskhachhang= Arrays.copyOf(QLBH.dskhachhang,QLBH.dskhachhang.length);
        do{
        System.out.print(" mã khách hàng : ");
        makh=scanner.nextLine();
        if(ds.checkmakh(makh)==false)
        {
            System.out.println(" mã khách hàng đã tồn tại ");
        }
        }while(ds.checkmakh(makh)==false);

        System.out.print(" họ khách hàng : ");
        hokh=scanner.nextLine();
        System.out.print("tên khách hàng : ");
        tenkh= scanner.nextLine();
        System.out.print(" số điện thoại : ");
        sdt=scanner.nextLine();
        System.out.print("tổng tiền : ");
        tongtien=scanner.nextDouble();


    }
    public void xuat() {


        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15.0f |\n",
                makh, hokh, tenkh, sdt, tongtien);

        System.out.println("===========================================================================================");
    }





}
