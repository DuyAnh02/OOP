package tuan8_PhongHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




public class PhongHocList {
	private ArrayList<PhongHoc> DanhSachPH;

	public PhongHocList(){
		DanhSachPH = new ArrayList<PhongHoc>();
	}
	//them
	public void them(PhongHoc h) throws Exception {
		if (DanhSachPH.contains(h) == false)
			DanhSachPH.add(h);
		else {
			throw new Exception("Mã hàng hóa đã trùng");
		}
	}
	//xoa
	public void xoa(PhongHoc xoa) throws Exception {
		if (DanhSachPH.contains(xoa))
			DanhSachPH.remove(xoa);
		else
			throw new Exception("Không tìm thấy hàng hóa này");

	}
	//sua
	public void sua(PhongHoc h) {
		int vt = timKiemViTri(h.getMaPhong());
		DanhSachPH .set(vt, h);
	}
	
	//timkiem
	public PhongHoc timKiem(String maHH) {
		for (PhongHoc s : DanhSachPH) {
			if (s.getMaPhong().equalsIgnoreCase(maHH))
				return s;
		}
		return null;
	}
	
	private int timKiemViTri(String maHH) {
		PhongHoc findHH = timKiem(maHH);
		if (findHH != null)
			return DanhSachPH.indexOf(timKiem(maHH));
		return -1;
	}
	public void sortTheoDienTichGiamDan() {
		Collections.sort(DanhSachPH, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
				Double day1 = o1.getDienTich();
				Double day2 = o2.getDienTich();
				return day2.compareTo(day1);
			}
		});
	}
	public void sortTheoBongDenTangDan() {
		Collections.sort(DanhSachPH, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				// TODO Auto-generated method stub
			
				int day1 = o1.getSoBongDen();
				int day2 = o2.getSoBongDen();
				return Integer.compare(day1,day2);
			}
		});
	}
	public ArrayList<PhongMayTinh> getDSPhongMay60May() {
	    ArrayList<PhongMayTinh> dsPhongMay60May = new ArrayList<PhongMayTinh>();
	    for (PhongHoc ph : DanhSachPH) {
	        // Kiểm tra nếu phòng là PhongMayTinh và có đúng 60 máy tính
	        if (ph instanceof PhongMayTinh) {
	            PhongMayTinh pm = (PhongMayTinh) ph;  // Ép kiểu về PhongMayTinh
	            if (pm.getSoLuongMayTinh() == 60) {
	                dsPhongMay60May.add(pm);  // Thêm vào danh sách
	            }
	        }
	    }
	    return dsPhongMay60May;
	}
	public ArrayList<PhongHoc> getDS() {
		   return DanhSachPH;
	}
}
