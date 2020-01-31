package enums;

public enum RandomStrings {
    RANDOM_REGULAR_STRING("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    RANDOM_SPEC_CHAR_STRING("ÆæáčďéěíňóřšťúůýžÉÓÚÀÈËÏÖÜIJåäöäöüßÇéâêôûàèë"),
    RANDOM_NUMBERS_STRING("1234567890"),
    RANDOM_STRINGS_AND_NUMBERS("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");



    private String randString;

    private RandomStrings(String envUrl) {
        this.randString = randString;
    }

    /**
     * It will return url of selected enumaration url page as a string
     *
     * @return url
     */
    public String getRandString() {
        return this.randString;
    }

}
