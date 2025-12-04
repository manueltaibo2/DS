package e4;

public enum EuroCountry {
    ANDORRA("Andorra", IsoCode.AD),
    AUSTRIA("Austria", IsoCode.AT),
    BELGIUM("Belgium", IsoCode.BE),
    CYPRUS("Cyprus", IsoCode.CY),
    CROATIA("Croatia", IsoCode.HR),
    ESTONIA("Estonia", IsoCode.EE),
    FINLAND("Finland", IsoCode.FI),
    FRANCE("France", IsoCode.FR),
    GERMANY("Germany", IsoCode.DE),
    GREECE("Greece", IsoCode.GR),
    IRELAND("Ireland", IsoCode.IE),
    ITALY("Italy", IsoCode.IT),
    LATVIA("Latvia", IsoCode.LV),
    LITHUANIA("Lithuania", IsoCode.LT),
    LUXEMBOURG("Luxembourg", IsoCode.LU),
    MALTA("Malta", IsoCode.MT),
    MONACO("Monaco", IsoCode.MC),
    NETHERLANDS("Netherlands", IsoCode.NL),
    PORTUGAL("Portugal", IsoCode.PT),
    SAN_MARINO("San Marino", IsoCode.SM),
    SLOVAKIA("Slovakia", IsoCode.SK),
    SLOVENIA("Slovenia", IsoCode.SI),
    SPAIN("Spain", IsoCode.ES),
    VATICAN_CITY("Vatican City", IsoCode.VA);

    private final String name;
    private final IsoCode isoCode;

    EuroCountry(String name, IsoCode isoCode) {
        this.name = name;
        this.isoCode = isoCode;
    }

    public String getName() {
        return name;
    }

    public IsoCode getIsoCode() {
        return isoCode;
    }
}