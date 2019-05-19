package fp.nobel;

import java.util.Collection;
import java.util.Map;

public interface Premios {
	
	public void añadirPremio(Premio p);
	public Collection<Premio> obtenerPremiosPorGenero(Genero g);
	public Integer calcularNumeroPremiadosMasJovenesDe(Integer i);
	public Map<String,Double> calcularMediaEdadPorCategoria();
	

}
