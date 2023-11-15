package Objects;

import com.github.javafaker.Faker;



public class Offer {
    private String name;
    private String slug;
    private Long license;
    private Long erid;
    private Integer hold;
    private Integer minAge;
    private Integer maxAge;
    private String  offerLink;
    private String  offerProductName;
    private Long amountMax;
    private Long amountMin;
    private Long minPercentAge;
    private Float maxPercentDay;
    private Long dailyConversionLimit;
    private String cookieLTV;
    private Long minLoanTerm;
    private Long maxLoanTerm;

    private static final Faker faker = new Faker();

    public Offer() {
        generateName();
        generateSlug();
        generateOfferProductName();
        generateLicence();
        generateErid();
        generateMinAge();
        generateMaxAge();
        generateHold();
        generateOfferLink();
        generateAmountMax();
        generateAmountMin();
        generateMinPercentAge();
        generateMaxPercentDay();
        generateDailyConversionLimit();
        generateMinLoanTerm();
        generateMaxLoanTerm();
        generateCookieLTV();
    }




    //Генераторы
    private void generateName(){
        this.name = "dr._" + faker.name().firstName().toLowerCase();
    }

    private void generateSlug() {
        this.slug = faker.cat().name().toLowerCase();
    }

    private void generateOfferProductName(){
        this.offerProductName = faker.job().field();
    }

    private void generateLicence(){
        this.license = faker.number().randomNumber(5, true);
    }
    private void generateErid(){
        this.erid =  faker.number().randomNumber(5,true);
    }
    private void generateMinAge(){
        this.minAge = faker.number().numberBetween(18,20);
    }
    private void generateMaxAge(){
        this.maxAge = faker.number().numberBetween(90,150);
    }
    private void generateHold() {
        this.hold = faker.number().numberBetween(0,3);
    }
    private void generateOfferLink(){
        this.offerLink = "https://google.by/?clickId={clickId}&wmid={webmasterid}";
    }
    private void generateAmountMax() {
        this.amountMax =  faker.number().randomNumber(5,true);
    }
    private void generateAmountMin() {
        this.amountMin =  faker.number().randomNumber(5,true);
    }
    private void generateMinPercentAge() {
        this.minPercentAge= (long) faker.number().numberBetween(1,292);
    }
    private void generateMaxPercentDay() {
        this.maxPercentDay = (float) (0.1 * faker.number().numberBetween(0,8));
    }
    private void generateDailyConversionLimit() {
        this.dailyConversionLimit =  faker.number().randomNumber(5,true);
    }

    private void generateMinLoanTerm() {
        this.minLoanTerm =  faker.number().randomNumber(5,true);
    }
    private void generateMaxLoanTerm() {
        this.maxLoanTerm =  faker.number().randomNumber(5,true);
    }
    private void generateCookieLTV(){
        this.cookieLTV = faker.color().name();
    }


    //Гетеры
    public String getName(){return name;}
    public String getSlug() {return slug;}
    public String getOfferProductName(){return offerProductName;}
    public Long getLicense() {return  license;}
    public Long getErid() {return  erid;}
    public Integer getMinAge() {return  minAge;}
    public Integer getMaxAge() {return  maxAge;}
    public Integer getHold() {return hold;}
    public String getOfferLink(){return offerLink;}
    public Long getAmountMax(){return amountMax;}
    public Long getAmountMin(){return amountMin;}
    public Long getMinPercentAge(){return minPercentAge;}
    public Float getMaxPercentDay(){return  maxPercentDay;}
    public Long getDailyConversionLimit(){return dailyConversionLimit;}
    public Long getMinLoanTerm(){return minLoanTerm;}
    public Long getMaxLoanTerm(){return maxLoanTerm;}
    public String getCookieLTV(){return cookieLTV;}

    }



