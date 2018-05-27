package oovv;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public enum Empleo {

    VETERINARIO("Veterinario"),
    ADMINISTRATIVO("Administrativo"),
    AUXILIAR("Auxiliar"),
    RECEPCIONISTA("Recepcionista");

    private String empleo;

    private Empleo(String empleo) {
        this.empleo = empleo;
    }

    public String getEmpleo() {
        return empleo;
    }

}
