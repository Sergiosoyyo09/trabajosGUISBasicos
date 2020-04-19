package prPractica15;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LibreriaFechas {

	public static void setAnnio(Calendar fec, int num) {
		fec.set(Calendar.YEAR, num);
	}

	public static void setMes(Calendar fec, int num) {
		if (num<0 || num>11) {
			System.out.println("Error, mes erroneo");
		}
		else fec.set(Calendar.MONTH, num);
	}

	public static void setDia(Calendar fec, int num) {
		switch (fec.get(Calendar.MONTH)) {
		case 0:
		case 2: 
		case 4:
		case 6:
		case 7:
		case 9:
		case 11: if (num<1 || num>31){
			System.out.println("Error, dia erroneo");
		}
		else fec.set(Calendar.DAY_OF_MONTH, num);
		break;
		case 1: if (fec.get(Calendar.YEAR)%4==0 && (Calendar.YEAR)%100!=0 || (Calendar.YEAR)%400==0) {
			if (num<1 || num>29){
				System.out.println("Error, dia erroneo");
			}
			else fec.set(Calendar.DAY_OF_MONTH, num);
		}
		else {
			if (num<1 || num>28){
				System.out.println("Error, dia erroneo, año no bisiesto");
			}
			else fec.set(Calendar.DAY_OF_MONTH, num);
		}
		break;
		case 3:
		case 5:
		case 8: if (num<1 || num>30){
			System.out.println("Error, dia erroneo");
		}
		else fec.set(Calendar.DAY_OF_MONTH, num);
		break;
		}
	}


	public static String getFormatoCorto(Calendar fec) {

		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return df.format(fec.getTime());

	}

	public static String getFormatoMedio(Calendar fec) {

		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		return df.format(fec.getTime());

	}

	public static String getFormatoLargo(Calendar fec) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		return df.format(fec.getTime());
	}

	public static String toString(Calendar fecha) {

		return fecha.get(Calendar.DAY_OF_MONTH) + "/" + 
				(fecha.get(Calendar.MONTH) + 1) + "/" +
				fecha.get(Calendar.YEAR);
	}

	public static boolean validarFecha(String fecha) {
		try {
			SimpleDateFormat formatoFecha =
					new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
			// El método setLenient a false obliga a quelafecha
			// "tengasentidoestricto", y porlotantorechazaun
			// "30 defebrero" o un "29 defebrerode 2007" comofechasválidas.
			// Si no establecemos el lenient a false, alparsearunafecha
			// "interpretará" lafechacorrecta. Un "30 defebrero" seconvertirá
			// en 1 marzo, (en 2 demarzosiesunaño no bisiesto)...
			formatoFecha.setLenient(false);
			// El método parse devuelveunobjeto Date, portantosi el String que
			// lellega no esunafechacorrecta, bienporformato (Ej: 12/hola),
			// bienporque el día, mes o añoseanincorrectos (Ej: 30/02/2011)
			// lanzaunaexcepcióndeltipo ParseException
			formatoFecha.parse(fecha);
		}
		catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static boolean validarFecha2(String fecha) {
		try {
			SimpleDateFormat formatoFecha =
					new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());
			// El método setLenient a false obliga a quelafecha
			// "tengasentidoestricto", y porlotantorechazaun
			// "30 defebrero" o un "29 defebrerode 2007" comofechasválidas.
			// Si no establecemos el lenient a false, alparsearunafecha
			// "interpretará" lafechacorrecta. Un "30 defebrero" seconvertirá
			// en 1 marzo, (en 2 demarzosiesunaño no bisiesto)...
			formatoFecha.setLenient(false);
			// El método parse devuelveunobjeto Date, portantosi el String que
			// lellega no esunafechacorrecta, bienporformato (Ej: 12/hola),
			// bienporque el día, mes o añoseanincorrectos (Ej: 30/02/2011)
			// lanzaunaexcepcióndeltipo ParseException
			formatoFecha.parse(fecha);
		}
		catch (ParseException e) {
			return false;
		}
		return true;
	}

	public static Date stringADate(String fecha)
	{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} 
		catch (ParseException ex) 
		{
			System.out.println(ex);
		}
		return fechaDate;
	}


	public static Calendar stringACalendar(Calendar fechaNacimiento, String fn) {
		try { 
			fechaNacimiento = Calendar.getInstance();
			SimpleDateFormat formatoFecha =
					new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
			Date fechaDate = formatoFecha.parse(fn);
			fechaNacimiento.setTime(fechaDate);
		}
		catch(ParseException e) {
			System.out.println("Exception" + e);
		}
		return fechaNacimiento;

	}

	public static void sumaRestaDias(Calendar fec, int sumaResta) {
		fec.add(Calendar.DAY_OF_MONTH, sumaResta);
	}

	public static void sumaRestaMeses(Calendar fec, int sumaResta) {
		fec.add(Calendar.MONTH, sumaResta);
	}

	public static void sumaRestaAños(Calendar fec, int sumaResta) {
		fec.add(Calendar.YEAR, sumaResta);
	}

}

