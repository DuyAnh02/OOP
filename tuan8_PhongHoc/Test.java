package tuan8_PhongHoc;

import java.util.Scanner;

public class Test {
	static Scanner scanner;
	static PhongHocList DSPhongHoc = new PhongHocList();
	
	public static double nhapSoThuc(String s) {
		float b;
		System.out.println(s);
		Scanner sc = new Scanner(System.in);
		b = sc.nextFloat(); 
		return b;
	}
	public static String nhapChuoi(String s) {
		String str;
		System.out.println(s);
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		return str;
	}
	private static int nhapSoNguyen(String s) {
		int a;
		System.out.println(s);
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		return a;
	}
	public static void nhapCung()throws Exception{
		try {
			PhongHoc p1 = new PhongMayTinh("20", "10", 50.4, 20, 60); 
			PhongHoc p2 = new PhongMayTinh("30","40",60.4,30,50);
			PhongHoc p3 = new PhongLyThuyet("40","50",70.4,45,true);
			PhongHoc p4 = new PhongLyThuyet("50","60",90.4,43,false);
			PhongHoc p5 = new PhongThiNghiem("60","70",90.4,43,"Vi Sinh Vật",50,true);
			PhongHoc p6 = new PhongThiNghiem("70","80",90.4,43,"Vi Sinh Vật",40,false);
			
			DSPhongHoc.them(p1);
			DSPhongHoc.them(p2);
			DSPhongHoc.them(p3);
			DSPhongHoc.them(p4);
			DSPhongHoc.them(p5);
			DSPhongHoc.them(p6);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static PhongHoc nhapMem(){
		String maPhong,dayNha,chuyenNganh;
		double dienTich;
		int soBongDen,soMayTinh,sucChua;
		boolean mayChieu,bonRua;
		
		maPhong=nhapChuoi("Nhập mã phòng");
		dayNha=nhapChuoi("Nhập dãy nhà");
		dienTich=nhapSoThuc("Nhập diện tích");
		soBongDen=nhapSoNguyen("Nhập số bóng đèn");
		
		int loaip;
		loaip=nhapSoNguyen("Nhập loại phòng (1:Máy Tính,2:Lý Thuyết,3:Thí Nghiệm)");
		while (loaip < 1 || loaip > 3) {
	        System.out.println("Loại phòng không hợp lệ. Vui lòng nhập lại.");
	        loaip = nhapSoNguyen("Nhập loại phòng (1:Máy Tính,2:Lý Thuyết,3:Thí Nghiệm)");
	    }
		if(loaip==1) {
			soMayTinh=nhapSoNguyen("Nhập số máy tính ");
			return new PhongMayTinh(maPhong,dayNha,dienTich,soBongDen,soMayTinh);
		}else if(loaip==2) {
			int mayChieuInput = nhapSoNguyen("Phòng có máy chiếu không? (1: Có, 0: Không)");
		       while (mayChieuInput != 0 && mayChieuInput != 1) {
		           System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
		           mayChieuInput = nhapSoNguyen("Phòng có máy chiếu không? (1: Có, 0: Không)");
		       }
		       mayChieu = (mayChieuInput == 1);
		       return new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, mayChieu);
		}else {
			chuyenNganh=nhapChuoi("Nhập chuyên ngành");
			sucChua=nhapSoNguyen("Nhập sức chứa");
			int bonRuaInput = nhapSoNguyen("Phòng có bồn rửa không? (1: Có, 0: Không)");
		       while (bonRuaInput != 0 && bonRuaInput != 1) {
		           System.out.println("Giá trị không hợp lệ. Vui lòng nhập lại.");
		           bonRuaInput = nhapSoNguyen("Phòng có bồn rửa không? (1: Có, 0: Không)");
		       }
		       bonRua = (bonRuaInput == 1);
		       return new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen,chuyenNganh,sucChua,bonRua );
		}
		
	}
	public static void xoa(PhongHocList s) {
		try {
			String maHH = nhapChuoi("\nNhập mã phòng cần xóa: ");
			PhongHoc hh = DSPhongHoc.timKiem(maHH);
			if (hh != null) {
				String confirm = nhapChuoi("Bạn có chắc muốn xóa không (y/n): ");
				if (confirm.equalsIgnoreCase("y")) {
					DSPhongHoc.xoa(hh);
					System.out.println("\n Đã xóa thành công ");
				} else
					System.out.println("\nBạn không xóa ");
			} else
				throw new Exception("Không tồn tại hh này.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void sua(PhongHocList s) throws Exception {
		try {
			String maHH = nhapChuoi("Nhập mã phòng cần sửa: ");
			PhongHoc hh = DSPhongHoc.timKiem(maHH);
			if (hh == null)
				throw new Exception("Mã phòng không tồn tại: ");
			else {
				System.out.println("Thông tin của phòng trước khi sửa: \n" );
				xuatTieuDe();
				System.out.println(hh);

				int soLuong = nhapSoNguyen("\nNhập số lượng bóng đèn mới: ");
				hh.setSoBongDen(soLuong);				
				DSPhongHoc.sua(hh);
				System.out.println("\n Đã cập nhật thành công ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void xuatTieuDe() {
		// TODO Auto-generated method stub
		String str;
		str=String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s ",
				"Mã phòng","Dãy Nhà","Diện Tích","Số bóng đèn",
				"Thông tin 1","Thông tin 2","Thông tin 3","Đạt chuẩn");
		System.out.println(str);
	}
	public static void xuat(PhongHocList PhongHoc1) {
	    xuatTieuDe();
	    for (PhongHoc s : PhongHoc1.getDS()) { // Đảm bảo getDS() trả về danh sách đúng
	        System.out.println(s); // Đảm bảo rằng phương thức toString() không trả về null
	    }
	}
	public static void xuat60May() {
		System.out.println("Danh sách phòng 60 máy ");
		xuatTieuDe();
		for (PhongMayTinh pm : DSPhongHoc.getDSPhongMay60May()) {
		    System.out.println(pm);
		}
	}
	public static int Menu() {
		int chon;
		System.out.println("\tVui lòng chọn  ");
		System.out.println("\t1: Nhập Cứng");
		System.out.println("\t2: Thêm Phòng Học");
		System.out.println("\t3: Xóa");
		System.out.println("\t4: Sửa");
		System.out.println("\t5: Xuất");
		System.out.println("\t6: Sắp xếp diện tích giảm dần");
		System.out.println("\t7: Sắp xếp bóng đèn tăng dần");
		System.out.println("\t8: Xuất 60 máy");		
		Scanner sc = new Scanner(System.in);
		chon = sc.nextInt();
		return chon;
	}
	public static void main(String[] args) throws Exception {
		int chon;
		do {
			chon = Menu();
			switch (chon) {
			case 1:
				nhapCung();
				break;
			case 2:
				PhongHoc s = nhapMem();
				if (s != null) {
					DSPhongHoc.them(s);
					System.out.println("Thêm thành công");
				}

				else
					System.out.println("Thêm không thành công");
				break;

			case 3:
				xoa(DSPhongHoc);
				break;

			case 4:
				sua(DSPhongHoc);
				break;
			case 5:
				xuat(DSPhongHoc);
			    break;
			case 6:
				DSPhongHoc.sortTheoDienTichGiamDan();
				System.out.println("Sắp xếp thành công :");
				break;
			case 7:
				DSPhongHoc.sortTheoBongDenTangDan();
				System.out.println("Sắp xếp thành công :");
				break;
			case 8:
				xuat60May();
				break;
			}
	
		}while (chon != 9);
		System.out.println("Chương trình đã kết thúc!");
	}

}
