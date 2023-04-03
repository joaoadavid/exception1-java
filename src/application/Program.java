package application;

import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {// significa que possui uma exceção

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-In date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {// valida se uma data vem depois da outra, neste caso, data do check in tem que
										// ser
			// antes do checkout
			System.out.println("Error in reservation Check-Out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);

			System.out.println("Reservation: " + reservation);
			System.out.println("Enter data to update the reservation ");
			System.out.print("Check-In date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {// verifica se as datas são antes da data digitada
				System.out.println("Error in reservation: Reservation dates for update be must future.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation Check-Out date must be after check-in date.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation);
			}

		}
		sc.close();
	}

}
