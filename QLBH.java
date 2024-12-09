import java.util.Arrays;
import java.util.Scanner;

public class QLBH {
    public static  Quat dsquat[];
    public static KhachHang dskhachhang[];
    public static NhanVien dsnhanvien[];
    public static NhaCungCap dsnhacungcap[];
    public static HoaDon dshoadon[];
    public static ChiTietHoaDon dschitiethoadon[];
    public static PhieuNhap dsphieunhap[];
    public static ChiTietPhieuNhap dschitietphieunhap[];
    public static ThuongHieu  dsthuonghieu[];


public void thongkenangcao()
{
    Scanner scanner=new Scanner(System.in);
    DSQuat dsquat = new DSQuat();
    dsquat.dsquat=Arrays.copyOf(QLBH.dsquat,QLBH.dsquat.length);
    dsquat.n=QLBH.dsquat.length;
    DSNV dsnv=new DSNV();
    dsnv.dsnhanvien=Arrays.copyOf(QLBH.dsnhanvien,QLBH.dsnhanvien.length);
    dsnv.n=QLBH.dsnhanvien.length;
    while(true) {
        System.out.println("1. thống kê tổng tiền hóa đơn theo sản phẩm  ");
        System.out.println("2. thống kê tổng tiền hóa đơn theo khách hàng  ");
        System.out.println("3. thoat'");
        int option = scanner.nextInt();
        switch (option)
        {
            case 1:
                dsquat.thongKeTongTienHoaDonTheoSanPham();
                break;
            case 2:
                dsnv.thongKeTongTienHoaDonTheoNhanVien();
                break;
            case 3:
                return;
            default:
                System.out.println(" nhập sai vui lòng nhập lại ! ");

        }

    }
}
    public void QLSP()
    {
        DSQuat dsquat = new DSQuat();
        dsquat.dsquat=Arrays.copyOf(QLBH.dsquat,QLBH.dsquat.length);
        dsquat.n=QLBH.dsquat.length;
        Scanner scanner = new Scanner(System.in);
        String masp;
        while (true) {
            System.out.println("\n--- Menu Quản Lý Sản Phẩm ---");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm mới");
            System.out.println("3. Tìm kiếm sản phẩm ");
            System.out.println("4. Sửa thông tin sản phẩm");
            System.out.println("5. Xóa sản phẩm");
            System.out.println("6. thoát");
            System.out.print("Chọn: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    dsquat.xuat();

                    break;
                case 2:
                    dsquat.them();
                    QLBH.dsquat=Arrays.copyOf(dsquat.dsquat,dsquat.dsquat.length);
                    break;
                case 3:
                   dsquat.menuTimKiem();

                    break;
                case 4:
                    System.out.println(" nhập mã sản phẩm muốn sửa : ");
                    masp = scanner.nextLine();
                    dsquat.sua(masp);
                    QLBH.dsquat=Arrays.copyOf(dsquat.dsquat,dsquat.dsquat.length);
                    break;
                case 5:
                    System.out.println(" nhập mã sản phẩm muốn xóa : ");
                    masp = scanner.nextLine();
                    dsquat.xoa(masp);
                    QLBH.dsquat=Arrays.copyOf(dsquat.dsquat,dsquat.dsquat.length);
                    break;
                case 6:
                    QLBH.dsquat=Arrays.copyOf(dsquat.dsquat,dsquat.dsquat.length);
                    return;
                default:
                    System.out.println("bạn nhập sai vui lòng nhập lại !!!");


            }
        }
    }
    public void QLHD()
    {
        Scanner scanner=new Scanner(System.in);
        String mahd;
        DSHoaDon dshoadon=new DSHoaDon();
        DSChiTietHoaDon dschitiethoadon=new DSChiTietHoaDon();
        dshoadon.dshoadon=Arrays.copyOf(QLBH.dshoadon,QLBH.dshoadon.length);
        dshoadon.n=QLBH.dshoadon.length;
        dschitiethoadon.dschitiethoadon=Arrays.copyOf(QLBH.dschitiethoadon,QLBH.dschitiethoadon.length);
        dschitiethoadon.n=QLBH.dschitiethoadon.length;
        while(true)
        {
            System.out.println("\n--- Menu Quản Lí Hóa Đơn ---");
            System.out.println("1. Hiển thị danh sách Hóa Đơn");
            System.out.println("2. Thêm Hóa Đơn mới");
            System.out.println("3. Tìm kiếm Hóa Đơn ");
            System.out.println("4. Sửa thông tin Hóa Đơn");
            System.out.println("5. Xóa Hóa Đơn");
            System.out.println("\n\n--- Menu Quản Lí Chi Tiết Hóa Đơn ---");
            System.out.println("6. Hiển thị danh sách Chi Tiết Hóa Đơn");
            System.out.println("7. Thêm Chi Tiết Hóa Đơn mới");
            System.out.println("8. Tìm kiếm Chi Tiết Hóa Đơn");
            System.out.println("9. Sửa thông Chi Tiết tin Hóa Đơn");
            System.out.println("10. Xóa Chi Tiết Hóa Đơn");
            System.out.println("11. thoát");
            System.out.print("Chọn: ");
            int option =scanner.nextInt();
            scanner.nextLine();
            switch (option)
            {
                case 1 :
                    dshoadon.xuat();

                    break;
                case 2:
                    dshoadon.them();
                    QLBH.dshoadon=Arrays.copyOf(dshoadon.dshoadon,dshoadon.dshoadon.length);

                    break;
                case 3 :
                   dshoadon.menuTimKIem();
                   break;

                case 4:
                    System.out.print("nhập mã hóa đơn muốn sửa : ");
                    mahd=scanner.nextLine();
                    dshoadon.sua(mahd);

                    QLBH.dshoadon=Arrays.copyOf(dshoadon.dshoadon,dshoadon.dshoadon.length);
                    break;
                case 5:
                    System.out.print("nhập mã hóa đơn muốn xoa' : ");
                    mahd=scanner.nextLine();
                    dshoadon.xoa(mahd);

                    QLBH.dshoadon=Arrays.copyOf(dshoadon.dshoadon,dshoadon.dshoadon.length);
                    break;
                case 6:
                    dschitiethoadon.xuat();
                    break;
                case 7:
                    dschitiethoadon.them();

                    QLBH.dschitiethoadon=Arrays.copyOf(dschitiethoadon.dschitiethoadon,dschitiethoadon.dschitiethoadon.length);
                    break;
                case 8:
                    System.out.print("nhập mã chi tiết hóa đơn muốn tìm :");
                    mahd=scanner.nextLine();
                  dschitiethoadon.timChiTietHoaDonTheoMaHD(mahd);



                    QLBH.dschitiethoadon=Arrays.copyOf(dschitiethoadon.dschitiethoadon,dschitiethoadon.dschitiethoadon.length);
                    break;
                case 9 :
                    System.out.print("nhập mã chi tiết hóa đơn muốn sửa : ");
                    mahd=scanner.nextLine();
                    dschitiethoadon.sua(mahd);

                    QLBH.dschitiethoadon=Arrays.copyOf(dschitiethoadon.dschitiethoadon,dschitiethoadon.dschitiethoadon.length);
                    break;
                case 10:
                    System.out.print("nhập  chi tiết mã hóa đơn muốn xóa : ");
                    mahd=scanner.nextLine();
                    dschitiethoadon.xoa(mahd);

                    QLBH.dschitiethoadon=Arrays.copyOf(dschitiethoadon.dschitiethoadon,dschitiethoadon.dschitiethoadon.length);
                    break;
                case 11:

                    QLBH.dschitiethoadon=Arrays.copyOf(dschitiethoadon.dschitiethoadon,dschitiethoadon.dschitiethoadon.length);
                    return;
                default:
                    System.out.println(" nhập sai vui lòng nhập lại ! ");



            }


        }

    }

