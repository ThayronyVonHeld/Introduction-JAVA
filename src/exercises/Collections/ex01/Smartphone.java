package exercises.Collections.ex01;

public class Smartphone {

    private String marca;
    private String serialNumber;

    public Smartphone(String marca, String serialNumber) {
        this.marca = marca;
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

Smartphone Other = (Smartphone) obj;

        return serialNumber.equals(Other.serialNumber);

    }

    @Override
    public int hashCode(){
        return serialNumber != null
                ? serialNumber.hashCode()
                : 0;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "marca='" + marca + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
