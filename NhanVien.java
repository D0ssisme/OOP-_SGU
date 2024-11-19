import java.util.Scanner;
public class NhanVien
{
    private String manv;
    private String honv;
    private String tennv;
    private double luong;
    private String chucvu;
    private String sodienthoai;
    private String cccd;
    private String diachi;
    

    public String getMaNV()
    {
        return manv;
    }
    public String getHoNV()
    {
        return honv;
    }
    public String getTenNV()
    {
        return honv;
    }
    public double getLuong()
    {
        return luong;
    }

    public void setMaNV(String manv)
    {
        this.manv=manv;
    }

    public NhanVien()
    {

    }
    public NhanVien(String manv,String honv,String tennv,double luong,String chucvu,String sodienthoai,String cccd,String diachi)
    {
        this.manv=manv;
        this.honv=honv;
        this.tennv=tennv;
        this.luong=luong;
        this.chucvu=chucvu;
        this.sodienthoai=sodienthoai;
        this.cccd=cccd;
        this.diachi=diachi;
    }
    public NhanVien(NhanVien temp)
    {
        this.manv=temp.manv;
        this.honv=temp.honv;
        this.tennv=temp.tennv;
        this.luong=temp.luong;
        this.chucvu=temp.chucvu;
        this.sodienthoai=temp.sodienthoai;
        this.cccd=temp.cccd;
        this.diachi=temp.diachi;
    }

    public void nhap()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.print("mã nhân viên : ");
        manv=scanner.nextLine();
        System.out.print("họ nhân viên : ");
        honv=scanner.nextLine();
        System.out.print("tên nhân viên : ");
        tennv=scanner.nextLine();
        System.out.print("lương : ");
        luong=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("chức vụ : ");
        chucvu=scanner.nextLine();
        System.out.print("số điện thoại : ");
        sodienthoai=scanner.nextLine();
        System.out.print("căn cước công dân : ");
        cccd=scanner.nextLine();
        System.out.print("địa chỉ : ");
        diachi=scanner.nextLine();

    }
    public void xuat() {
        System.out.printf("%-10s %-15s %-15s %-10.2f %-15s %-15s %-15s %-20s\n",
                manv, honv, tennv, luong, chucvu, sodienthoai, cccd, diachi);
    }




}
