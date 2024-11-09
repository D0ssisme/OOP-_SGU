import java.util.Scanner;
import java.util.Arrays;

public class DSQuat {
    private Quat[] ds = new Quat[1];
    private int n;

    public DSQuat() {

    }

    public DSQuat(int n, Quat[] temp) {
        this.n = n;
        this.ds = temp;
    }

    public DSQuat(DSQuat temp) {
        this.ds = temp.ds;
        this.n = temp.n;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap so luong quat : ");
        n = scanner.nextInt();
        ds = new Quat[n];
        for (int i = 0; i < n; i++) {
            int x;
            System.out.print("nhap 1 de nhap quat dien nhap 2 de nhap quat hoi nuoc : ");
            x = scanner.nextInt();

            if (x == 1) {
                ds[i] = new QuatDien();
            } else if (x == 2) {

                ds[i] = new QuatHoiNuoc();
            } else {
                System.out.print("nhập không hợp lệ vui lòng nhập lại  !");
                i--;
                continue;
            }
            ds[i].nhap();
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
                ds[i].xuat();
            }

        }
    }

    public void them(int option) {

        ds = Arrays.copyOf(ds, ds.length + 1);

        if (option == 1) {
            ds[n] = new QuatDien();
        } else if (option == 2) {
            ds[n] = new QuatHoiNuoc();
        } else {
            System.out.print("vui lòng truyền vào tham số 1 để thêm quạt điện hoặc 2 để thêm quạt hơi nước !");
            ds = Arrays.copyOf(ds, ds.length - 1);
            return;

        }
        ds[n].nhap();
        n++;

    }

    public void them(Quat temp) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        if (temp instanceof QuatDien) {
            ds[n] = new QuatDien((QuatDien) temp);
        } else if (temp instanceof QuatHoiNuoc) {
            ds[n] = new QuatHoiNuoc((QuatHoiNuoc) temp);
        }

        n++;

    }

    public Quat timkiem(String masp) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSP().equals(masp)) {
                return ds[i];
            }
        }
        return null;
    }

    public void timkiemtheoducgtich(String dungtich) {
        if (n == 0) {
            System.out.print("danh sach hien dang rong !");
            return;
        }
        int dem = 1;
        for (int i = 0; i < n; i++) {
            if (ds[i] instanceof QuatHoiNuoc) {
                if (((QuatHoiNuoc) ds[i]).getDungTich().equals(dungtich)) {
                    if (dem == 1) {
                        System.out.print("quat co dung tich " + dungtich + " la : ");
                        dem++;

                    }
                    System.out.print(ds[i].getMaSP() + ',');

                }
            }
            if (dem != 1) {
                return;
            }

        }
        System.out.print("hiện trong danh sách không có quạt nào có dung tích như trên !");

    }

    public void xoa(String masp) {
        for (int i = 0; i < n; i++) {
            if (ds[i].getMaSP().equals(masp)) {
                for (int j = i; j < n - 1; j++) {
                    ds[j] = ds[j + 1];

                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                n--;
                return;
            }
        }
        System.out.print("không thể tìm thấy mã sản phẩm trên !");

    }

    public void sua(String oldmasp, String newmasp) {
        if (timkiem(oldmasp) != null) {
            timkiem(oldmasp).setMaSP(newmasp);
        } else {
            System.out.print("không tìm thấy mã sản phẩm trên !");
        }

    }

}
