package ieti.project.onlyfit.repository.document;

public class Information {
    private String address;
    private String TipoDocumento;
    private String documentNumber;
    private String numero;
    private String numeroEmergencia;
    private String rh;
    private int weight;
    private int height;

    public Information() {
    }

    public Information(String address, String tipoDocumento, String documentNumber, String numero, String numeroEmergencia, String rh, int weight, int height) {
        this.address = address;
        TipoDocumento = tipoDocumento;
        this.documentNumber = documentNumber;
        this.numero = numero;
        this.numeroEmergencia = numeroEmergencia;
        this.rh = rh;
        this.weight = weight;
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    public String  getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
