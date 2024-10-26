package tuan8_PhongHoc;

public class PhongThiNghiem extends PhongHoc{
	private String chuyenNganh;
	private int sucChua;
	private boolean coBonRua;
	
	
	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen,
			String chuyenNganh, int sucChua, boolean coBonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.coBonRua = coBonRua;
	}
	
	public PhongThiNghiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
		// TODO Auto-generated constructor stub
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public int getSucChua() {
		return sucChua;
	}
	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}
	public boolean isCoBonRua() {
		return coBonRua;
	}
	public void setCoBonRua(boolean coBonRua) {
		this.coBonRua = coBonRua;
	}
	@Override
	public String coDatChuan() {
		// TODO Auto-generated method stub
		String str="Không đạt chuẩn";
		if (isCoBonRua() && duAnhSang()) {
			str="Đạt chuẩn";
		}
		return str;
			

	}
	public String toString() {
		String s = "co";
		if (!isCoBonRua())
			s = "khong";
		return String.format("%-15s %-15s %-15.2f %-15d %-15s %-15d %-15s %-15s"
				, getMaPhong(), getDayNha(), getDienTich(), getSoBongDen()
				,getChuyenNganh(),getSucChua(),s,coDatChuan());
	}

	
}
