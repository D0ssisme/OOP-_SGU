import java.util.Arrays;
import java.util.Scanner;
public class ThuongHieu {
    private String mathuonghieu;
    private String tenthuonghieu;
    private String email;
    private String sdt;
    private String diachitruso;

    public String getMaThuongHieu()
    {
        return mathuonghieu;
    }
    public void setMathuonghieu(String mathuonghieu)
    {
        this.mathuonghieu=mathuonghieu;
    }
    public void setTenThuongHieu(String tenthuonghieu)
    {
        this.tenthuonghieu=tenthuonghieu;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setSDT(String sdt)
    {
        this.sdt=sdt;
    }
    public void setDiaChiTruSo(String diachitruso)
    {
        this.diachitruso=diachitruso;
    }

    public ThuongHieu()
    {

    }
    public ThuongHieu(ThuongHieu temp)
    {
        this.mathuonghieu=temp.mathuonghieu;
        this.tenthuonghieu=temp.tenthuonghieu;
        this.email=temp.email;
        this.sdt=temp.sdt;
        this.diachitruso=temp.diachitruso;

    }
    public ThuongHieu(String mathuonghieu,String tenthuonghieu,String email,String sdt,String diachitruso)
    {
        this.mathuonghieu=mathuonghieu;
        this.tenthuonghieu=tenthuonghieu;
        this.email=email;
        this.sdt=sdt;
        this.diachitruso=diachitruso;
    }
    public void nhap()
    {
        DSTH ds=new DSTH();
        ds.dsthuonghieu= Arrays.copyOf(QLBH.dsthuonghieu,QLBH.dsthuonghieu.length);
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.print("mã thương hiệu : ");
            mathuonghieu = scanner.nextLine();
            if(ds.checkmath(mathuonghieu)==false)
            {
                System.out.println(" mã thương hiệu đã tồn tại ");
            }
        }while(ds.checkmath(mathuonghieu)==false);
        System.out.print("tên thương hiệu : ");
        tenthuonghieu=scanner.nextLine();

        System.out.print("email : ");
        email=scanner.nextLine();
        System.out.print("số điện thoại : ");
        sdt=scanner.nextLine();
        System.out.print("địa chỉ trụ sở : ");
        diachitruso=scanner.nextLine();
    }
    public void xuat() {

        System.out.println("----- Thông Tin Thương Hiệu -----");
        System.out.printf("%-20s: %s\n", "Mã thương hiệu", mathuonghieu);
        System.out.printf("%-20s: %s\n", "Tên thương hiệu", tenthuonghieu);
        System.out.printf("%-20s: %s\n", "Email", email);
        System.out.printf("%-20s: %s\n", "Số điện thoại", sdt);
        System.out.printf("%-20s: %s\n", "Địa chỉ trụ sở", diachitruso);
        System.out.println("----------------------------------");
        System.out.println("\n");
    }




}
