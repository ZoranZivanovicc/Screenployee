package enums;

/**
 * Enumeration used for users which used for login to tmOne portal
 *
 * @version 1.0.0 date:10.05.2016
 */
public enum Users {
  // username
  VALIDREGISTERUSER("newray2"), INVALIDREGISTERUSER("tom"), VALIDLOGINUSER("newray2"), INVALIDLOGINUSER("tom"), SPECCHARUSER(";';';'"),

  // user password
  VALIDREGISTERUSERPASS("abcd4321"), INVALIDREGISTERUSERPASS(""), VALIDLOGINUSERPASS("Eclipse11"), INVALIDLOGINUSERPASS(
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