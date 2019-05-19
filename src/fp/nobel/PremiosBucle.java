package fp.nobel;
/**
 * @author Daniel Mateos
 * @author José A. Troyano
 * 
 * @since 2019-03-21
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class PremiosBucle implements Premios {

	// Atributo premios
	private Set<Premio> premios;

	@Override
	public void añadirPremio(Premio premio) {
		// TODO Auto-generated method stub
		this.premios.add(premio); // añade el parámetro premio a premios
									// si no estuviera en el conjunto

	}

	// ejemplo de filtrado
	@Override
	public Collection<Premio> obtenerPremiosPorGenero(Genero g) {
		// TODO Auto-generated method stub
		Collection<Premio> premios = new HashSet<Premio>();
		for (Premio premio : premios) { // tipo elemento:
			if (premio.getGenero().equals(g)) {
				premios.add(premio);
			}
		}
		return premios;
	}

	// ejemplo de contador
	@Override
	public Integer calcularNumeroPremiadosMasJovenesDe(Integer edad) {
		// TODO Auto-generated method stub
		Integer contador = 0;
		for (Premio premio : premios) {
			if (premio.getEdadPremiado() < (edad)) {
				contador++;
			}

		}
		return contador;
	}

	public Map<String, List<Integer>> calcularEdadesCategoria() {
		Map<String, List<Integer>> res = new HashMap<String, List<Integer>>();
		for (Premio p : premios) {
			if (res.containsKey(p.getCategoria())) {
				res.get(p.getCategoria()).add(p.getEdadPremiado());
			} else {
				List<Integer> valor = new LinkedList<Integer>();
				valor.add(p.getEdadPremiado());
				res.put(p.getCategoria(), valor);
			}
		}
		return res;
	}

	@Override
	public Map<String, Double> calcularMediaEdadPorCategoria() {
		Map<String, Double> r = new HashMap<String, Double>();
		Map<String, List<Integer>> aux = calcularEdadesCategoria();
		for (Entry<String, List<Integer>> e : aux.entrySet()) {
			r.put(e.getKey(), CalcularMediaLista(e.getValue()));

		}

		return r;

	}

	// calcular media lista
	private Double CalcularMediaLista(List<Integer> l) {
		Integer cont = 0;
		for (Integer i : l) {
			cont++;
		}
		return cont.doubleValue() / l.size();
	}

	// Constructor vacio
	public PremiosBucle() {
		premios = new HashSet<Premio>();

	}

	// Constructor mediante un stream

	public PremiosBucle(Stream<Premio> premios) {
		this.premios = premios.collect(Collectors.toSet());
	}

	// ToString
	@Override
	public String toString() {
		return "PremiosBucle [premios=" + premios + "]";
	}

	// HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((premios == null) ? 0 : premios.hashCode());
		return result;
	}

	// Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PremiosBucle other = (PremiosBucle) obj;
		if (premios == null) {
			if (other.premios != null)
				return false;
		} else if (!premios.equals(other.premios))
			return false;
		return true;
	}

}