package fp.nobel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FactoriaNobel {

	private static Premio parsearPremio(String leerCSV) {
		String[] campo = leerCSV.split(",");

		// Excepcion
		if (campo.length != 6) {
			throw new IllegalArgumentException("El formato no tiene el tamaño adecuado" + campo.length);

		}

		//
		Integer año = Integer.valueOf(campo[0].trim());
		String categoria = campo[1].trim();
		String nombre = campo[2].trim();
		String apellidos = campo[3].trim();
		Genero genero = Genero.valueOf(campo[4].trim());
		Integer añoNacimiento = Integer.valueOf(campo[5].trim());

		return new Premio(año, categoria, nombre, apellidos, genero, añoNacimiento);
	}

	public static PremiosStream leerPremios(String fichero) {

		PremiosStream ap = null;

		try {

			Stream<Premio> sv = Files.lines(Paths.get(fichero), StandardCharsets.UTF_8).skip(1)
					.map(FactoriaNobel::parsearPremio);

			ap = new PremiosStream(sv);

		} catch (IOException e) {

			System.out.println("Fichero no encontrado " + fichero);
			e.printStackTrace();
		}

		return ap;

	}

}
