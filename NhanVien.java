import java.util.Arrays;
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
    public void setHoNV(String honv)
    {
        this.honv=honv;
    }
    public void setTenNV(String tennv)
    {
        this.tennv=tennv;
    }
    public void setLuong(double luong)
    {
        this.luong=luong;
    }
    public void setChucVu(String chucvu)
    {
        this.chucvu=chucvu;
    }
    public void setSoDienThoai(String sodienthoai)
    {
        this.sodienthoai=sodienthoai;
    }
    public void setCCCD(String cccd)
    {
        this.cccd=cccd;
    }
    public void setDiaChi(String diachi)
    {
        this.diachi=diachi;
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
        DSNV ds=new DSNV();
        ds.dsnhanvien=Arrays.copyOf(QLBH.dsnhanvien,QLBH.dsnhanvien.length);
        do{
            System.out.print("mã nhân viên : ");
            manv=scanner.nextLine();
            if(ds.checkmanv(manv)==false)
            {
                System.out.println(" mã nhân viên đã tồn tại !");
            }

        }
        while(ds.checkmanv(manv)==false);

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
        System.out.println("----- Thông Tin Nhân Viên -----");
        System.out.printf("%-15s: %s\n", "Mã nhân viên", manv);
        System.out.printf("%-15s: %s\n", "Họ nhân viên", honv);
        System.out.printf("%-15s: %s\n", "Tên nhân viên", tennv);
        System.out.printf("%-15s: %.2f\n", "Lương", luong);
        System.out.printf("%-15s: %s\n", "Chức vụ", chucvu);
        System.out.printf("%-15s: %s\n", "Số điện thoại", sodienthoai);
        System.out.printf("%-15s: %s\n", "CCCD", cccd);
        System.out.printf("%-15s: %s\n", "Địa chỉ", diachi);
        System.out.println("--------------------------------");
        System.out.println("\n");
    }




}
