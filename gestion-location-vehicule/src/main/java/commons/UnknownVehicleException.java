package commons;

public class UnknownVehicleException extends RuntimeException {

    Vehicle vehicle;

        public UnknownVehicleException(Vehicle vehicle){
            this.vehicle=vehicle;
        }

        public String getMessage(){
            return " Ce "+ vehicle.toString()+" n'existe pas dans l'agence ";
        }
}

