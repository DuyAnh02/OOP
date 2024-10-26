package tuan8_PhongHoc;

import java.util.Objects;

public abstract class PhongHoc {
	private String maPhong;
	private  String dayNha;
	private  double dienTich;
	private  int soBongDen;
	abstract String coDatChuan();
	
	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		super();
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}

	public PhongHoc() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMaPhong() {
		return maPhong;
	}


	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}


	public String getDayNha() {
		return dayNha;
	}


	public void setDayNha(String dayNha) {
		this.dayNha = dayNha;
	}


	public double getDienTich() {
		return dienTich;
	}


	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}


	public int getSoBongDen() {
		return soBongDen;
	}


	public void setSoBongDen(int soBongDen) {
		this.soBongDen = soBongDen;
	}
	
	public boolean duAnhSang() {
		if (getDienTich() / getSoBongDen() <= 10)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}


	@Override
	public String toString() {
		 return String.format("%-15s %-15s %-15.2f %-15d", getMaPhong(), getDayNha(), getDienTich(), getSoBongDen());
	}

}
