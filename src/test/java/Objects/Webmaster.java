package Objects;

import com.github.javafaker.Faker;


public class Webmaster{
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String  passwordConfirm;

    private String phone;
    private String  middleName;
    private String cpaPercent;
    private String refPercent;
    private String telegramChatId;
    private String webTraffic;
    private String webTimeZone;
    private String webOrgMode;
    private String webSkill;
    private String webPayForm ;
    private String webOthersContacts;
    private String telegramNick;

    private static final Faker faker = new Faker();


    public Webmaster() {
        generateEmail();
        generateFirstName();
        generateLastName();
        generatePassword();
        generatePhone();
        generateMiddleName();
        generateTelegramNick();
        setCpaPercent();
        setRefPercent();
        setTelegramChatId();
        setWebTraffic();
        setWebTimeZone();
        setWebOrgMode();
        setWebSkill();
        setWebPayForm();
        setWebOthersContacts();
    }
    //Генераторы
    private void generateEmail() {
        this.email = "activeWM@" + faker.name().firstName().toLowerCase() + ".test";
    }
    private void generateFirstName() {
        this.firstName = faker.name().firstName();
    }
    private void generateLastName() {
        this.lastName = faker.name().lastName();
    }
    private void generatePassword() {
        this.password = faker.internet().password(8, 16, true, true);
        this.passwordConfirm = this.password;
    }
    private void generatePhone() {
        this.phone = "7" + faker.number().digits(10);
    }
    private void generateMiddleName() {
        this.middleName = faker.name().firstName();
    }
    private void generateTelegramNick() {
        this.telegramNick = "@" + faker.name().firstName();
    }
    private void setCpaPercent() {
        this.cpaPercent = "10";
    }
    private void setRefPercent() {
        this.refPercent = "5";
    }
    private void setTelegramChatId() {
        this.telegramChatId = "666";
    }
    private void setWebTimeZone() {
        this.webTimeZone = "мск";
    }
    private void setWebOrgMode() {
        this.webOrgMode = faker.food().fruit();
    }
    private void setWebSkill() {
        this.webSkill = "1.5";
    }
    private void setWebPayForm() {
        this.webPayForm = "Нал";
    }
    private void setWebOthersContacts() {
        this.webOthersContacts = faker.animal().name();
    }

    //Гетеры
    private void setWebTraffic() {
        this.webTraffic = faker.color().name();
    }
    public String getFirstName() {return firstName;}
    public String getEmail() { return  email;}
    public String getLastName() {
        return lastName;
    }
    public String getPassword(){
        return password;
    }
    public String getPasswordConfirm(){
        return passwordConfirm;
    }
    public String getPhone(){return phone;}
    public String getMiddleName() {
        return middleName;
    }
    public String getTelegramNick(){return telegramNick;}
    public String getCpaPercent(){return cpaPercent;}
    public String getRefPercent(){return refPercent;}
    public String getTelegramChatId(){return telegramChatId;}
    public String getWebTraffic(){return webTraffic;}
    public String  getWebTimeZone(){return webTimeZone;}
    public String getWebOrgMode(){return webOrgMode;}
    public String getWebSkill(){return webSkill;}
    public String getWebPayForm(){return webPayForm;}
    public String getWebOthersContacts(){return webOthersContacts;}

}

