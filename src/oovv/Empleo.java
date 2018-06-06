package oovv;

/**
 *
 * @author Javi Palacios <javi@fjp.es>
 */
public enum Empleo {

    VETERINARIO("VETERINARIO"),
    ADMINISTRATIVO("ADMINISTRATIVO"),
    AUXILIAR("AUXILIAR"),
    RECEPCIONISTA("RECEPCIONISTA");

    private String empleo;

    private Empleo(String empleo) {
        this.empleo = empleo;
    }

    public String getEmpleo() {
        return empleo;
    }
    

}
