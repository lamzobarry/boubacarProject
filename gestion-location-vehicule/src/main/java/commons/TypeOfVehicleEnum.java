package commons;

public enum TypeOfVehicleEnum {
M("M", "Motorbike"), C("C", "Car");
	private String code ;
	private String name ;



	TypeOfVehicleEnum(final String code, final String name) {
		this.name = name;
		this.code = code;
	}

	public static TypeOfVehicleEnum getTypeByCode(final String code) {
		TypeOfVehicleEnum retour = null;
		for (TypeOfVehicleEnum typeOfVehicleEnum : TypeOfVehicleEnum.values()) {
			if(typeOfVehicleEnum.getCode().equalsIgnoreCase(code)) retour = typeOfVehicleEnum;
			break;
		}
		return retour;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}  
	
	
	
}