    public void QLPN()
    {
        Scanner scanner=new Scanner(System.in);
        String mapn;
        DSPhieuNhap dsphieunhap=new DSPhieuNhap();
        DSChiTietPhieuNhap dschitietphieunhap =new DSChiTietPhieuNhap();
        dsphieunhap.dsphieunhap=Arrays.copyOf(QLBH.dsphieunhap,QLBH.dsphieunhap.length);
        dsphieunhap.n=QLBH.dsphieunhap.length;
        dschitietphieunhap.dschitietphieunhap=Arrays.copyOf(QLBH.dschitietphieunhap,QLBH.dschitietphieunhap.length);
        dschitietphieunhap.n=QLBH.dschitietphieunhap.length;
        while (true)
        {
            System.out.println("\n--- Menu Quản Lí Phiếu Nhập ---");
            System.out.println("1. Hiển thị danh sách Phiếu Nhập ");
            System.out.println("2. Thêm Phiếu Nhập  mới");
            System.out.println("3. Tìm kiếm Phiếu Nhập  ");
            System.out.println("4. Sửa thông tin Phiếu Nhập ");
            System.out.println("5. Xóa Phiếu Nhập ");
            System.out.println("\n--- Menu Quản Lí Chi Tiết Phiếu Nhập  ---");
            System.out.println("6. Hiển thị danh sách Chi Tiết Phiếu Nhập ");
            System.out.println("7. Thêm Chi Tiết Phiếu Nhập  mới");
            System.out.println("8. Tìm kiếm Chi Tiết Phiếu Nhập  theo mã");
            System.out.println("9. Sửa thông Chi Tiết tin Phiếu Nhập ");
            System.out.println("10. Xóa Chi Tiết Phiếu Nhập ");
            System.out.println("11. thoát");
            System.out.print("Chọn: ");
            int option =scanner.nextInt();
            scanner.nextLine();
            switch (option)
            {
                case 1:
                    dsphieunhap.xuat();
                    break;
                case 2:
                    dsphieunhap.them();
                    QLBH.dsphieunhap=Arrays.copyOf(dsphieunhap.dsphieunhap,dsphieunhap.dsphieunhap.length);
                    break;
                case 3:

                   dsphieunhap.menuTimKiem();
                    break;


                case 4:
                    System.out.println(" nhập mã phiếu nhập muốn sửa : ");
                    mapn=scanner.nextLine();
                    dsphieunhap.sua(mapn);
                    QLBH.dsphieunhap=Arrays.copyOf(dsphieunhap.dsphieunhap,dsphieunhap.dsphieunhap.length);
                    break;
                case 5:
                    System.out.println(" nhập mã phiếu nhập muốn xóa : ");
                    mapn=scanner.nextLine();
                    dsphieunhap.xoa(mapn);
                    QLBH.dsphieunhap=Arrays.copyOf(dsphieunhap.dsphieunhap,dsphieunhap.dsphieunhap.length);
                    break;
                case 6:
                    dschitietphieunhap.xuat();
                    break;
                case 7:
                    dschitietphieunhap.them();
                    QLBH.dschitietphieunhap=Arrays.copyOf(dschitietphieunhap.dschitietphieunhap,dschitietphieunhap.dschitietphieunhap.length);
                    break;
                case 8:
                    System.out.println(" nhập mã chi tiết phiếu nhập muốn tìm : ");
                    mapn=scanner.nextLine();
                    dschitietphieunhap.timKiemTheoMaPN(mapn);

                    break;
                case 9:
                    System.out.println(" nhập mã chi tiết phiếu nhập muốn sửa : ");
                    mapn=scanner.nextLine();
                    dschitietphieunhap.sua(mapn);
                    QLBH.dschitietphieunhap=Arrays.copyOf(dschitietphieunhap.dschitietphieunhap,dschitietphieunhap.dschitietphieunhap.length);
                    break;
                case 10 :
                    System.out.println(" nhập mã chi tiết phiếu nhập muốn xóa : ");
                    mapn=scanner.nextLine();
                    dschitietphieunhap.xoa(mapn);
                    QLBH.dschitietphieunhap=Arrays.copyOf(dschitietphieunhap.dschitietphieunhap,dschitietphieunhap.dschitietphieunhap.length);
                    break;
                case 11:
                    QLBH.dschitietphieunhap=Arrays.copyOf(dschitietphieunhap.dschitietphieunhap,dschitietphieunhap.dschitietphieunhap.length);
                    return ;
                default:
                    System.out.println(" nhập sai vui lòng nhập lại !\n");




            }
        }


    }
    public void QLKH()
    {
        Scanner scanner=new Scanner(System.in);
        DSKH ds=new DSKH();
        ds.dskhachhang=Arrays.copyOf(QLBH.dskhachhang, QLBH.dskhachhang.length);
        ds.n=dskhachhang.length;
        String makh;
        while(true)
        {
            System.out.println("\n--- Menu Quản Lí Khách Hàng ---");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm khách hàng ");
            System.out.println("3. xóa khách hàng ");
            System.out.println("4. Sửa thông tin khách hàng");
            System.out.println("5. tìm kiếm khách hàng ");
            System.out.println("6. thoát");
            System.out.print("Chọn: ");
            int option=scanner.nextInt();
            scanner.nextLine();
            switch(option)
            {
                case 1 :
                    ds.xuat();
                    break;
                case 2:

                    ds.them();
                    QLBH.dskhachhang=Arrays.copyOf(ds.dskhachhang,ds.dskhachhang.length);

                    break;
                case 3:
                    System.out.println("nhập mã khách hàng muốn xóa : ");
                    makh=scanner.nextLine();
                    ds.xoa(makh);
                    QLBH.dskhachhang=Arrays.copyOf(ds.dskhachhang,ds.dskhachhang.length);
                    break;
                case 4:
                    System.out.println("nhập mã khách hàng muốn sửa : ");
                    makh=scanner.nextLine();
                    ds.sua(makh);
                    QLBH.dskhachhang=Arrays.copyOf(ds.dskhachhang,ds.dskhachhang.length);
                    break;
                case 5:
                    System.out.println("nhập mã khách hàng muốn tìm : ");
                    makh=scanner.nextLine();
                    if(ds.timKiemTheoMaKH(makh)!=null)
                    {
                        ds.timKiemTheoMaKH(makh).xuat();
                    }
                    else
                    {
                        System.out.println(" mã khách trên hiện không có trong danh sách khách hàng ! ");
                    }
                    break;
                case 6:
                    QLBH.dskhachhang=Arrays.copyOf(ds.dskhachhang,ds.dskhachhang.length);
                    return ;
                default:
                    System.out.print("nhập sai vui lòng nhập lại !\n");
                    break;




            }

        }
    }

