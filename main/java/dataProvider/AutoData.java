package dataProvider;

public class AutoData {

	private String insuranceType;       public String getInsuranceType() {	return insuranceType; }
	private String zip;                       public String getZip() {return zip; }
	private String firstName;             public String getFirstName() {return firstName;}
	private String lastName;              public String getLastName() {return lastName;}
	private char middleName;            public char getMiddleName() {return middleName;}
	private String suffix;                   public String getSuffix() {return suffix;}
	private String address;                public String getAddress() {return address;}
	private String apt;                       public String getApt() {return apt;}
	private String dOB;                     public String getdOB() {return dOB;}
	private boolean radioButton;        public boolean getisRadioButton() {return radioButton;}

	public AutoData (  String insuranceType,  String zip, String firstName,   String lastName, 
			char middleName,String suffix, String address, String apt, String dOB, boolean radioButton) {
		
		this.insuranceType = insuranceType;
		this.zip = zip;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.suffix = suffix;
		this.address = address;
		this.apt = apt;
		this.dOB = dOB;
		this.radioButton = radioButton;
		
    	}

}