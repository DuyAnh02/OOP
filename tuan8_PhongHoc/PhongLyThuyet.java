package tuan8_PhongHoc;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen,boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}

	public PhongLyThuyet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	public boolean isCoMayChieu() {
		return coMayChieu;
	}

	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}

	@Override
	public String coDatChuan() {
		// TODO Auto-generated method stub
		String str="Không đạt chuẩn";
		if (isCoMayChieu() && duAnhSang()) {
			str="Đạt chuẩn";
		}
		return str;

	}
	public String toString() {
		String s = "co";
		if (!isCoMayChieu())
			s = "khong";
		return String.format("%-15s %-15s %-15.2f %-15d %-47s %-15s"
				, getMaPhong(), getDayNha(), getDienTich(), getSoBongDen(),s,coDatChuan());
	}
	
	

}
