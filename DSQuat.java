import java.util.Scanner;
import java.util.Arrays;

public  class DSQuat {
    public  static Quat[] danhsachquat = new Quat[1];
    public  int n;

    public DSQuat() {
    }

    public DSQuat(int n, Quat[] temp) {
        this.n = n;
        this.danhsachquat = temp;
    }

    public DSQuat(DSQuat temp) {
        this.danhsachquat = temp.danhsachquat;
        this.n = temp.n;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập số lượng quạt : ");
        n = scanner.nextInt();
        danhsachquat = new Quat[n];
        for (int i = 0; i < n; i++) {
            int x;
            System.out.print("nhập 1 để thêm quạt điện 2 để thêm quạt hơi nước : ");
            x = scanner.nextInt();

            if (x == 1) {
                danhsachquat[i] = new QuatDien();
            } else if (x == 2) {

                danhsachquat[i] = new QuatHoiNuoc();
            } else {
                System.out.print("nhập không hợp lệ vui lòng nhập lại  !");
                i--;
                continue;
            }
            danhsachquat[i].nhap();
        }

    }

    public void xuat() {
        if (n == 0) {
            System.out.print("Danh Sách hiện đang rỗng  !");
            return;
        } else {
            System.out.printf("%-14s %-19s %-17s %-10s %-10.2s %-15s %-13s %-13s %-15s %-15s%-15s %-15s\n",
                    "Mã SP", "Tên SP", "Ngày Sản Xuất", "Số Lượng", "Giá", "Ma Thương Hiệu", "Trọng Lượng",
                    "Công Suất,",
                    "số cánh quạt", "chế độ gió", "dung tích", "chế độ phun");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < n; i++) {
                danhsachquat[i].xuat();
            }

        }
    }

    public void them(int option) {

        danhsachquat = Arrays.copyOf(danhsachquat, danhsachquat.length + 1);

        if (option == 1) {
            danhsachquat[n] = new QuatDien();
        } else if (option == 2) {
            danhsachquat[n] = new QuatHoiNuoc();
        } else {
            System.out.print("vui lòng truyền vào tham số 1 để thêm quạt điện hoặc 2 để thêm quạt hơi nước !");
            danhsachquat = Arrays.copyOf(danhsachquat, danhsachquat.length - 1);
            return;

        }
        danhsachquat[n].nhap();

        n++;

    }

    public void them(Quat temp) {
        danhsachquat = Arrays.copyOf(danhsachquat, danhsachquat.length + 1);
        if (temp instanceof QuatDien) {
            danhsachquat[n] = new QuatDien((QuatDien) temp);
        } else if (temp instanceof QuatHoiNuoc) {
            danhsachquat[n] = new QuatHoiNuoc((QuatHoiNuoc) temp);
        }

        n++;

    }

    public Quat timKiemTheoMaSP(String masp) {
        for (int i = 0; i < n; i++) {
            if (danhsachquat[i].getMaSP().equals(masp)) {
                return danhsachquat[i];
            }
        }
        return null;
    }
    public void timKiemTheoCheDoPhun(String chedophun)
    {
        if(n ==0)
        {
            System.out.print("danh sách hiện đang rỗng !");
            return;
        }
        int dem=1;
        for(int i = 0; i< n; i++)
        {
            if(danhsachquat[i] instanceof QuatHoiNuoc)
            {
                if(((QuatHoiNuoc) danhsachquat[i]).getCheDoPhun().equals(chedophun))
                {
                    if(dem==1)
                    {
                        System.out.print("quạt hơi nước có chế độ phun " + chedophun + " là : ");
                        dem++;
                    }
                    System.out.print(danhsachquat[i].getMaSP() + ',');

                }
            }
        }
        if(dem==1)
        {
            System.out.print("hiện trong danh sách không có quạt nào có dung tích như trên !");
        }
    }

    public void timKiemTheoDungTich(String dungtich) {
        if (n == 0) {
            System.out.print("danh sách hiện đang rỗng!");
            return;
        }
        int dem = 1;
        for (int i = 0; i < n; i++) {
            if (danhsachquat[i] instanceof QuatHoiNuoc) {
                if (((QuatHoiNuoc) danhsachquat[i]).getDungTich().equals(dungtich)) {
                    if (dem == 1) {
                        System.out.print("quạt hơi nước có dung tích" + dungtich + " là : ");
                        dem++;

                    }
                    System.out.print(danhsachquat[i].getMaSP() + ',');

                }
            }

        }
        if (dem != 1) {
            return;
        }
        System.out.print("hiện trong danh sách không có quạt nào có dung tích như trên !");

    }
    public void timKiemTheoSoCanhQuat(int socanhquat)
    {
        if(n ==0) {
            System.out.print("danh sách hiện đang rỗng !");
            return;
        }
        int dem=1;
        for(int i = 0; i< n; i++)
        {
            if(danhsachquat[i] instanceof QuatDien)
            {
               if(((QuatDien) danhsachquat[i]).getSoCanhQuat()==socanhquat)
               {
                   if(dem==1)
                   {
                       System.out.print("quạt điện có "+socanhquat+"cánh quạt là :");
                       dem++;
                   }
                   System.out.print(danhsachquat[i].getMaSP()+',');
               }
            }
        }
        if(dem==1)
        {
            System.out.print("hiện trong danh sách không có quạt nào có số cánh quạt như trên ");
        }
    }

    public void xoaTheoMaSP(String masp) {
        for (int i = 0; i < n; i++) {
            if (danhsachquat[i].getMaSP().equals(masp)) {
                for (int j = i; j < n - 1; j++) {
                    danhsachquat[j] = danhsachquat[j + 1];

                }
                danhsachquat = Arrays.copyOf(danhsachquat, danhsachquat.length - 1);
                n--;

            }
        }

    }
    public void xoaTheoCheDoPhun(String chedophun)
    {
        for(int i = 0; i< n; i++)
        {
            if(danhsachquat[i] instanceof QuatHoiNuoc)
            {
                if(((QuatHoiNuoc) danhsachquat[i]).getCheDoPhun().equals(chedophun))
                {
                    for(int j = i; j< n -1; j++)
                    {
                        danhsachquat[j]= danhsachquat[j+1];
                    }
                    danhsachquat =Arrays.copyOf(danhsachquat, danhsachquat.length-1);
                    n--;
                }
            }
        }
    }

    public void xoaTheoDungTich(String dungtich)
    {
        for(int i = 0; i< n; i++)
        {
            if(danhsachquat[i] instanceof QuatHoiNuoc)
            {
                if(((QuatHoiNuoc) danhsachquat[i]).getDungTich().equals(dungtich))
                {
                    for(int j = i; j< n -1; j++)
                    {
                        danhsachquat[j]= danhsachquat[j+1];
                    }
                    danhsachquat =Arrays.copyOf(danhsachquat, danhsachquat.length-1);
                    n--;
                }

            }
        }

    }
    public void xoaTheoSoCanhQuat(int socanhquat)
    {
        for(int i = 0; i< n; i++)
        {
            if(danhsachquat[i] instanceof QuatDien)
            {
                if(((QuatDien) danhsachquat[i]).getSoCanhQuat()==socanhquat)
                {
                    for(int j = i; j< n -1; j++)
                    {
                        danhsachquat[j]= danhsachquat[j+1];
                    }
                    danhsachquat =Arrays.copyOf(danhsachquat, danhsachquat.length-1);
                    n--;
                }
            }
        }

    }
    public void xoaTheoDoDaiCanhQuat(int dodaicanhquat)
    {
        for(int i = 0; i< n; i++)
        {
            if(danhsachquat[i] instanceof QuatDien)
            {
                if(((QuatDien) danhsachquat[i]).getDoDaiCanhQuat()==dodaicanhquat)
                {
                    for(int j = i; j< n -1; j++)
                    {
                        danhsachquat[j]= danhsachquat[j+1];

                    }
                    danhsachquat =Arrays.copyOf(danhsachquat, danhsachquat.length-1);
                    n--;
                }
            }
        }
    }


    public void sua(String oldmasp, String newmasp) {
        if (timKiemTheoMaSP(oldmasp) != null) {
            timKiemTheoMaSP(oldmasp).setMaSP(newmasp);
        } else {
            System.out.print("không tìm thấy mã sản phẩm trên !");
        }


    }
    public void thongKeSLQuatDien()
    {
        if(n ==0)
        {
            System.out.print("hiện tại danh sách rỗng !");
            return;
        }
        int dem=0;
        for(int i = 0; i< n; i++)
        {
            if(danhsachquat[i] instanceof QuatDien)
            {
                dem++;
            }
        }
        System.out.print("số lượng quạt điện hiện đang có trong danh sách là : "+dem);
    }
    public void thongKeSLQuatHoiNuoc()
    {
        if(n ==0)
        {
            System.out.print("hiện tại danh sách rỗng !");
            return;
        }
        int dem=0;
        for(int i = 0; i< n; i++)
        {
            if(danhsachquat[i] instanceof QuatHoiNuoc)
            {
                dem++;
            }
        }
        System.out.print("số lượng quạt hơi nước hiện đang có trong danh sách là : "+dem);
    }
    public void timKienQuatTheoMaThuongHieuVaGia(String mathuonghieu,double gia)
    {
        for(Quat q:danhsachquat)
        {
            if(q.getGia()==gia&&q.getMaThuongHieu().equals(mathuonghieu))
            {
                q.xuat();
                System.out.println();
            }
        }
    }
    public void timKiemTheoSoLuongVaGia(int soluong,double gia)
    {
        for(Quat q:danhsachquat)
        {
            if(q.getSoLuong()==soluong&&q.getGia()==gia)
            {
                q.xuat();
            }
        }
    }
    public void thongKeTongTienHoaDonTheoSanPham() {
        double tong=0;
        System.out.println("SẢN PHẨM ---- TỔNG TIỀN HÓA ĐƠN");
        for (Quat q : danhsachquat) {
            for (ChiTietHoaDon temp : DSChiTietHoaDon.dschitiethoadon) {
                if(q.getMaSP().equals(temp.getMasp()))
                {
                    tong=tong+temp.getThanhTien();
                }



            }
            System.out.println(q.getTenSP()+"----"+tong);
            tong=0;

        }
    }


}
