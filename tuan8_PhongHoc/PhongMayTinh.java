package tuan8_PhongHoc;

public class PhongMayTinh extends PhongHoc {
	private int soLuongMayTinh;


	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen,int soLuongMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soLuongMayTinh = soLuongMayTinh;
	}

	public PhongMayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	public int getSoLuongMayTinh() {
		return soLuongMayTinh;
	}

	public void setSoLuongMayTinh(int soLuongMayTinh) {
		this.soLuongMayTinh = soLuongMayTinh;
	}

	@Override
	public String coDatChuan() {
		// TODO Auto-generated method stub
		String str="Không";
		if (getDienTich()/ getSoLuongMayTinh()<1.5 && duAnhSang()) {
			str="Đạt chuẩn";
		}
		return str;
		
	}
	public String toString() {
		
		return String.format("%-15s %-15s %-15.2f %-15d %-47d %-15s",
				getMaPhong(), getDayNha(), getDienTich(), getSoBongDen(),getSoLuongMayTinh(),coDatChuan());
	}
	
	


}
