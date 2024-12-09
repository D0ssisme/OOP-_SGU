import java.util.Arrays;
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
    public void setTenNCC(String tenncc)
    {
        this.tenncc=tenncc;
    }
    public void setSDTNCC(String sdt)
    {
        this.sdt=sdt;
    }
    public void setDiaChiNCC(String diachi)
    {
        this.diachi=diachi;
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
        DSNCC ds=new DSNCC();
        ds.dsnhacungcap= Arrays.copyOf(QLBH.dsnhacungcap,QLBH.dsnhacungcap.length);
        do{
            System.out.print("mã nhà cung cấp : ");
            mancc=scanner.nextLine();
            if(ds.checkmancc(mancc)==false)
            {
                System.out.println(" mã nhà cung cấp đã tồn tại ! ");

            }

        }while(ds.checkmancc(mancc)==false);

        System.out.print("tên nhà cung cấp");
        tenncc=scanner.nextLine();
        System.out.print("số điện thoại : ");
        sdt=scanner.nextLine();
        System.out.print("địa chỉ : ");
        diachi=scanner.nextLine();
    }
    public void xuat() {
        System.out.println("----- Thông Tin Nhà Cung Cấp -----");
        System.out.printf("%-20s: %s\n", "Mã nhà cung cấp", mancc);
        System.out.printf("%-20s: %s\n", "Tên nhà cung cấp", tenncc);
        System.out.printf("%-20s: %s\n", "Số điện thoại", sdt);
        System.out.printf("%-20s: %s\n", "Địa chỉ", diachi);
        System.out.println("-----------------------------------");
    }

}
