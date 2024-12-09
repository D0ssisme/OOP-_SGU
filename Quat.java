import java.util.Arrays;
import java.util.Scanner;

abstract public class Quat {
    public String masp;
    public String tensp;
    public String ngaysanxuat;
    public int soluong;
    public double gia;
    public String mathuonghieu;
    public String trongluong;
    public String congsuat;


    public abstract void baoTri();
    public String getNXS() {return ngaysanxuat;}
    public String getTenSP(){return tensp;};
    public String getMaSP() {return masp;}
    public double getGia() {
        return gia;
    }
    public int getSoLuong()
    {
        return soluong;
    }
    public String getMaThuongHieu()
{
    return mathuonghieu;
}
    public void setMaSP(String masp) {
        this.masp = masp;

    }
    public void setTenSP(String tensp)
    {
        this.tensp=tensp;
    }
    public void setNgaySanXuat(String ngaysanxuat)
    {
        this.ngaysanxuat=ngaysanxuat;

    }
    public void setSoLuong(int soluong)
    {
        this.soluong=soluong;
    }
    public void setMathuonghieu(String mathuonghieu)
    {
        this.mathuonghieu=mathuonghieu;
    }
    public void setTrongLuong(String trongluong)
    {
        this.trongluong=trongluong;
    }
    public void setCongSuat(String congsuat)
    {
        this.congsuat=congsuat;
    }

    public void setGia(double gia) {
        this.gia = gia;

    }

    public Quat() {

    }

    public Quat(Quat temp) {
        this.masp = temp.masp;
        this.tensp = temp.tensp;
        this.ngaysanxuat = temp.ngaysanxuat;
        this.soluong = temp.soluong;
        this.gia = temp.gia;
        this.mathuonghieu = temp.mathuonghieu;
        this.trongluong = temp.trongluong;
        this.congsuat = temp.congsuat;

    }

    public Quat(String masp, String tensp, String ngaysanxuat, int soluong, double gia, String thuonghieu,
            String trongluong, String congsuat) {
        this.masp = masp;
        this.tensp = tensp;
        this.ngaysanxuat = ngaysanxuat;
        this.soluong = soluong;
        this.gia = gia;
        this.mathuonghieu = thuonghieu;
        this.trongluong = trongluong;
        this.congsuat = congsuat;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        DSQuat dsQuat=new DSQuat();


      do {
          System.out.print("mã sản phẩm : ");
          masp = scanner.nextLine();
          if(dsQuat.checkmasp(masp)==false)
          {
              System.out.println("mã sản phẩm đã tồn tại vui lòng nhập lại ! ");
          }
      }while(dsQuat.checkmasp(masp)==false);
        System.out.print("tên sản phẩm : ");
        tensp = scanner.nextLine();
        System.out.print("ngày sản xuất : ");
        ngaysanxuat = scanner.nextLine();
        System.out.print("số lượng : ");
        soluong = scanner.nextInt();
        scanner.nextLine();
        System.out.print("giá : ");
        gia = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("mã thương hiệu : ");
        mathuonghieu = scanner.nextLine();
        System.out.print("trọng lượng : ");
        trongluong = scanner.nextLine();
        System.out.print("công suất : ");
        congsuat = scanner.nextLine();

    }



    public void nhap(String masp) {
        Scanner scanner = new Scanner(System.in);
        this.masp=masp;
        System.out.print("tên sản phẩm : ");
        tensp = scanner.nextLine();
        System.out.print("ngày sản xuất : ");
        ngaysanxuat = scanner.nextLine();
        System.out.print("số lượng : ");
        soluong = scanner.nextInt();
        scanner.nextLine();
        System.out.print("giá : ");
        gia = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("mã thương hiệu : ");
        mathuonghieu = scanner.nextLine();
        System.out.print("trọng lượng : ");
        trongluong = scanner.nextLine();
        System.out.print("công suất : ");
        congsuat = scanner.nextLine();

    }

    public void xuat() {
        System.out.printf("%-14s %-19s %-17s %-10s %-10.0f  %-15s %-13s %-13s",
                masp, tensp, ngaysanxuat, soluong, gia, mathuonghieu, trongluong, congsuat, "", "", "", "");

    }

}
