import java.util.ArrayList;
import java.util.List;

public class HistorialMedico {
    private List<Consulta> consultas;
    private List<RecetaMedica> recetasMedicas;

    public HistorialMedico() {
        this.consultas = new ArrayList<>();
        this.recetasMedicas = new ArrayList<>();
    }

    public List<Consulta> getConsultas() {
    	return new ArrayList<Consulta>(this.consultas); // Devuelve una copia
    }

    public boolean agregarConsulta(Consulta consulta) {
    	this.consultas.add(consulta);
        return true;
    }
    
    public boolean eliminarConsulta(Consulta consulta) {
    	int indice = this.consultas.indexOf(consulta);
        if (indice != -1) {
        	this.consultas.remove(indice);
        	return true;
        }
        return false;
    }

    public List<RecetaMedica> getRecetasMedicas() {
    	return new ArrayList<RecetaMedica>(this.recetasMedicas); // Devuelve una copia
    }

    public boolean agregarRecetaMedica(RecetaMedica recetaMedica) {
    	this.recetasMedicas.add(recetaMedica);
        return true;
    }
    
    public boolean eliminarRecetaMedica(RecetaMedica recetaMedica) {
    	int indice = this.recetasMedicas.indexOf(recetaMedica);
        if (indice != -1) {
        	this.recetasMedicas.remove(indice);
        	return true;
        }
        return false;
    }
}
