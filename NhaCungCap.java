import java.util.Scanner;
public class NhaCungCap {
    private String mancc;
    private String tenncc;
    private String sdt;
    private String diachi;
    public String getMaNCC()
    {
        return mancc;
    }
    public void setMaNCC(String mancc)
    {
        this.mancc=mancc;
    }
    public NhaCungCap()
    {

    }
    public NhaCungCap(NhaCungCap temp)
    {
        this.mancc=temp.mancc;
        this.tenncc=temp.tenncc;
        this.sdt=temp.sdt;
        this.diachi=temp.diachi;

    }
    public NhaCungCap(String mancc,String tenncc,String sdt,String diachi)
    {
        this.mancc=mancc;
        this.tenncc=tenncc;
        this.sdt=sdt;
        this.diachi=diachi;

    }
    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("mã nhà cung cấp : ");
        mancc=scanner.nextLine();
        System.out.print("tên nhà cung cấp");
        tenncc=scanner.nextLine();
        System.out.print("số điện thoại : ");
        sdt=scanner.nextLine();
        System.out.print("địa chỉ : ");
        diachi=scanner.nextLine();
    }
    public void xuat()
    {
        System.out.println("mã nhà cung cấp : "+mancc);
        System.out.println("tên nhà cung cấp :"+tenncc);
        System.out.println("số điện thoại : "+sdt);
        System.out.println("địa chỉ : "+diachi);


    }
}
