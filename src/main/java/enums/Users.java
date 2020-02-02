package enums;


public enum Users {
  // username
  VALIDREGISTERUSER("newray2"), INVALIDREGISTERUSER("tom"), VALIDLOGINUSER("snezni"), INVALIDLOGINUSER("tom"), SPECCHARUSER(";';';'"),

  // user password
  VALIDREGISTERUSERPASS("abcd4321"), INVALIDREGISTERUSERPASS(""), VALIDLOGINUSERPASS("a11091983"), INVALIDLOGINUSERPASS(
      "Eclipse4"), SPECCHARUSERPASS("Eclipse55"),

  // user mail for register
  VALIDREGISTERUSERMAIL("mail@mail.com");

  private String userValue;

  private Users(String userValue) {
    this.userValue = userValue;

  }

  /**
   * It will return username as a string
   * 
   * @return username
   */
  public String getUserParams() {
    return this.userValue;
  }



}