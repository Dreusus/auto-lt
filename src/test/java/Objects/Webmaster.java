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

    private void generateEmail() {
        this.email = "activeWM@" + faker.name().firstName().toLowerCase() + ".test";
    }
    public String getEmail() { return  email;}
    private void generateFirstName() {
        this.firstName = faker.name().firstName();
    }
    public String getFirstName() {return firstName;}

    private void generateLastName() {
        this.lastName = faker.name().lastName();
    }
    public String getLastName() {
        return lastName;
    }

    private void generatePassword() {
        this.password = faker.internet().password(8, 16, true, true);
        this.passwordConfirm = this.password;
    }
    public String getPassword(){
        return password;
    }
    public String getPasswordConfirm(){
        return passwordConfirm;
    }

    private void generatePhone() {
        this.phone = "7" + faker.number().digits(10);
    }
    public String getPhone(){return phone;}
    private void generateMiddleName() {
        this.middleName = faker.name().firstName();
    }
    public String getMiddleName() {
        return middleName;
    }
    private void generateTelegramNick() {
        this.telegramNick = "@" + faker.name().firstName();
    }

    public String getTelegramNick(){return telegramNick;}
    private void setCpaPercent() {
        this.cpaPercent = "10";
    }

    public String getCpaPercent(){return cpaPercent;}
    private void setRefPercent() {
        this.refPercent = "5";
    }
    public String getRefPercent(){return refPercent;}

    private void setTelegramChatId() {
        this.telegramChatId = "666";
    }
    public String getTelegramChatId(){return telegramChatId;}

    private void setWebTraffic() {
        this.webTraffic = faker.color().name();
    }
    public String getWebTraffic(){return webTraffic;}
    private void setWebTimeZone() {
        this.webTimeZone = "мск";
    }
    public String  getWebTimeZone(){return webTimeZone;}

    private void setWebOrgMode() {
        this.webOrgMode = faker.food().fruit();
    }
    public String getWebOrgMode(){return webOrgMode;}
    private void setWebSkill() {
        this.webSkill = "1.5";
    }
    public String getWebSkill(){return webSkill;}
    private void setWebPayForm() {
        this.webPayForm = "Нал";
    }
    public String getWebPayForm(){return webPayForm;}
    private void setWebOthersContacts() {
        this.webOthersContacts = faker.animal().name();
    }
    public String getWebOthersContacts(){return webOthersContacts;}

}