    public void QLNV()
    {
        Scanner scanner=new Scanner(System.in);
        String manv;
        DSNV ds=new DSNV();
        ds.dsnhanvien=Arrays.copyOf(QLBH.dsnhanvien, QLBH.dsnhanvien.length);
        ds.n= QLBH.dsnhanvien.length;
        while(true)
        {
            System.out.println("\n--- Menu Quản Lí Nhân viên ---");
            System.out.println("1. Hiển thị danh sách Nhân Viên");
            System.out.println("2. Thêm Nhân viên ");
            System.out.println("3. xóa  Nhân viên ");
            System.out.println("4. Sửa thông tin  Nhân viên");
            System.out.println("5. tìm kiếm  Nhân viên ");
            System.out.println("6. thoát");
            System.out.print("Chọn: ");
            int option=scanner.nextInt();
            scanner.nextLine();
            switch (option)
            {
                case 1:
                    ds.xuat();
                    break;
                case 2 :
                    ds.them();
                    QLBH.dsnhanvien=Arrays.copyOf(ds.dsnhanvien,dsnhanvien.length);
                    break;
                case 3 :
                    System.out.println("nhập mã nhân viên muốn xóa : ");
                    manv=scanner.nextLine();
                    ds.xoa(manv);
                    QLBH.dsnhanvien=Arrays.copyOf(ds.dsnhanvien,dsnhanvien.length);
                    break;
                case 4 :
                    System.out.println("nhập mã nhân viên muốn sửa : ");
                    manv=scanner.nextLine();
                    ds.sua(manv);
                    QLBH.dsnhanvien=Arrays.copyOf(ds.dsnhanvien,dsnhanvien.length);
                    break;
                case 5:
                    System.out.println("nhập mã nhân viên muốn tìm : ");
                    manv=scanner.nextLine();

                    ds.timKiemNhanVienTheoMa(manv).xuat();
                    break;
                case 6 :
                    return;
                default:
                    System.out.println(" nhập sai vui lòng nhập lại !");
            }

        }



    }
    public void QLNCC()
    {
        String mancc;
        Scanner scanner=new Scanner(System.in);
        DSNCC ds=new DSNCC();
        ds.dsnhacungcap=Arrays.copyOf(QLBH.dsnhacungcap, QLBH.dsnhacungcap.length);
        ds.n= QLBH.dsnhacungcap.length;
        while(true)
        {
            System.out.println("\n--- Menu Quản Lí Nhà Cung Cấp ---");
            System.out.println("1. Hiển thị danh sách Nhà Cung Cấp");
            System.out.println("2. Thêm Nhà Cung Cấp ");
            System.out.println("3. xóa  Nhà Cung Cấp ");
            System.out.println("4. Sửa thông tin  Nhà Cung Cấp");
            System.out.println("5. tìm kiếm  Nhà Cung Cấp ");
            System.out.println("6. thoát");
            System.out.print("Chọn: ");
            int option=scanner.nextInt();
            scanner.nextLine();
            switch (option)
            {
                case 1:
                    ds.xuat();
                    break;
                case 2:
                    ds.them();
                    QLBH.dsnhacungcap=Arrays.copyOf(ds.dsnhacungcap,ds.dsnhacungcap.length);

                    break;
                case 3 :
                    System.out.println(" nhập mã nhà cung cấp muốn xóa : ");
                    mancc=scanner.nextLine();
                    ds.xoa(mancc);
                    QLBH.dsnhacungcap=Arrays.copyOf(ds.dsnhacungcap,ds.dsnhacungcap.length);

                    break;
                case 4 :
                    System.out.println(" nhập mã nhà cung cấp muốn sửa : ");
                    mancc=scanner.nextLine();
                    ds.sua(mancc);
                    QLBH.dsnhacungcap=Arrays.copyOf(ds.dsnhacungcap,ds.dsnhacungcap.length);
                    break;
                case 5 :
                    System.out.println("nhập mã nhà cung cấp muốn tìm kếm : ");

                    break;
                case 6 :
                    ds.dsnhacungcap=Arrays.copyOf(QLBH.dsnhacungcap, QLBH.dsnhacungcap.length);
                    return ;
                default:
                    System.out.println(" nhập sai vui lòng nhập lại ");
            }

        }


    }

public void QLTH()
{
    DSTH ds=new DSTH();
    ds.dsthuonghieu=Arrays.copyOf(QLBH.dsthuonghieu,QLBH.dsthuonghieu.length);
    ds.n=QLBH.dsthuonghieu.length;
    String math;
    Scanner scanner=new Scanner(System.in);
    while(true)
    {
        System.out.println("\n--- Menu Quản Lí Thương Hiệu ---");
        System.out.println("1. Hiển thị danh sách Thương Hiệu");
        System.out.println("2. Thêm Thương Hiệu ");
        System.out.println("3. xóa Thương Hiệu ");
        System.out.println("4. Sửa thông tin Thương Hiệu");
        System.out.println("5. tìm kiếm Thương Hiệu ");
        System.out.println("6. thoát");
        System.out.print("Chọn: ");
        int option=scanner.nextInt();
        scanner.nextLine();
        switch (option)
        {
            case 1:
                ds.xuat();
                break;
            case 2 :
                ds.them();
                QLBH.dsthuonghieu=Arrays.copyOf(ds.dsthuonghieu,ds.dsthuonghieu.length);
                break;
            case 3 :
                System.out.println(" mã thương hiệu muốn xóa : ");
                math=scanner.nextLine();
                ds.xoa(math);
                QLBH.dsthuonghieu=Arrays.copyOf(ds.dsthuonghieu,ds.dsthuonghieu.length);
                break;
            case 4:
                System.out.println(" mã thương hiệu muốn sửa : ");
                math=scanner.nextLine();
                ds.sua(math);
                QLBH.dsthuonghieu=Arrays.copyOf(ds.dsthuonghieu,ds.dsthuonghieu.length);
                break;
            case 5:
                System.out.println(" mã thương hiệu muốn tìm : ");
                math=scanner.nextLine();
                ds.timkiemtheomathuonghieu(math).xuat();

                break;
            case 6:
                return;
            default:
                System.out.println(" nhập sai vui lòng nhập lại ! ");


        }

    }

}




