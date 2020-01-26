package enums;

public enum Url {
    SCREENPLOYEELOGIN("https://screenployee-allthingstalk.firebaseapp.com/"),
    SCREENPLOYEEPAGE("https://screenployee-allthingstalk.firebaseapp.com/employees");

    private String envUrl;

    private Url(String envUrl) {
        this.envUrl = envUrl;
    }

    /**
     * It will return url of selected enumaration url page as a string
     *
     * @return url
     */
    public String getUrl() {
        return this.envUrl;
    }

}
