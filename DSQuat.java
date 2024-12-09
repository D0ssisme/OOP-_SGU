
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;



public  class DSQuat implements DanhSach{
    public   Quat[] dsquat = new Quat[1];
    public   int n;


    public DSQuat() {
    }

    public DSQuat(int n, Quat[] temp) {
        this.n = n;
        this.dsquat = temp;
    }

    public DSQuat(DSQuat temp) {
        this.dsquat = temp.dsquat;
        this.n = temp.n;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập số lượng quạt : ");
        n = scanner.nextInt();
        dsquat = new Quat[n];
        for (int i = 0; i < n; i++) {
            int x;
            System.out.print("nhập 1 để thêm quạt điện 2 để thêm quạt hơi nước :::: ");
            x = scanner.nextInt();

            if (x == 1) {
                dsquat[i] = new QuatDien();
            } else if (x == 2) {

                dsquat[i] = new QuatHoiNuoc();
            } else {
                System.out.print("nhập không hợp lệ vui lòng nhập lại  !");
                i--;
                continue;
            }
            dsquat[i].nhap();
        }

    }

    public void xuat() {
        if (n == 0) {
            System.out.print("Danh Sách hiện đang rỗng  !");
            return;
        } else {
            System.out.printf("%-14s %-19s %-17s %-10s %-10.2s %-15s %-13s %-13s %-15s %-15s%-15s %-15s\n",
                    "Mã SP", "Tên SP", "Ngày Sản Xuất", "Số Lượng", "Gia' ", "Mã Thương Hiệu", "Trọng Lượng",
                    "Công Suất,",
                    "số cánh quạt", "độ dài cánh quạt ", "dung tích", "chế độ phun");
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < n; i++) {
                dsquat[i].xuat();
            }

        }
    }

    public boolean checkmasp(String masp)
    {
        dsquat=Arrays.copyOf(QLBH.dsquat,QLBH.dsquat.length);
        n=QLBH.dsquat.length;
        for(Quat q : dsquat)
        {
            if(masp.equals(q.getMaSP()))
            {
                return false;
            }
        }
        return true;

    }





    public void docfile() {
        int i = 0;
        String filePath = "quat.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dsquat = new Quat[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("quatdien")) {
                    this.dsquat[i] = new QuatDien();
                    this.dsquat[i].setMaSP(data[1]);
                    this.dsquat[i].setTenSP(data[2]);
                    this.dsquat[i].setNgaySanXuat(data[3]);
                    this.dsquat[i].setSoLuong(Integer.parseInt(data[4]));
                    this.dsquat[i].setGia(Double.parseDouble(data[5]));
                    this.dsquat[i].setMathuonghieu(data[6]);
                    this.dsquat[i].setTrongLuong(data[7]);
                    this.dsquat[i].setCongSuat(data[8]);
                    ((QuatDien) this.dsquat[i]).setSoCanhQuat(Integer.parseInt(data[9]));
                    ((QuatDien) this.dsquat[i]).setDoDaiCanhQuat(data[10]);
                } else if (data[0].equals("quathoinuoc")) {
                    this.dsquat[i] = new QuatHoiNuoc();
                    this.dsquat[i].setMaSP(data[1]);
                    this.dsquat[i].setTenSP(data[2]);
                    this.dsquat[i].setNgaySanXuat(data[3]);
                    this.dsquat[i].setSoLuong(Integer.parseInt(data[4]));
                    this.dsquat[i].setGia(Double.parseDouble(data[5]));
                    this.dsquat[i].setMathuonghieu(data[6]);
                    this.dsquat[i].setTrongLuong(data[7]);
                    this.dsquat[i].setCongSuat(data[8]);
                    ((QuatHoiNuoc) this.dsquat[i]).setDungTich(data[9]);
                    ((QuatHoiNuoc) this.dsquat[i]).setCheDoPhun(data[10]);
                }
                i++;
            }

            System.out.println("Đã đọc thành công !");
            this.n=i;


        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
    }



    public boolean checksoluongtonkho(String masp,int soluongbanra)
    {


        if(timKiemTheoMaSP(masp).getSoLuong()>=soluongbanra) {
            return true;
        }

        return false;

    }




    public void them() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhập 1 thêm quạt điện 2 thêm quạt hơi nước :");
        int option=scanner.nextInt();
        dsquat = Arrays.copyOf(dsquat, dsquat.length + 1);

        if (option == 1) {
            dsquat[n] = new QuatDien();
        } else if (option == 2) {
            dsquat[n] = new QuatHoiNuoc();
        } else {
            System.out.print("vui lòng truyền vào tham số 1 để thêm quạt điện hoặc 2 để thêm quạt hơi nước !");
            dsquat = Arrays.copyOf(dsquat, dsquat.length - 1);
            return;

        }
        dsquat[n].nhap();

        n++;

    }

    public void them(Quat temp) {
        if(checkmasp(temp.getMaSP())) {
            dsquat = Arrays.copyOf(dsquat, dsquat.length + 1);
            if (temp instanceof QuatDien) {
                dsquat[n] = new QuatDien((QuatDien) temp);
            } else if (temp instanceof QuatHoiNuoc) {
                dsquat[n] = new QuatHoiNuoc((QuatHoiNuoc) temp);
            }
            n++;
        }
        else
        {
            System.out.print("mã sản phẩm trên đã tồn tại !  ");

        }

    }

    public Quat timKiemTheoMaSP(String masp) {
        for (int i = 0; i < n; i++) {
            if (dsquat[i].getMaSP().equals(masp)) {
                return dsquat[i];
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

        for(int i = 0; i< n; i++)
        {
            if(dsquat[i] instanceof QuatHoiNuoc)
            {
                if(((QuatHoiNuoc) dsquat[i]).getCheDoPhun().equals(chedophun))
                {

                    dsquat[i].xuat();

                }
            }
        }

    }


    public void timKiemTheoSoCanhQuat(int socanhquat)
    {
        if(n ==0) {
            System.out.print("danh sách hiện đang rỗng !");
            return;
        }

        for(int i = 0; i< n; i++)
        {
            if(dsquat[i] instanceof QuatDien)
            {
               if(((QuatDien) dsquat[i]).getSoCanhQuat()==socanhquat)
               {
                 dsquat[i].xuat();
               }
            }
        }

    }
    public void timKiemTheoNSX(String thoidiema,String thoidiemb)
    {
        int dem=0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {

            Date star = dateFormat.parse(thoidiema);
            Date end = dateFormat.parse(thoidiemb);
            System.out.printf("\nSản phẩm có ngày sản xuất từ %s đến %s:\n", thoidiema, thoidiemb);


            for (Quat q : dsquat) {
                Date nsx = dateFormat.parse(q.getNXS());  // Sử dụng dateFormat để parse
                if (!nsx.before(star) && !nsx.after(end)) {
                    if(dem==0)
                    {
                        System.out.printf("%-14s %-19s %-17s %-10s %-10s %-15s %-13s %-13s %-15s %-15s%-15s %-15s\n",
                                "Mã SP", "Tên SP", "Ngày Sản Xuất", "Số Lượng", "Giá", "Mã Thương Hiệu", "Trọng Lượng",
                                "Công Suất,",
                                "số cánh quạt", "độ dài cánh quạt ", "dung tích", "chế độ phun");
                    }
                    q.xuat();
                    dem++;
                }
            }
        } catch (ParseException e) {
            System.out.println("Lỗi định dạng ngày tháng! Vui lòng nhập theo định dạng dd/MM/yyyy.");
        }

    }
    public void timKiemTheoTenSp(String tensp)
    {
        for(Quat q :dsquat)
        {
            if(q.getTenSP().equals(tensp))
            {

                q.xuat();
            }
        }
    }
    public void timKiemTheoMaThuongHieu(String math)
    {
        for(Quat q:dsquat)
        {
            if(q.getMaThuongHieu().equals(math))
            {
                q.xuat();
            }
        }
    }
    public void menuTimKiem()
    {
        Scanner scanner=new Scanner(System.in);
        DSQuat ds=new DSQuat();
        ds.dsquat=Arrays.copyOf(QLBH.dsquat,QLBH.dsquat.length);
        ds.n=QLBH.dsquat.length;
        int option;
        while(true) {

            System.out.println("----------MENU TÌM KIẾM----------");
            System.out.println("1.tìm kiếm theo mã sản phẩm");
            System.out.println("2.tìm kiếm theo tên sản phẩm");
            System.out.println("3.tìm kiếm theo ngày sản xuất");
            System.out.println("4.tìm kiếm theo mã thương hiệu");
            System.out.println("5.tìm kiếm theo số lượng cánh quạt ");
            System.out.println("6.tìm kiếm theo chế độ phun");
            System.out.println("7.thoat");
            System.out.print("nhập lựa chọn :");
            option=scanner.nextInt();
            scanner.nextLine();
            switch (option)
            {
                case 1:
                    System.out.println("nhap ma san pham muon tim :");
                    String masp=scanner.nextLine();
                    ds.timKiemTheoMaSP(masp);
                    break;
                case 2:
                    System.out.println("nhap ten san pham :");
                    String tensp=scanner.nextLine();
                    ds.timKiemTheoTenSp(tensp);
                    break;
                case 3:
                    System.out.println("nhap thoi diem bat dau :");
                    String star=scanner.nextLine();
                    System.out.println("nhap thoi diem ket thuc :");
                    String end=scanner.nextLine();
                    ds.timKiemTheoNSX(star,end);
                    break;
                case 4:
                    System.out.println("nhap ma thuong hieu muon tim :");
                    String math=scanner.nextLine();
                    ds.timKiemTheoMaThuongHieu(math);
                    break;
                case 5:
                    System.out.println("nhap so luong canh quat :");
                    int soluongcanhquat=scanner.nextInt();
                    ds.timKiemTheoSoCanhQuat(soluongcanhquat);
                    break;
                case 6:
                    System.out.println("nhap che do phun :");
                    String chedophun=scanner.nextLine();
                    ds.timKiemTheoCheDoPhun(chedophun);
                    break;

                case 7:
                    return ;
                default:
                    System.out.println("nhap sai vui long nhap lai !");


            }
        }


    }

    public void xoa(String masp) {
        for (int i = 0; i < n; i++) {
            if (dsquat[i].getMaSP().equals(masp)) {
                for (int j = i; j < n - 1; j++) {
                    dsquat[j] = dsquat[j + 1];

                }
                dsquat = Arrays.copyOf(dsquat, dsquat.length - 1);
                n--;
                return;

            }
        }
        System.out.println( " không thấy mã sản phẩm trên ! ");

    }



    public void sua(String masp) {

        int option;
        Scanner scanner=new Scanner(System.in);
        for(Quat q :dsquat)
        {
            if(q.getMaSP().equals(masp))
            {
                System.out.println("nhập 1 - sửa mã sản phẩm ");
                System.out.println("nhập 2 - sửa tên sản phẩm ");
                System.out.println("nhập 3 - sửa ngày sản sản xuất ");
                System.out.println("nhập 4 - sửa số lượng ");
                System.out.println("nhập 5 - sửa giá ");
                System.out.println("nhập 6 - sửa  mã thương hiệu ");
                System.out.println("nhập 7 - sửa trọng lượng ");
                System.out.println("nhập 8 - sửa công suat  ");
                while(true) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                    if (option == 1) {
                        String maspnew;
                        do {
                            System.out.print("nhập mã sản phẩm : ");
                             maspnew = scanner.nextLine();

                            if(checkmasp(maspnew)==false)
                            {
                                System.out.println(" mã sản phẩm đã tồn tại vui lòng nhập lại ! ");
                            }
                        }
                        while(checkmasp(maspnew)==false);
                        q.setMaSP(maspnew);

                    } else if (option == 2) {
                        System.out.print("nhập tên sản phẩm : ");
                        String tenspnew = scanner.nextLine();
                        q.setTenSP(tenspnew);
                    } else if (option == 3) {
                        System.out.print(" nhập ngày sản xuất : ");
                        String ngaysanxuatnew = scanner.nextLine();
                        q.setNgaySanXuat(ngaysanxuatnew);
                    } else if (option == 4) {
                        System.out.print("nhập số lượng : ");
                        int soluongnew = scanner.nextInt();
                        scanner.nextLine();
                        q.setSoLuong(soluongnew);

                    } else if (option == 5) {
                        System.out.print(" nhập giá : ");
                        double gianew = scanner.nextDouble();
                        scanner.nextLine();
                        q.setGia(gianew);
                    } else if (option == 6) {
                        System.out.print("nhập mã thương hiệu ");
                        String mathuonghieunew = scanner.nextLine();
                        q.setMathuonghieu(mathuonghieunew);
                    } else if (option == 7) {
                        System.out.print("nhập trọng lượng : ");
                        String trongluongnew = scanner.nextLine();
                        q.setTrongLuong(trongluongnew);
                    } else if (option == 8) {
                        System.out.print("nhập công suất : ");
                        String congsuatnew = scanner.nextLine();
                        q.setCongSuat(congsuatnew);
                    } else {
                        System.out.print("vui lòng nhập vào đúng từ 1 -> 8 ");
                        continue;
                    }
                    return;
                }
            }

        }
        System.out.print("không tìm thấy mã sản phẩm trên ");

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
            if(dsquat[i] instanceof QuatDien)
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
            if(dsquat[i] instanceof QuatHoiNuoc)
            {
                dem++;
            }
        }
        System.out.print("số lượng quạt hơi nước hiện đang có trong danh sách là : "+dem);
    }


    public void thongKeTongTienHoaDonTheoSanPham() {
        DSChiTietHoaDon ds = new DSChiTietHoaDon();
        ds.dschitiethoadon = Arrays.copyOf(QLBH.dschitiethoadon, QLBH.dschitiethoadon.length);
        ds.n = QLBH.dschitiethoadon.length;

        System.out.println("=======================================================");
        System.out.printf("| %-30s | %-15s |\n", "Mã Sản Phẩm", "Tổng Tiền HD (VND)");
        System.out.println("=======================================================");

        double tong = 0;
        for (Quat q : dsquat) {
            for (ChiTietHoaDon temp : ds.dschitiethoadon) {
                if (q.getMaSP().equals(temp.getMasp())) {
                    tong += temp.getThanhTien();
                }
            }

            System.out.printf("| %-30s | %-18.0f |\n", q.getMaSP(), tong);
            tong = 0;
        }

        System.out.println("=======================================================");
    }




}
