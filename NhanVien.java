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
        System.out.print("manv : ");
        manv=scanner.nextLine();
        System.out.print("honv : ");
        honv=scanner.nextLine();
        System.out.print("tennv : ");
        tennv=scanner.nextLine();
        System.out.print("luong : ");
        luong=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("chuc vu : ");
        chucvu=scanner.nextLine();
        System.out.print("so dien thoai : ");
        sodienthoai=scanner.nextLine();
        System.out.print("cccd : ");
        cccd=scanner.nextLine();
        System.out.print("dia chi : ");
        diachi=scanner.nextLine();

    }
    public void xuat() {
        System.out.printf("%-10s %-15s %-15s %-10.2f %-15s %-15s %-15s %-20s\n",
                manv, honv, tennv, luong, chucvu, sodienthoai, cccd, diachi);
    }




}
