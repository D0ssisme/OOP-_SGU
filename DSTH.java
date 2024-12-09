import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class DSTH {
    public int n;
    public ThuongHieu[] dsthuonghieu = new ThuongHieu[1];

    public DSTH() {

    }

    public DSTH(DSTH temp) {
        this.n = temp.n;
        this.dsthuonghieu = temp.dsthuonghieu;

    }

    public DSTH(int n, ThuongHieu[] temp) {
        this.n = n;
        this.dsthuonghieu = temp;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập số lượng thương hiệu : ");
        n = scanner.nextInt();
        dsthuonghieu = new ThuongHieu[n];
        for (int i = 0; i < n; i++) {
            dsthuonghieu[i] = new ThuongHieu();
            dsthuonghieu[i].nhap();
        }

    }

    public void xuat() {
        if (n == 0) {
            System.out.print("danh sach hien dang rong !");
            return;
        }

        for (int i = 0; i < n; i++) {
            dsthuonghieu[i].xuat();
        }

    }

    public void docfile() {
        int i = 0;
        String filePath = "thuonghieu.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line = reader.readLine();
            this.dsthuonghieu = new ThuongHieu[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                this.dsthuonghieu[i] = new ThuongHieu();
                this.dsthuonghieu[i].setMathuonghieu(data[0]);
                this.dsthuonghieu[i].setTenThuongHieu(data[1]);
                this.dsthuonghieu[i].setEmail(data[2]);
                this.dsthuonghieu[i].setSDT(data[3]);
                this.dsthuonghieu[i].setDiaChiTruSo((data[4]));

                i++;
            }

            System.out.println("Đã đọc xong!");
            this.n = i;

        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
    }

    public boolean checkmath(String math) {
        DSTH ds = new DSTH();
        ds.dsthuonghieu = Arrays.copyOf(QLBH.dsthuonghieu, QLBH.dsthuonghieu.length);
        for (ThuongHieu q : dsthuonghieu) {
            if (q.getMaThuongHieu().equals(math)) {
                return false;
            }
        }
        return true;
    }

    public void them() {
        dsthuonghieu = Arrays.copyOf(dsthuonghieu, dsthuonghieu.length + 1);
        dsthuonghieu[n] = new ThuongHieu();
        dsthuonghieu[n].nhap();
        n++;
    }

    public void them(ThuongHieu temp) {
        dsthuonghieu = Arrays.copyOf(dsthuonghieu, dsthuonghieu.length + 1);
        dsthuonghieu[n] = new ThuongHieu(temp);
        n++;
    }

    public void xoa(String mathuonghieu) {
        for (int i = 0; i < n; i++) {
            if (dsthuonghieu[i].getMaThuongHieu().equals(mathuonghieu)) {
                for (int j = i; j < n - 1; j++) {
                    dsthuonghieu[j] = dsthuonghieu[j + 1];

                }
                dsthuonghieu = Arrays.copyOf(dsthuonghieu, dsthuonghieu.length - 1);
                n--;
                return;
            }
        }
        System.out.print("không tìm thấy mã thương hiệu nào như trên !");

    }

    public void sua(String mathuonghieu) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            if (dsthuonghieu[i].getMaThuongHieu().equals(mathuonghieu)) {
                System.out.print("nhập vào mã thương hiệu mới : ");
                String mathuonghieunew = scanner.nextLine();
                dsthuonghieu[i].setMathuonghieu(mathuonghieunew);
                return;

            }

        }

    }

    public ThuongHieu timkiemtheomathuonghieu(String mathuonghieu) {
        for (int i = 0; i < n; i++) {
            if (dsthuonghieu[i].getMaThuongHieu().equals(mathuonghieu)) {
                return dsthuonghieu[i];
            }
        }
        return null;
    }
}