    public void main(String[] args) {
        // khởi tạo các danh sách
        DSQuat danhSachQuat = new DSQuat();
        DSTH danhSachThuongHieu = new DSTH();
        DSPhieuNhap danhSachPhieuNhap = new DSPhieuNhap();
        DSNV danhSachNhanVien = new DSNV();
        DSNCC danhSachNhaCungCap = new DSNCC();
        DSKH danhSachKhachHang = new DSKH();
        DSHoaDon danhSachHoaDon = new DSHoaDon();
        DSChiTietPhieuNhap danhSachChiTietPhieuNhap = new DSChiTietPhieuNhap();
        DSChiTietHoaDon danhsachchitiethoadon = new DSChiTietHoaDon();

        // đọc file vào các danh sách
        danhSachQuat.docfile();
        danhSachThuongHieu.docfile();
        danhSachPhieuNhap.docfile();
        danhSachNhanVien.docfile();
        danhSachNhaCungCap.docfile();
        danhSachKhachHang.docfile();
        danhSachHoaDon.docfile();
        danhSachChiTietPhieuNhap.docfile();
        danhsachchitiethoadon.docfile();

        // ghi dữ liệu để demo cho cô vào mảng static( mỗi lần quản li không được đọc file qua' nhiều)
        dsquat=Arrays.copyOf(danhSachQuat.dsquat,danhSachQuat.dsquat.length);
        dskhachhang=Arrays.copyOf(danhSachKhachHang.dskhachhang,danhSachKhachHang.dskhachhang.length);
        dsnhanvien=Arrays.copyOf(danhSachNhanVien.dsnhanvien,danhSachNhanVien.dsnhanvien.length);
        dsnhacungcap=Arrays.copyOf(danhSachNhaCungCap.dsnhacungcap,danhSachNhaCungCap.dsnhacungcap.length);
        dshoadon=Arrays.copyOf(danhSachHoaDon.dshoadon,danhSachHoaDon.dshoadon.length);
        dschitiethoadon=Arrays.copyOf(danhsachchitiethoadon.dschitiethoadon,danhsachchitiethoadon.dschitiethoadon.length);
        dschitietphieunhap=Arrays.copyOf(danhSachChiTietPhieuNhap.dschitietphieunhap,danhSachChiTietPhieuNhap.dschitietphieunhap.length);
        dsphieunhap=Arrays.copyOf(danhSachPhieuNhap.dsphieunhap,danhSachPhieuNhap.dsphieunhap.length);
        dsthuonghieu=Arrays.copyOf(danhSachThuongHieu.dsthuonghieu,danhSachThuongHieu.dsthuonghieu.length);


        QLSP();




/*
        while (true) {
            System.out.println("\n--- Menu Tổng Quản Lý ---");
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý hóa đơn");
            System.out.println("3. Quản lý khách hàng");
            System.out.println("4. Quản lý nhân viên");
            System.out.println("5. Quản lý phiếu nhập");
            System.out.println("6. Quản lý nhà cung cấp");
            System.out.println("7. Quản lý thương hiệu");
            System.out.println("8. Thống Kê ");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 :
                    QLSP();
                    break;
                case 2:
                    QLHD();
                    break;
                case 3 :
                    QLKH();
                    break;
                case 4:
                    QLNV();
                    break;
                case 5 :
                    QLPN();
                    break;
                case 6 :
                    QLNCC();
                    break;
                case 7:
                    QLTH();

                case 8 :
                    thongkenangcao();
                    break;
                default:
                    return ;


            }


        }
        */




    }
}



