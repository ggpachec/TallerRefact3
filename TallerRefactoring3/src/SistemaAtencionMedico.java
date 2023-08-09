import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SistemaAtencionMedico {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<ServicioMedico> serviciosMedicos;

    final private double DESCUENTO_ADULTOS_MAYORES = 0.25;
    final private int EDAD_DE_ADULTO_MAYOR = 65;

    public SistemaAtencionMedico() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.serviciosMedicos = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarServicioMedico(ServicioMedico servicioMedico) {
        serviciosMedicos.add(servicioMedico);
    }

    public <T> T obtenerElemento(List<T> elementos, String nombreElemento, Function<T, String> obtenerNombre) {
        for (T elemento : elementos) {
            if (obtenerNombre.apply(elemento).equals(nombreElemento)) {
                return elemento;
            }
        }
        return null;
    }

    public Paciente obtenerPaciente(String nombrePaciente) {
        return obtenerElemento(pacientes, nombrePaciente, Paciente::getNombre);
    }

    public ServicioMedico obtenerServicioMedico(String nombreServicio) {
        return obtenerElemento(serviciosMedicos, nombreServicio, ServicioMedico::getNombre);
    }

    public Medico obtenerMedico(String nombreMedico) {
        return obtenerElemento(medicos, nombreMedico, Medico::getNombre);
    }

    public void agendarConsulta(Paciente paciente, Consulta consulta){
        double costoConsulta = consulta.getServicioMedico().getCosto();
        int edadPaciente = paciente.getEdad();
        costoConsulta = calcularValorFinalConsulta(costoConsulta,edadPaciente);
        System.out.println("Se han cobrado "+ costoConsulta+ " dolares de su tarjeta de credito");
        paciente.agregarConsultaAlHistorial(consulta);
    }

    public double calcularValorFinalConsulta(double costoConsulta, int edadPaciente){
        double valorARestar = 0;
        if(edadPaciente >= EDAD_DE_ADULTO_MAYOR){
            valorARestar = costoConsulta * DESCUENTO_ADULTOS_MAYORES;
        }
        return costoConsulta-valorARestar;
    }
}
