package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// formata a data para o padrão

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut)  {
		if(!checkOut.after(checkOut)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();// pega a diferença entre as datas em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// converte o valor de diff que está em mili para dias
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {// verifica se as datas são antes da data digitada
			throw new DomainException("Error in reservation: Reservation dates for update be must future.");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Error in reservation Check-Out date must be after check-in date.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", checkIn: " + sdf.format(checkIn) + // cria a data de checkIn formatada
				", checkOut: " + sdf.format(checkOut) + " " + duration() + " nights ";// cria a data de checkOut
																						// formatada
	}

}
