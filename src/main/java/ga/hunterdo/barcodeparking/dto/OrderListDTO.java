package ga.hunterdo.barcodeparking.dto;

import java.util.Date;

public class OrderListDTO {
	private Date date;
	private Integer qtyMoto = 0;
	private Integer qtyCar = 0;
	private Integer usedMoto = 0;
	private Integer usedCar = 0;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getQtyMoto() {
		return qtyMoto;
	}
	public void setQtyMoto(int qtyMoto) {
		this.qtyMoto = qtyMoto;
	}

	public Integer getQtyCar() {
		return qtyCar;
	}
	public void setQtyCar(int qtyCar) {
		this.qtyCar = qtyCar;
	}

	public Integer getUsedMoto() {
		return usedMoto;
	}
	public void setUsedMoto(int usedMoto) {
		this.usedMoto = usedMoto;
	}

	public Integer getUsedCar() {
		return usedCar;
	}
	public void setUsedCar(int usedCar) {
		this.usedCar = usedCar;
	}
}