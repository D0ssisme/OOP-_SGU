import java.util.Scanner;
public class ThuongHieu {
    private String mathuonghieu;
    private String tenthuonghieu;
    private int namthanhlap;
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
    public ThuongHieu()
    {

    }
    public ThuongHieu(ThuongHieu temp)
    {
        this.mathuonghieu=temp.mathuonghieu;
        this.tenthuonghieu=temp.tenthuonghieu;
        this.namthanhlap= temp.namthanhlap;
        this.email=temp.email;
        this.sdt=temp.sdt;
        this.diachitruso=temp.diachitruso;

    }
    public ThuongHieu(String mathuonghieu,String tenthuonghieu,int namthanhlap,String email,String sdt,String diachitruso)
    {
        this.mathuonghieu=mathuonghieu;
        this.tenthuonghieu=tenthuonghieu;
        this.namthanhlap=namthanhlap;
        this.email=email;
        this.sdt=sdt;
        this.diachitruso=diachitruso;
    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("mã thương hiệu : ");
        mathuonghieu=scanner.nextLine();
        System.out.print("tên thương hiệu : ");
        tenthuonghieu=scanner.nextLine();
        System.out.print("năm thành lập : ");
        namthanhlap=scanner.nextInt();
        scanner.nextLine();
        System.out.print("email : ");
        email=scanner.nextLine();
        System.out.print("số điện thoại : ");
        sdt=scanner.nextLine();
        System.out.print("địa chỉ trụ sở : ");
        diachitruso=scanner.nextLine();
    }
    public void xuat()
    {
        System.out.print("mã thương hiệu : "+mathuonghieu);
        System.out.print("tên thương hiệu : "+tenthuonghieu);
        System.out.print("năm thành lập : "+namthanhlap);
        System.out.print("email : "+email);
        System.out.print("số điện thoại : "+sdt);
        System.out.print("địa chỉ trụ sở : "+diachitruso);
    }



}
