package e3;

public record Property(
        PropertyType type,
        String cadastreNumber,
        String address,
        String postalCode,
        int squareMeters,
        int rooms,
        int bathrooms) {

    //el registro proporciona los metodos getter para todos los campos, tambien un constructor publico que los inicializa

    @Override
    public String toString() {
        return type + "\n" + cadastreNumber + "\n" + address + "\n" + postalCode + "\n" +
                squareMeters + " meters, " + rooms + " rooms, " + bathrooms + " bathrooms\n";
    }

    @Override
    //sobreescribir el equals para que dos objetos sean iguales si su catastro es el mismo
    public boolean equals(Object o) {
        if (this == o) return true;   //si apuntan a la misma direccion de memoria son iguales
        if (o == null || getClass() != o.getClass()) return false; //si o es NULL o tienen distintas clases, no son iguales
        Property property = (Property) o;   //conversion de tipo
        return cadastreNumber.equals(property.cadastreNumber); //si tienen las misma clase, se comprueba si tienen el mismo catastro
    }

    @Override
    public int hashCode() {
        return cadastreNumber.hashCode();   //si dos son iguales en equals(), deben tener el mismo hashcode
    }
}

