package com.saadqazi.currencyconverter.helpers

object Util {

    val currencyNames = hashMapOf(
        "USD" to "United States Dollar",
        "AED" to "United Arab Emirates Dirham",
        "AFN" to "Afghan Afghani",
        "ALL" to "Albanian Lek",
        "AMD" to "Armenian Dram",
        "ANG" to "Netherlands Antillean Guilder",
        "AOA" to "Angolan Kwanza",
        "ARS" to "Argentine Peso",
        "AUD" to "Australian Dollar",
        "AWG" to "Aruban Florin",
        "AZN" to "Azerbaijani Manat",
        "BAM" to "Bosnia-Herzegovina Convertible Mark",
        "BBD" to "Barbadian Dollar",
        "BDT" to "Bangladeshi Taka",
        "BGN" to "Bulgarian Lev",
        "BHD" to "Bahraini Dinar",
        "BIF" to "Burundian Franc",
        "BMD" to "Bermudian Dollar",
        "BND" to "Brunei Dollar",
        "BOB" to "Bolivian Boliviano",
        "BRL" to "Brazilian Real",
        "BSD" to "Bahamian Dollar",
        "BTN" to "Bhutanese Ngultrum",
        "BWP" to "Botswana Pula",
        "BYN" to "Belarusian Ruble",
        "BZD" to "Belize Dollar",
        "CAD" to "Canadian Dollar",
        "CDF" to "Congolese Franc",
        "CHF" to "Swiss Franc",
        "CLP" to "Chilean Peso",
        "CNY" to "Chinese Yuan",
        "COP" to "Colombian Peso",
        "CRC" to "Costa Rican Colón",
        "CUP" to "Cuban Peso",
        "CVE" to "Cape Verdean Escudo",
        "CZK" to "Czech Koruna",
        "DJF" to "Djiboutian Franc",
        "DKK" to "Danish Krone",
        "DOP" to "Dominican Peso",
        "DZD" to "Algerian Dinar",
        "EGP" to "Egyptian Pound",
        "ERN" to "Eritrean Nakfa",
        "ETB" to "Ethiopian Birr",
        "EUR" to "Euro",
        "FJD" to "Fijian Dollar",
        "FKP" to "Falkland Islands Pound",
        "FOK" to "Faroese Króna",
        "GBP" to "British Pound Sterling",
        "GEL" to "Georgian Lari",
        "GGP" to "Guernsey Pound",
        "GHS" to "Ghanaian Cedi",
        "GIP" to "Gibraltar Pound",
        "GMD" to "Gambian Dalasi",
        "GNF" to "Guinean Franc",
        "GTQ" to "Guatemalan Quetzal",
        "GYD" to "Guyanaese Dollar",
        "HKD" to "Hong Kong Dollar",
        "HNL" to "Honduran Lempira",
        "HRK" to "Croatian Kuna",
        "HTG" to "Haitian Gourde",
        "HUF" to "Hungarian Forint",
        "IDR" to "Indonesian Rupiah",
        "ILS" to "Israeli New Shekel",
        "IMP" to "Isle of Man Pound",
        "INR" to "Indian Rupee",
        "IQD" to "Iraqi Dinar",
        "IRR" to "Iranian Rial",
        "ISK" to "Icelandic Króna",
        "JEP" to "Jersey Pound",
        "JMD" to "Jamaican Dollar",
        "JOD" to "Jordanian Dinar",
        "JPY" to "Japanese Yen",
        "KES" to "Kenyan Shilling",
        "KGS" to "Kyrgystani Som",
        "KHR" to "Cambodian Riel",
        "KID" to "Kiribati Dollar",
        "KMF" to "Comorian Franc",
        "KRW" to "South Korean Won",
        "KWD" to "Kuwaiti Dinar",
        "KYD" to "Cayman Islands Dollar",
        "KZT" to "Kazakhstani Tenge",
        "LAK" to "Laotian Kip",
        "LBP" to "Lebanese Pound",
        "LKR" to "Sri Lankan Rupee",
        "LRD" to "Liberian Dollar",
        "LSL" to "Lesotho Loti",
        "LYD" to "Libyan Dinar",
        "MAD" to "Moroccan Dirham",
        "MDL" to "Moldovan Leu",
        "MGA" to "Malagasy Ariary",
        "MKD" to "Macedonian Denar",
        "MMK" to "Myanmar Kyat",
        "MNT" to "Mongolian Tugrik",
        "MOP" to "Macanese Pataca",
        "MRU" to "Mauritanian Ouguiya",
        "MUR" to "Mauritian Rupee",
        "MVR" to "Maldivian Rufiyaa",
        "MWK" to "Malawian Kwacha",
        "MXN" to "Mexican Peso",
        "MYR" to "Malaysian Ringgit",
        "MZN" to "Mozambican Metical",
        "NAD" to "Namibian Dollar",
        "NGN" to "Nigerian Naira",
        "NIO" to "Nicaraguan Córdoba",
        "NOK" to "Norwegian Krone",
        "NPR" to "Nepalese Rupee",
        "NZD" to "New Zealand Dollar",
        "OMR" to "Omani Rial",
        "PAB" to "Panamanian Balboa",
        "PEN" to "Peruvian Nuevo Sol",
        "PGK" to "Papua New Guinean Kina",
        "PHP" to "Philippine Peso",
        "PKR" to "Pakistani Rupee",
        "PLN" to "Polish Zloty",
        "PYG" to "Paraguayan Guarani",
        "QAR" to "Qatari Rial",
        "RON" to "Romanian Leu",
        "RSD" to "Serbian Dinar",
        "RUB" to "Russian Ruble",
        "RWF" to "Rwandan Franc",
        "SAR" to "Saudi Riyal",
        "SBD" to "Solomon Islands Dollar",
        "SCR" to "Seychellois Rupee",
        "SDG" to "Sudanese Pound",
        "SEK" to "Swedish Krona",
        "SGD" to "Singapore Dollar",
        "SHP" to "Saint Helena Pound",
        "SLE" to "Sierra Leonean Leone",
        "SLL" to "Sierra Leonean Leone",
        "SOS" to "Somali Shilling",
        "SRD" to "Surinamese Dollar",
        "SSP" to "South Sudanese Pound",
        "STN" to "São Tomé and Príncipe Dobra",
        "SYP" to "Syrian Pound",
        "SZL" to "Swazi Lilangeni",
        "THB" to "Thai Baht",
        "TJS" to "Tajikistani Somoni",
        "TMT" to "Turkmenistani Manat",
        "TND" to "Tunisian Dinar",
        "TOP" to "Tongan Pa'anga",
        "TRY" to "Turkish Lira",
        "TTD" to "Trinidad and Tobago Dollar",
        "TVD" to "Tuvaluan Dollar",
        "TWD" to "New Taiwan Dollar",
        "TZS" to "Tanzanian Shilling",
        "UAH" to "Ukrainian Hryvnia",
        "UGX" to "Ugandan Shilling",
        "UYU" to "Uruguayan Peso",
        "UZS" to "Uzbekistan Som",
        "VES" to "Venezuelan Bolívar",
        "VND" to "Vietnamese Dong",
        "VUV" to "Vanuatu Vatu",
        "WST" to "Samoan Tala",
        "XAF" to "Central African CFA Franc",
        "XCD" to "East Caribbean Dollar",
        "XDR" to "Special Drawing Rights",
        "XOF" to "West African CFA Franc",
        "XPF" to "CFP Franc",
        "YER" to "Yemeni Rial",
        "ZAR" to "South African Rand",
        "ZMW" to "Zambian Kwacha",
        "ZWL" to "Zimbabwean Dollar"
    )

    val currencyFlags = hashMapOf(
        "USD" to "\uD83C\uDDFA\uD83C\uDDF8",  // United States
        "AED" to "\uD83C\uDDE6\uD83C\uDDEA",  // United Arab Emirates
        "AFN" to "\uD83C\uDDE6\uD83C\uDDEB",  // Afghanistan
        "ALL" to "\uD83C\uDDE6\uD83C\uDDF1",  // Albania
        "AMD" to "\uD83C\uDDE6\uD83C\uDDF2",  // Armenia
        "ANG" to "\uD83C\uDDE6\uD83C\uDDF6",  // Netherlands Antilles
        "AOA" to "\uD83C\uDDE6\uD83C\uDDF4",  // Angola
        "ARS" to "\uD83C\uDDE6\uD83C\uDDF7",  // Argentina
        "AUD" to "\uD83C\uDDE6\uD83C\uDDFA",  // Australia
        "AWG" to "\uD83C\uDDE6\uD83C\uDDFC",  // Aruba
        "AZN" to "\uD83C\uDDE6\uD83C\uDDFF",  // Azerbaijan
        "BAM" to "\uD83C\uDDE7\uD83C\uDDE6",  // Bosnia-Herzegovina
        "BBD" to "\uD83C\uDDE7\uD83C\uDDE7",  // Barbados
        "BDT" to "\uD83C\uDDE7\uD83C\uDDE9",  // Bangladesh
        "BGN" to "\uD83C\uDDE7\uD83C\uDDEC",  // Bulgaria
        "BHD" to "\uD83C\uDDE7\uD83C\uDDED",  // Bahrain
        "BIF" to "\uD83C\uDDE7\uD83C\uDDEE",  // Burundi
        "BMD" to "\uD83C\uDDE7\uD83C\uDDF2",  // Bermuda
        "BND" to "\uD83C\uDDE7\uD83C\uDDF3",  // Brunei
        "BOB" to "\uD83C\uDDE7\uD83C\uDDF4",  // Bolivia
        "BRL" to "\uD83C\uDDE7\uD83C\uDDF7",  // Brazil
        "BSD" to "\uD83C\uDDE7\uD83C\uDDF8",  // Bahamas
        "BTN" to "\uD83C\uDDE7\uD83C\uDDF9",  // Bhutan
        "BWP" to "\uD83C\uDDE7\uD83C\uDDFC",  // Botswana
        "BYN" to "\uD83C\uDDE7\uD83C\uDDFE",  // Belarus
        "BZD" to "\uD83C\uDDE7\uD83C\uDDFF",  // Belize
        "CAD" to "\uD83C\uDDE8\uD83C\uDDE6",  // Canada
        "CDF" to "\uD83C\uDDE8\uD83C\uDDE9",  // Congo-Kinshasa
        "CHF" to "\uD83C\uDDE8\uD83C\uDDED",  // Switzerland
        "CLP" to "\uD83C\uDDE8\uD83C\uDDF1",  // Chile
        "CNY" to "\uD83C\uDDE8\uD83C\uDDF3",  // China
        "COP" to "\uD83C\uDDE8\uD83C\uDDF4",  // Colombia
        "CRC" to "\uD83C\uDDE8\uD83C\uDDF7",  // Costa Rica
        "CUP" to "\uD83C\uDDE8\uD83C\uDDFA",  // Cuba
        "CVE" to "\uD83C\uDDE8\uD83C\uDDFB",  // Cape Verde
        "CZK" to "\uD83C\uDDE8\uD83C\uDDFF",  // Czechia
        "DJF" to "\uD83C\uDDE9\uD83C\uDDEF",  // Djibouti
        "DKK" to "\uD83C\uDDE9\uD83C\uDDF0",  // Denmark
        "DOP" to "\uD83C\uDDE9\uD83C\uDDF4",  // Dominican Republic
        "DZD" to "\uD83C\uDDE9\uD83C\uDDFF",  // Algeria
        "EGP" to "\uD83C\uDDEA\uD83C\uDDEC",  // Egypt
        "ERN" to "\uD83C\uDDEA\uD83C\uDDF7",  // Eritrea
        "ETB" to "\uD83C\uDDEA\uD83C\uDDF9",  // Ethiopia
        "EUR" to "\uD83C\uDDEA\uD83C\uDDFA",  // Euro
        "FJD" to "\uD83C\uDDEB\uD83C\uDDEF",  // Fiji
        "FKP" to "\uD83C\uDDEB\uD83C\uDDF0",  // Falkland Islands
        "FOK" to "\uD83C\uDDEB\uD83C\uDDF4",  // Faroe Islands
        "GBP" to "\uD83C\uDDEC\uD83C\uDDE7",  // United Kingdom
        "GEL" to "\uD83C\uDDEC\uD83C\uDDEA",  // Georgia
        "GGP" to "\uD83C\uDDEC\uD83C\uDDEC",  // Guernsey
        "GHS" to "\uD83C\uDDEC\uD83C\uDDED",  // Ghana
        "GIP" to "\uD83C\uDDEC\uD83C\uDDEE",  // Gibraltar
        "GMD" to "\uD83C\uDDEC\uD83C\uDDF2",  // Gambia
        "GNF" to "\uD83C\uDDEC\uD83C\uDDF3",  // Guinea
        "GTQ" to "\uD83C\uDDEC\uD83C\uDDF9",  // Guatemala
        "GYD" to "\uD83C\uDDEC\uD83C\uDDFE",  // Guyana
        "HKD" to "\uD83C\uDDED\uD83C\uDDF0",  // Hong Kong SAR China
        "HNL" to "\uD83C\uDDED\uD83C\uDDF3",  // Honduras
        "HRK" to "\uD83C\uDDED\uD83C\uDDF7",  // Croatia
        "HTG" to "\uD83C\uDDED\uD83C\uDDF9",  // Haiti
        "HUF" to "\uD83C\uDDED\uD83C\uDDFA",  // Hungary
        "IDR" to "\uD83C\uDDEE\uD83C\uDDE9",  // Indonesia
        "ILS" to "\uD83C\uDDEE\uD83C\uDDF1",  // Israel
        "IMP" to "\uD83C\uDDEE\uD83C\uDDF2",  // Isle of Man
        "INR" to "\uD83C\uDDEE\uD83C\uDDF3",  // India
        "IQD" to "\uD83C\uDDEE\uD83C\uDDF6",  // Iraq
        "IRR" to "\uD83C\uDDEE\uD83C\uDDF7",  // Iran
        "ISK" to "\uD83C\uDDEE\uD83C\uDDF8",  // Iceland
        "JEP" to "\uD83C\uDDEF\uD83C\uDDEA",  // Jersey
        "JMD" to "\uD83C\uDDEF\uD83C\uDDF2",  // Jamaica
        "JOD" to "\uD83C\uDDEF\uD83C\uDDF4",  // Jordan
        "JPY" to "\uD83C\uDDEF\uD83C\uDDF5",  // Japan
        "KES" to "\uD83C\uDDF0\uD83C\uDDEA",  // Kenya
        "KGS" to "\uD83C\uDDF0\uD83C\uDDEC",  // Kyrgyzstan
        "KHR" to "\uD83C\uDDF0\uD83C\uDDED",  // Cambodia
        "KID" to "\uD83C\uDDF0\uD83C\uDDEE",  // Kiribati
        "KMF" to "\uD83C\uDDF0\uD83C\uDDF2",  // Comoros
        "KRW" to "\uD83C\uDDF0\uD83C\uDDF7",  // South Korea
        "KWD" to "\uD83C\uDDF0\uD83C\uDDFC",  // Kuwait
        "KYD" to "\uD83C\uDDF0\uD83C\uDDFE",  // Cayman Islands
        "KZT" to "\uD83C\uDDF0\uD83C\uDDFF",  // Kazakhstan
        "LAK" to "\uD83C\uDDF1\uD83C\uDDE6",  // Laos
        "LBP" to "\uD83C\uDDF1\uD83C\uDDE7",  // Lebanon
        "LKR" to "\uD83C\uDDF1\uD83C\uDDF0",  // Sri Lanka
        "LRD" to "\uD83C\uDDF1\uD83C\uDDF7",  // Liberia
        "LSL" to "\uD83C\uDDF1\uD83C\uDDF8",  // Lesotho
        "LYD" to "\uD83C\uDDF1\uD83C\uDDFE",  // Libya
        "MAD" to "\uD83C\uDDF2\uD83C\uDDE6",  // Morocco
        "MDL" to "\uD83C\uDDF2\uD83C\uDDE9",  // Moldova
        "MGA" to "\uD83C\uDDF2\uD83C\uDDEC",  // Madagascar
        "MKD" to "\uD83C\uDDF2\uD83C\uDDF0",  // North Macedonia
        "MMK" to "\uD83C\uDDF2\uD83C\uDDF2",  // Myanmar (Burma)
        "MNT" to "\uD83C\uDDF2\uD83C\uDDF3",  // Mongolia
        "MOP" to "\uD83C\uDDF2\uD83C\uDDF4",  // Macao SAR China
        "MRU" to "\uD83C\uDDF2\uD83C\uDDF7",  // Mauritania
        "MUR" to "\uD83C\uDDF2\uD83C\uDDFA",  // Mauritius
        "MVR" to "\uD83C\uDDF2\uD83C\uDDFB",  // Maldives
        "MWK" to "\uD83C\uDDF2\uD83C\uDDFC",  // Malawi
        "MXN" to "\uD83C\uDDF2\uD83C\uDDFD",  // Mexico
        "MYR" to "\uD83C\uDDF2\uD83C\uDDFE",  // Malaysia
        "MZN" to "\uD83C\uDDF2\uD83C\uDDFF",  // Mozambique
        "NAD" to "\uD83C\uDDF3\uD83C\uDDE6",  // Namibia
        "NGN" to "\uD83C\uDDF3\uD83C\uDDEC",  // Nigeria
        "NIO" to "\uD83C\uDDF3\uD83C\uDDEE",  // Nicaragua
        "NOK" to "\uD83C\uDDF3\uD83C\uDDF4",  // Norway
        "NPR" to "\uD83C\uDDF3\uD83C\uDDF5",  // Nepal
        "NZD" to "\uD83C\uDDF3\uD83C\uDDFF",  // New Zealand
        "OMR" to "\uD83C\uDDF4\uD83C\uDDF2",  // Oman
        "PAB" to "\uD83C\uDDF5\uD83C\uDDE6",  // Panama
        "PEN" to "\uD83C\uDDF5\uD83C\uDDEA",  // Peru
        "PGK" to "\uD83C\uDDF5\uD83C\uDDEC",  // Papua New Guinea
        "PHP" to "\uD83C\uDDF5\uD83C\uDDED",  // Philippines
        "PKR" to "\uD83C\uDDF5\uD83C\uDDF0",  // Pakistan
        "PLN" to "\uD83C\uDDF5\uD83C\uDDF1",  // Poland
        "PYG" to "\uD83C\uDDF5\uD83C\uDDFE",  // Paraguay
        "QAR" to "\uD83C\uDDF6\uD83C\uDDE6",  // Qatar
        "RON" to "\uD83C\uDDF7\uD83C\uDDF4",  // Romania
        "RSD" to "\uD83C\uDDF7\uD83C\uDDF8",  // Serbia
        "RUB" to "\uD83C\uDDF7\uD83C\uDDFA",  // Russia
        "RWF" to "\uD83C\uDDF7\uD83C\uDDFC",  // Rwanda
        "SAR" to "\uD83C\uDDF8\uD83C\uDDE6",  // Saudi Arabia
        "SBD" to "\uD83C\uDDF8\uD83C\uDDE7",  // Solomon Islands
        "SCR" to "\uD83C\uDDF8\uD83C\uDDE8",  // Seychelles
        "SDG" to "\uD83C\uDDF8\uD83C\uDDE9",  // Sudan
        "SEK" to "\uD83C\uDDF8\uD83C\uDDEA",  // Sweden
        "SGD" to "\uD83C\uDDF8\uD83C\uDDEC",  // Singapore
        "SHP" to "\uD83C\uDDF8\uD83C\uDDED",  // Saint Helena
        "SLE" to "\uD83C\uDDF8\uD83C\uDDF1",  // Sierra Leone
        "SLL" to "\uD83C\uDDF8\uD83C\uDDF1",  // Sierra Leone
        "SOS" to "\uD83C\uDDF8\uD83C\uDDF4",  // Somalia
        "SRD" to "\uD83C\uDDF8\uD83C\uDDF7",  // Suriname
        "SSP" to "\uD83C\uDDF8\uD83C\uDDF8",  // South Sudan
        "STN" to "\uD83C\uDDF8\uD83C\uDDF9",  // São Tomé & Príncipe
        "SYP" to "\uD83C\uDDF8\uD83C\uDDFE",  // Syria
        "SZL" to "\uD83C\uDDF8\uD83C\uDDFF",  // Eswatini
        "THB" to "\uD83C\uDDF9\uD83C\uDDED",  // Thailand
        "TJS" to "\uD83C\uDDF9\uD83C\uDDEF",  // Tajikistan
        "TMT" to "\uD83C\uDDF9\uD83C\uDDF2",  // Turkmenistan
        "TND" to "\uD83C\uDDF9\uD83C\uDDF3",  // Tunisia
        "TOP" to "\uD83C\uDDF9\uD83C\uDDF4",  // Tonga
        "TRY" to "\uD83C\uDDF9\uD83C\uDDF7",  // Turkey
        "TTD" to "\uD83C\uDDF9\uD83C\uDDF9",  // Trinidad & Tobago
        "TVD" to "\uD83C\uDDF9\uD83C\uDDFB",  // Tuvalu
        "TWD" to "\uD83C\uDDF9\uD83C\uDDFC",  // Taiwan
        "TZS" to "\uD83C\uDDF9\uD83C\uDDFF",  // Tanzania
        "UAH" to "\uD83C\uDDFA\uD83C\uDDE6",  // Ukraine
        "UGX" to "\uD83C\uDDFA\uD83C\uDDEC",  // Uganda
        "UYU" to "\uD83C\uDDFA\uD83C\uDDFE",  // Uruguay
        "UZS" to "\uD83C\uDDFA\uD83C\uDDFF",  // Uzbekistan
        "VES" to "\uD83C\uDDFB\uD83C\uDDEA",  // Venezuela
        "VND" to "\uD83C\uDDFB\uD83C\uDDF3",  // Vietnam
        "VUV" to "\uD83C\uDDFB\uD83C\uDDFA",  // Vanuatu
        "WST" to "\uD83C\uDDFC\uD83C\uDDF8",  // Samoa
        "XAF" to "\uD83C\uDDE8\uD83C\uDDE6",  // Central African CFA franc
        "XCD" to "\uD83C\uDDE8\uD83C\uDDE7",  // East Caribbean dollar
        "XDR" to "\uD83C\uDDE8\uD83C\uDDE9",  // Special Drawing Rights
        "XOF" to "\uD83C\uDDE8\uD83C\uDDE6",  // West African CFA franc
        "XPF" to "\uD83C\uDDE8\uD83C\uDDF5",  // CFP franc
        "YER" to "\uD83C\uDDF2\uD83C\uDDEA",  // Yemen
        "ZAR" to "\uD83C\uDDFF\uD83C\uDDE6",  // South Africa
        "ZMW" to "\uD83C\uDDFF\uD83C\uDDF2",  // Zambia
        "ZWL" to "\uD83C\uDDFF\uD83C\uDDFC"   // Zimbabwe
    )

    val currencies = hashMapOf(
        "USD" to Pair("United States Dollar", "\uD83C\uDDFA\uD83C\uDDF8"),
        "AED" to Pair("United Arab Emirates Dirham", "\uD83C\uDDE6\uD83C\uDDEA"),
        "AFN" to Pair("Afghan Afghani", "\uD83C\uDDE6\uD83C\uDDEB"),
        "ALL" to Pair("Albanian Lek", "\uD83C\uDDE6\uD83C\uDDF1"),
        "AMD" to Pair("Armenian Dram", "\uD83C\uDDE6\uD83C\uDDF2"),
        "ANG" to Pair("Netherlands Antillean Guilder", "\uD83C\uDDE6\uD83C\uDDF6"),
        "AOA" to Pair("Angolan Kwanza", "\uD83C\uDDE6\uD83C\uDDF4"),
        "ARS" to Pair("Argentine Peso", "\uD83C\uDDE6\uD83C\uDDF7"),
        "AUD" to Pair("Australian Dollar", "\uD83C\uDDE6\uD83C\uDDFA"),
        "AWG" to Pair("Aruban Florin", "\uD83C\uDDE6\uD83C\uDDFC"),
        "AZN" to Pair("Azerbaijani Manat", "\uD83C\uDDE6\uD83C\uDDFF"),
        "BAM" to Pair("Bosnia-Herzegovina Convertible Mark", "\uD83C\uDDE7\uD83C\uDDE6"),
        "BBD" to Pair("Barbadian Dollar", "\uD83C\uDDE7\uD83C\uDDE7"),
        "BDT" to Pair("Bangladeshi Taka", "\uD83C\uDDE7\uD83C\uDDE9"),
        "BGN" to Pair("Bulgarian Lev", "\uD83C\uDDE7\uD83C\uDDEC"),
        "BHD" to Pair("Bahraini Dinar", "\uD83C\uDDE7\uD83C\uDDED"),
        "BIF" to Pair("Burundian Franc", "\uD83C\uDDE7\uD83C\uDDEE"),
        "BMD" to Pair("Bermudian Dollar", "\uD83C\uDDE7\uD83C\uDDF2"),
        "BND" to Pair("Brunei Dollar", "\uD83C\uDDE7\uD83C\uDDF3"),
        "BOB" to Pair("Bolivian Boliviano", "\uD83C\uDDE7\uD83C\uDDF4"),
        "BRL" to Pair("Brazilian Real", "\uD83C\uDDE7\uD83C\uDDF7"),
        "BSD" to Pair("Bahamian Dollar", "\uD83C\uDDE7\uD83C\uDDF8"),
        "BTN" to Pair("Bhutanese Ngultrum", "\uD83C\uDDE7\uD83C\uDDF9"),
        "BWP" to Pair("Botswana Pula", "\uD83C\uDDE7\uD83C\uDDFC"),
        "BYN" to Pair("Belarusian Ruble", "\uD83C\uDDE7\uD83C\uDDFE"),
        "BZD" to Pair("Belize Dollar", "\uD83C\uDDE7\uD83C\uDDFF"),
        "CAD" to Pair("Canadian Dollar", "\uD83C\uDDE8\uD83C\uDDE6"),
        "CDF" to Pair("Congolese Franc", "\uD83C\uDDE8\uD83C\uDDE9"),
        "CHF" to Pair("Swiss Franc", "\uD83C\uDDE8\uD83C\uDDED"),
        "CLP" to Pair("Chilean Peso", "\uD83C\uDDE8\uD83C\uDDF1"),
        "CNY" to Pair("Chinese Yuan", "\uD83C\uDDE8\uD83C\uDDF3"),
        "COP" to Pair("Colombian Peso", "\uD83C\uDDE8\uD83C\uDDF4"),
        "CRC" to Pair("Costa Rican Colón", "\uD83C\uDDE8\uD83C\uDDF7"),
        "CUP" to Pair("Cuban Peso", "\uD83C\uDDE8\uD83C\uDDFA"),
        "CVE" to Pair("Cape Verdean Escudo", "\uD83C\uDDE8\uD83C\uDDFB"),
        "CZK" to Pair("Czech Koruna", "\uD83C\uDDE8\uD83C\uDDFF"),
        "DJF" to Pair("Djiboutian Franc", "\uD83C\uDDE9\uD83C\uDDEF"),
        "DKK" to Pair("Danish Krone", "\uD83C\uDDE9\uD83C\uDDF0"),
        "DOP" to Pair("Dominican Peso", "\uD83C\uDDE9\uD83C\uDDF4"),
        "DZD" to Pair("Algerian Dinar", "\uD83C\uDDE9\uD83C\uDDFF"),
        "EGP" to Pair("Egyptian Pound", "\uD83C\uDDEA\uD83C\uDDEC"),
        "ERN" to Pair("Eritrean Nakfa", "\uD83C\uDDEA\uD83C\uDDF7"),
        "ETB" to Pair("Ethiopian Birr", "\uD83C\uDDEA\uD83C\uDDF9"),
        "EUR" to Pair("Euro", "\uD83C\uDDEA\uD83C\uDDFA"),
        "FJD" to Pair("Fijian Dollar", "\uD83C\uDDEB\uD83C\uDDEF"),
        "FKP" to Pair("Falkland Islands Pound", "\uD83C\uDDEB\uD83C\uDDF0"),
        "FOK" to Pair("Faroese Króna", "\uD83C\uDDEB\uD83C\uDDF4"),
        "GBP" to Pair("British Pound Sterling", "\uD83C\uDDEC\uD83C\uDDE7"),
        "GEL" to Pair("Georgian Lari", "\uD83C\uDDEC\uD83C\uDDEA"),
        "GGP" to Pair("Guernsey Pound", "\uD83C\uDDEC\uD83C\uDDEC"),
        "GHS" to Pair("Ghanaian Cedi", "\uD83C\uDDEC\uD83C\uDDED"),
        "GIP" to Pair("Gibraltar Pound", "\uD83C\uDDEC\uD83C\uDDEE"),
        "GMD" to Pair("Gambian Dalasi", "\uD83C\uDDEC\uD83C\uDDF2"),
        "GNF" to Pair("Guinean Franc", "\uD83C\uDDEC\uD83C\uDDF3"),
        "GTQ" to Pair("Guatemalan Quetzal", "\uD83C\uDDEC\uD83C\uDDF9"),
        "GYD" to Pair("Guyanaese Dollar", "\uD83C\uDDEC\uD83C\uDDFE"),
        "HKD" to Pair("Hong Kong Dollar", "\uD83C\uDDEC\uD83C\uDDE9"),
        "HNL" to Pair("Honduran Lempira", "\uD83C\uDDED\uD83C\uDDF3"),
        "HRK" to Pair("Croatian Kuna", "\uD83C\uDDED\uD83C\uDDF7"),
        "HTG" to Pair("Haitian Gourde", "\uD83C\uDDED\uD83C\uDDF9"),
        "HUF" to Pair("Hungarian Forint", "\uD83C\uDDED\uD83C\uDDFA"),
        "IDR" to Pair("Indonesian Rupiah", "\uD83C\uDDEE\uD83C\uDDE9"),
        "ILS" to Pair("Israeli New Shekel", "\uD83C\uDDEE\uD83C\uDDF1"),
        "IMP" to Pair("Isle of Man Pound", "\uD83C\uDDEE\uD83C\uDDF2"),
        "INR" to Pair("Indian Rupee", "\uD83C\uDDEE\uD83C\uDDF3"),
        "IQD" to Pair("Iraqi Dinar", "\uD83C\uDDEE\uD83C\uDDF6"),
        "IRR" to Pair("Iranian Rial", "\uD83C\uDDEE\uD83C\uDDF7"),
        "ISK" to Pair("Icelandic Króna", "\uD83C\uDDEE\uD83C\uDDF8"),
        "JEP" to Pair("Jersey Pound", "\uD83C\uDDEF\uD83C\uDDEA"),
        "JMD" to Pair("Jamaican Dollar", "\uD83C\uDDEF\uD83C\uDDF2"),
        "JOD" to Pair("Jordanian Dinar", "\uD83C\uDDEF\uD83C\uDDF4"),
        "JPY" to Pair("Japanese Yen", "\uD83C\uDDEF\uD83C\uDDF5"),
        "KES" to Pair("Kenyan Shilling", "\uD83C\uDDF0\uD83C\uDDEA"),
        "KGS" to Pair("Kyrgystani Som", "\uD83C\uDDF0\uD83C\uDDEC"),
        "KHR" to Pair("Cambodian Riel", "\uD83C\uDDF0\uD83C\uDDED"),
        "KID" to Pair("Kiribati Dollar", "\uD83C\uDDF0\uD83C\uDDEE"),
        "KMF" to Pair("Comorian Franc", "\uD83C\uDDF0\uD83C\uDDEA"),
        "KRW" to Pair("South Korean Won", "\uD83C\uDDF0\uD83C\uDDF7"),
        "KWD" to Pair("Kuwaiti Dinar", "\uD83C\uDDF0\uD83C\uDDFC"),
        "KYD" to Pair("Cayman Islands Dollar", "\uD83C\uDDF0\uD83C\uDDFE"),
        "KZT" to Pair("Kazakhstani Tenge", "\uD83C\uDDF0\uD83C\uDDFF"),
        "LAK" to Pair("Laotian Kip", "\uD83C\uDDF1\uD83C\uDDE6"),
        "LBP" to Pair("Lebanese Pound", "\uD83C\uDDF1\uD83C\uDDE7"),
        "LKR" to Pair("Sri Lankan Rupee", "\uD83C\uDDF1\uD83C\uDDF0"),
        "LRD" to Pair("Liberian Dollar", "\uD83C\uDDF1\uD83C\uDDF7"),
        "LSL" to Pair("Lesotho Loti", "\uD83C\uDDF1\uD83C\uDDF8"),
        "LYD" to Pair("Libyan Dinar", "\uD83C\uDDF1\uD83C\uDDFE"),
        "MAD" to Pair("Moroccan Dirham", "\uD83C\uDDF2\uD83C\uDDE6"),
        "MDL" to Pair("Moldovan Leu", "\uD83C\uDDF2\uD83C\uDDE9"),
        "MGA" to Pair("Malagasy Ariary", "\uD83C\uDDF2\uD83C\uDDEC"),
        "MKD" to Pair("Macedonian Denar", "\uD83C\uDDF2\uD83C\uDDF0"),
        "MMK" to Pair("Myanmar Kyat", "\uD83C\uDDF2\uD83C\uDDF2"),
        "MNT" to Pair("Mongolian Tugrik", "\uD83C\uDDF2\uD83C\uDDF3"),
        "MOP" to Pair("Macanese Pataca", "\uD83C\uDDF2\uD83C\uDDF4"),
        "MRU" to Pair("Mauritanian Ouguiya", "\uD83C\uDDF2\uD83C\uDDF7"),
        "MUR" to Pair("Mauritian Rupee", "\uD83C\uDDF2\uD83C\uDDF7"),
        "MVR" to Pair("Maldivian Rufiyaa", "\uD83C\uDDF2\uD83C\uDDF8"),
        "MWK" to Pair("Malawian Kwacha", "\uD83C\uDDF2\uD83C\uDDFC"),
        "MXN" to Pair("Mexican Peso", "\uD83C\uDDF2\uD83C\uDDFD"),
        "MYR" to Pair("Malaysian Ringgit", "\uD83C\uDDF2\uD83C\uDDFE"),
        "MZN" to Pair("Mozambican Metical", "\uD83C\uDDF2\uD83C\uDDFF"),
        "NAD" to Pair("Namibian Dollar", "\uD83C\uDDF3\uD83C\uDDE6"),
        "NGN" to Pair("Nigerian Naira", "\uD83C\uDDF3\uD83C\uDDEC"),
        "NIO" to Pair("Nicaraguan Córdoba", "\uD83C\uDDF3\uD83C\uDDEE"),
        "NOK" to Pair("Norwegian Krone", "\uD83C\uDDF3\uD83C\uDDF4"),
        "NPR" to Pair("Nepalese Rupee", "\uD83C\uDDF3\uD83C\uDDF5"),
        "NZD" to Pair("New Zealand Dollar", "\uD83C\uDDF3\uD83C\uDDFF"),
        "OMR" to Pair("Omani Rial", "\uD83C\uDDF4\uD83C\uDDF2"),
        "PAB" to Pair("Panamanian Balboa", "\uD83C\uDDF5\uD83C\uDDE6"),
        "PEN" to Pair("Peruvian Nuevo Sol", "\uD83C\uDDF5\uD83C\uDDEA"),
        "PGK" to Pair("Papua New Guinean Kina", "\uD83C\uDDF5\uD83C\uDDEC"),
        "PHP" to Pair("Philippine Peso", "\uD83C\uDDF5\uD83C\uDDED"),
        "PKR" to Pair("Pakistani Rupee", "\uD83C\uDDF5\uD83C\uDDF0"),
        "PLN" to Pair("Polish Zloty", "\uD83C\uDDF5\uD83C\uDDF1"),
        "PYG" to Pair("Paraguayan Guarani", "\uD83C\uDDF5\uD83C\uDDFE"),
        "QAR" to Pair("Qatari Rial", "\uD83C\uDDF6\uD83C\uDDE6"),
        "RON" to Pair("Romanian Leu", "\uD83C\uDDF7\uD83C\uDDF4"),
        "RSD" to Pair("Serbian Dinar", "\uD83C\uDDF7\uD83C\uDDF8"),
        "RUB" to Pair("Russian Ruble", "\uD83C\uDDF7\uD83C\uDDFA"),
        "RWF" to Pair("Rwandan Franc", "\uD83C\uDDF7\uD83C\uDDFC"),
        "SAR" to Pair("Saudi Riyal", "\uD83C\uDDF8\uD83C\uDDE6"),
        "SBD" to Pair("Solomon Islands Dollar", "\uD83C\uDDF8\uD83C\uDDE7"),
        "SCR" to Pair("Seychellois Rupee", "\uD83C\uDDF8\uD83C\uDDE8"),
        "SDG" to Pair("Sudanese Pound", "\uD83C\uDDF8\uD83C\uDDE9"),
        "SEK" to Pair("Swedish Krona", "\uD83C\uDDF8\uD83C\uDDEA"),
        "SGD" to Pair("Singapore Dollar", "\uD83C\uDDF8\uD83C\uDDEC"),
        "SHP" to Pair("Saint Helena Pound", "\uD83C\uDDF8\uD83C\uDDED"),
        "SLL" to Pair("Sierra Leonean Leone", "\uD83C\uDDF8\uD83C\uDDF1"),
        "SOS" to Pair("Somali Shilling", "\uD83C\uDDF8\uD83C\uDDF4"),
        "SRD" to Pair("Surinamese Dollar", "\uD83C\uDDF8\uD83C\uDDF7"),
        "SSP" to Pair("South Sudanese Pound", "\uD83C\uDDF8\uD83C\uDDF8"),
        "STN" to Pair("São Tomé and Príncipe Dobra", "\uD83C\uDDF8\uD83C\uDDF9"),
        "SYP" to Pair("Syrian Pound", "\uD83C\uDDF8\uD83C\uDDFE"),
        "SZL" to Pair("Swazi Lilangeni", "\uD83C\uDDF8\uD83C\uDDFF"),
        "THB" to Pair("Thai Baht", "\uD83C\uDDF9\uD83C\uDDED"),
        "TJS" to Pair("Tajikistani Somoni", "\uD83C\uDDF9\uD83C\uDDEF"),
        "TMT" to Pair("Turkmenistani Manat", "\uD83C\uDDF9\uD83C\uDDF2"),
        "TND" to Pair("Tunisian Dinar", "\uD83C\uDDF9\uD83C\uDDF3"),
        "TOP" to Pair("Tongan Pa'anga", "\uD83C\uDDF9\uD83C\uDDF4"),
        "TRY" to Pair("Turkish Lira", "\uD83C\uDDF9\uD83C\uDDF7"),
        "TTD" to Pair("Trinidad and Tobago Dollar", "\uD83C\uDDF9\uD83C\uDDF9"),
        "TVD" to Pair("Tuvaluan Dollar", "\uD83C\uDDF9\uD83C\uDDFB"),
        "TWD" to Pair("New Taiwan Dollar", "\uD83C\uDDF9\uD83C\uDDFC"),
        "TZS" to Pair("Tanzanian Shilling", "\uD83C\uDDF9\uD83C\uDDFF"),
        "UAH" to Pair("Ukrainian Hryvnia", "\uD83C\uDDFA\uD83C\uDDE6"),
        "UGX" to Pair("Ugandan Shilling", "\uD83C\uDDFA\uD83C\uDDEC"),
        "USD" to Pair("United States Dollar", "\uD83C\uDDFA\uD83C\uDDF8"),
        "UYU" to Pair("Uruguayan Peso", "\uD83C\uDDFA\uD83C\uDDFE"),
        "UZS" to Pair("Uzbekistan Som", "\uD83C\uDDFA\uD83C\uDDFF"),
        "VES" to Pair("Venezuelan Bolívar", "\uD83C\uDDFB\uD83C\uDDEA"),
        "VND" to Pair("Vietnamese Dong", "\uD83C\uDDFB\uD83C\uDDF3"),
        "VUV" to Pair("Vanuatu Vatu", "\uD83C\uDDFB\uD83C\uDDFA"),
        "WST" to Pair("Samoan Tala", "\uD83C\uDDFC\uD83C\uDDF8"),
        "XAF" to Pair("CFA Franc BEAC", "\uD83C\uDDE8\uD83C\uDDEB"),
        "XCD" to Pair("East Caribbean Dollar", "\uD83C\uDDE8\uD83C\uDDE8"),
        "XDR" to Pair("Special Drawing Rights", "\uD83C\uDDE8\uD83C\uDDE9"),
        "XOF" to Pair("CFA Franc BCEAO", "\uD83C\uDDE8\uD83C\uDDF4"),
        "XPF" to Pair("CFP Franc", "\uD83C\uDDE8\uD83C\uDDF5"),
        "YER" to Pair("Yemeni Rial", "\uD83C\uDDFE\uD83C\uDDEA"),
        "ZAR" to Pair("South African Rand", "\uD83C\uDDFF\uD83C\uDDE6"),
        "ZMW" to Pair("Zambian Kwacha", "\uD83C\uDDFF\uD83C\uDDF2"),
        "ZWL" to Pair("Zimbabwean Dollar", "\uD83C\uDDFF\uD83C\uDDFC"))

    val currencyList = listOf(
        Triple("USD", "United States Dollar", "\uD83C\uDDFA\uD83C\uDDF8"),
        Triple("AED", "United Arab Emirates Dirham", "\uD83C\uDDE6\uD83C\uDDEA"),
        Triple("AFN", "Afghan Afghani", "\uD83C\uDDE6\uD83C\uDDEB"),
        Triple("ALL", "Albanian Lek", "\uD83C\uDDE6\uD83C\uDDF1"),
        Triple("AMD", "Armenian Dram", "\uD83C\uDDE6\uD83C\uDDF2"),
        Triple("ANG", "Netherlands Antillean Guilder", "\uD83C\uDDE6\uD83C\uDDF6"),
        Triple("AOA", "Angolan Kwanza", "\uD83C\uDDE6\uD83C\uDDF4"),
        Triple("ARS", "Argentine Peso", "\uD83C\uDDE6\uD83C\uDDF7"),
        Triple("AUD", "Australian Dollar", "\uD83C\uDDE6\uD83C\uDDFA"),
        Triple("AWG", "Aruban Florin", "\uD83C\uDDE6\uD83C\uDDFC"),
        Triple("AZN", "Azerbaijani Manat", "\uD83C\uDDE6\uD83C\uDDFF"),
        Triple("BAM", "Bosnia-Herzegovina Convertible Mark", "\uD83C\uDDE7\uD83C\uDDE6"),
        Triple("BBD", "Barbadian Dollar", "\uD83C\uDDE7\uD83C\uDDE7"),
        Triple("BDT", "Bangladeshi Taka", "\uD83C\uDDE7\uD83C\uDDE9"),
        Triple("BGN", "Bulgarian Lev", "\uD83C\uDDE7\uD83C\uDDEC"),
        Triple("BHD", "Bahraini Dinar", "\uD83C\uDDE7\uD83C\uDDED"),
        Triple("BIF", "Burundian Franc", "\uD83C\uDDE7\uD83C\uDDEE"),
        Triple("BMD", "Bermudian Dollar", "\uD83C\uDDE7\uD83C\uDDF2"),
        Triple("BND", "Brunei Dollar", "\uD83C\uDDE7\uD83C\uDDF3"),
        Triple("BOB", "Bolivian Boliviano", "\uD83C\uDDE7\uD83C\uDDF4"),
        Triple("BRL", "Brazilian Real", "\uD83C\uDDE7\uD83C\uDDF7"),
        Triple("BSD", "Bahamian Dollar", "\uD83C\uDDE7\uD83C\uDDF8"),
        Triple("BTN", "Bhutanese Ngultrum", "\uD83C\uDDE7\uD83C\uDDF9"),
        Triple("BWP", "Botswana Pula", "\uD83C\uDDE7\uD83C\uDDFC"),
        Triple("BYN", "Belarusian Ruble", "\uD83C\uDDE7\uD83C\uDDFE"),
        Triple("BZD", "Belize Dollar", "\uD83C\uDDE7\uD83C\uDDFF"),
        Triple("CAD", "Canadian Dollar", "\uD83C\uDDE8\uD83C\uDDE6"),
        Triple("CDF", "Congolese Franc", "\uD83C\uDDE8\uD83C\uDDE9"),
        Triple("CHF", "Swiss Franc", "\uD83C\uDDE8\uD83C\uDDED"),
        Triple("CLP", "Chilean Peso", "\uD83C\uDDE8\uD83C\uDDF1"),
        Triple("CNY", "Chinese Yuan", "\uD83C\uDDE8\uD83C\uDDF3"),
        Triple("COP", "Colombian Peso", "\uD83C\uDDE8\uD83C\uDDF4"),
        Triple("CRC", "Costa Rican Colón", "\uD83C\uDDE8\uD83C\uDDF7"),
        Triple("CUP", "Cuban Peso", "\uD83C\uDDE8\uD83C\uDDFA"),
        Triple("CVE", "Cape Verdean Escudo", "\uD83C\uDDE8\uD83C\uDDFB"),
        Triple("CZK", "Czech Koruna", "\uD83C\uDDE8\uD83C\uDDFF"),
        Triple("DJF", "Djiboutian Franc", "\uD83C\uDDE9\uD83C\uDDEF"),
        Triple("DKK", "Danish Krone", "\uD83C\uDDE9\uD83C\uDDF0"),
        Triple("DOP", "Dominican Peso", "\uD83C\uDDE9\uD83C\uDDF4"),
        Triple("DZD", "Algerian Dinar", "\uD83C\uDDE9\uD83C\uDDFF"),
        Triple("EGP", "Egyptian Pound", "\uD83C\uDDEA\uD83C\uDDEC"),
        Triple("ERN", "Eritrean Nakfa", "\uD83C\uDDEA\uD83C\uDDF7"),
        Triple("ETB", "Ethiopian Birr", "\uD83C\uDDEA\uD83C\uDDF9"),
        Triple("EUR", "Euro", "\uD83C\uDDEA\uD83C\uDDFA"),
        Triple("FJD", "Fijian Dollar", "\uD83C\uDDEB\uD83C\uDDEF"),
        Triple("FKP", "Falkland Islands Pound", "\uD83C\uDDEB\uD83C\uDDF0"),
        Triple("FOK", "Faroese Króna", "\uD83C\uDDEB\uD83C\uDDF4"),
        Triple("GBP", "British Pound Sterling", "\uD83C\uDDEC\uD83C\uDDE7"),
        Triple("GEL", "Georgian Lari", "\uD83C\uDDEC\uD83C\uDDEA"),
        Triple("GGP", "Guernsey Pound", "\uD83C\uDDEC\uD83C\uDDEC"),
        Triple("GHS", "Ghanaian Cedi", "\uD83C\uDDEC\uD83C\uDDED"),
        Triple("GIP", "Gibraltar Pound", "\uD83C\uDDEC\uD83C\uDDEE"),
        Triple("GMD", "Gambian Dalasi", "\uD83C\uDDEC\uD83C\uDDF2"),
        Triple("GNF", "Guinean Franc", "\uD83C\uDDEC\uD83C\uDDF3"),
        Triple("GTQ", "Guatemalan Quetzal", "\uD83C\uDDEC\uD83C\uDDF9"),
        Triple("GYD", "Guyanaese Dollar", "\uD83C\uDDEC\uD83C\uDDFE"),
        Triple("HKD", "Hong Kong Dollar", "\uD83C\uDDEC\uD83C\uDDE9"),
        Triple("HNL", "Honduran Lempira", "\uD83C\uDDED\uD83C\uDDF3"),
        Triple("HRK", "Croatian Kuna", "\uD83C\uDDED\uD83C\uDDF7"),
        Triple("HTG", "Haitian Gourde", "\uD83C\uDDED\uD83C\uDDF9"),
        Triple("HUF", "Hungarian Forint", "\uD83C\uDDED\uD83C\uDDFA"),
        Triple("IDR", "Indonesian Rupiah", "\uD83C\uDDEE\uD83C\uDDE9"),
        Triple("ILS", "Israeli New Shekel", "\uD83C\uDDEE\uD83C\uDDF1"),
        Triple("IMP", "Isle of Man Pound", "\uD83C\uDDEE\uD83C\uDDF2"),
        Triple("INR", "Indian Rupee", "\uD83C\uDDEE\uD83C\uDDF3"),
        Triple("IQD", "Iraqi Dinar", "\uD83C\uDDEE\uD83C\uDDF6"),
        Triple("IRR", "Iranian Rial", "\uD83C\uDDEE\uD83C\uDDF7"),
        Triple("ISK", "Icelandic Króna", "\uD83C\uDDEE\uD83C\uDDF8"),
        Triple("JEP", "Jersey Pound", "\uD83C\uDDEF\uD83C\uDDEA"),
        Triple("JMD", "Jamaican Dollar", "\uD83C\uDDEF\uD83C\uDDF2"),
        Triple("JOD", "Jordanian Dinar", "\uD83C\uDDEF\uD83C\uDDF4"),
        Triple("JPY", "Japanese Yen", "\uD83C\uDDEF\uD83C\uDDF5"),
        Triple("KES", "Kenyan Shilling", "\uD83C\uDDF0\uD83C\uDDEA"),
        Triple("KGS", "Kyrgystani Som", "\uD83C\uDDF0\uD83C\uDDEC"),
        Triple("KHR", "Cambodian Riel", "\uD83C\uDDF0\uD83C\uDDED"),
        Triple("KID", "Kiribati Dollar", "\uD83C\uDDF0\uD83C\uDDEE"),
        Triple("KMF", "Comorian Franc", "\uD83C\uDDF0\uD83C\uDDEA"),
        Triple("KRW", "South Korean Won", "\uD83C\uDDF0\uD83C\uDDF7"),
        Triple("KWD", "Kuwaiti Dinar", "\uD83C\uDDF0\uD83C\uDDFC"),
        Triple("KYD", "Cayman Islands Dollar", "\uD83C\uDDF0\uD83C\uDDFE"),
        Triple("KZT", "Kazakhstani Tenge", "\uD83C\uDDF0\uD83C\uDDFF"),
        Triple("LAK", "Laotian Kip", "\uD83C\uDDF1\uD83C\uDDE6"),
        Triple("LBP", "Lebanese Pound", "\uD83C\uDDF1\uD83C\uDDE7"),
        Triple("LKR", "Sri Lankan Rupee", "\uD83C\uDDF1\uD83C\uDDF0"),
        Triple("LRD", "Liberian Dollar", "\uD83C\uDDF1\uD83C\uDDF7"),
        Triple("LSL", "Lesotho Loti", "\uD83C\uDDF1\uD83C\uDDF8"),
        Triple("LYD", "Libyan Dinar", "\uD83C\uDDF1\uD83C\uDDFE"),
        Triple("MAD", "Moroccan Dirham", "\uD83C\uDDF2\uD83C\uDDE6"),
        Triple("MDL", "Moldovan Leu", "\uD83C\uDDF2\uD83C\uDDE9"),
        Triple("MGA", "Malagasy Ariary", "\uD83C\uDDF2\uD83C\uDDEC"),
        Triple("MKD", "Macedonian Denar", "\uD83C\uDDF2\uD83C\uDDF0"),
        Triple("MMK", "Myanmar Kyat", "\uD83C\uDDF2\uD83C\uDDF2"),
        Triple("MNT", "Mongolian Tugrik", "\uD83C\uDDF2\uD83C\uDDF3"),
        Triple("MOP", "Macanese Pataca", "\uD83C\uDDF2\uD83C\uDDF4"),
        Triple("MRU", "Mauritanian Ouguiya", "\uD83C\uDDF2\uD83C\uDDF7"),
        Triple("MUR", "Mauritian Rupee", "\uD83C\uDDF2\uD83C\uDDF7"),
        Triple("MVR", "Maldivian Rufiyaa", "\uD83C\uDDF2\uD83C\uDDF8"),
        Triple("MWK", "Malawian Kwacha", "\uD83C\uDDF2\uD83C\uDDFC"),
        Triple("MXN", "Mexican Peso", "\uD83C\uDDF2\uD83C\uDDFD"),
        Triple("MYR", "Malaysian Ringgit", "\uD83C\uDDF2\uD83C\uDDFE"),
        Triple("MZN", "Mozambican Metical", "\uD83C\uDDF2\uD83C\uDDFF"),
        Triple("NAD", "Namibian Dollar", "\uD83C\uDDF3\uD83C\uDDE6"),
        Triple("NGN", "Nigerian Naira", "\uD83C\uDDF3\uD83C\uDDEC"),
        Triple("NIO", "Nicaraguan Córdoba", "\uD83C\uDDF3\uD83C\uDDEE"),
        Triple("NOK", "Norwegian Krone", "\uD83C\uDDF3\uD83C\uDDF4"),
        Triple("NPR", "Nepalese Rupee", "\uD83C\uDDF3\uD83C\uDDF5"),
        Triple("NZD", "New Zealand Dollar", "\uD83C\uDDF3\uD83C\uDDFF"),
        Triple("OMR", "Omani Rial", "\uD83C\uDDF4\uD83C\uDDF2"),
        Triple("PAB", "Panamanian Balboa", "\uD83C\uDDF5\uD83C\uDDE6"),
        Triple("PEN", "Peruvian Nuevo Sol", "\uD83C\uDDF5\uD83C\uDDEA"),
        Triple("PGK", "Papua New Guinean Kina", "\uD83C\uDDF5\uD83C\uDDEC"),
        Triple("PHP", "Philippine Peso", "\uD83C\uDDF5\uD83C\uDDED"),
        Triple("PKR", "Pakistani Rupee", "\uD83C\uDDF5\uD83C\uDDF0"),
        Triple("PLN", "Polish Zloty", "\uD83C\uDDF5\uD83C\uDDF1"),
        Triple("PYG", "Paraguayan Guarani", "\uD83C\uDDF5\uD83C\uDDFE"),
        Triple("QAR", "Qatari Rial", "\uD83C\uDDF6\uD83C\uDDE6"),
        Triple("RON", "Romanian Leu", "\uD83C\uDDF7\uD83C\uDDF4"),
        Triple("RSD", "Serbian Dinar", "\uD83C\uDDF7\uD83C\uDDF8"),
        Triple("RUB", "Russian Ruble", "\uD83C\uDDF7\uD83C\uDDFA"),
        Triple("RWF", "Rwandan Franc", "\uD83C\uDDF7\uD83C\uDDFC"),
        Triple("SAR", "Saudi Riyal", "\uD83C\uDDF8\uD83C\uDDE6"),
        Triple("SBD", "Solomon Islands Dollar", "\uD83C\uDDF8\uD83C\uDDE7"),
        Triple("SCR", "Seychellois Rupee", "\uD83C\uDDF8\uD83C\uDDE8"),
        Triple("SDG", "Sudanese Pound", "\uD83C\uDDF8\uD83C\uDDE9"),
        Triple("SEK", "Swedish Krona", "\uD83C\uDDF8\uD83C\uDDEA"),
        Triple("SGD", "Singapore Dollar", "\uD83C\uDDF8\uD83C\uDDEC"),
        Triple("SHP", "Saint Helena Pound", "\uD83C\uDDF8\uD83C\uDDED"),
        Triple("SLL", "Sierra Leonean Leone", "\uD83C\uDDF8\uD83C\uDDF1"),
        Triple("SOS", "Somali Shilling", "\uD83C\uDDF8\uD83C\uDDF4"),
        Triple("SRD", "Surinamese Dollar", "\uD83C\uDDF8\uD83C\uDDF7"),
        Triple("SSP", "South Sudanese Pound", "\uD83C\uDDF8\uD83C\uDDF8"),
        Triple("STN", "São Tomé and Príncipe Dobra", "\uD83C\uDDF8\uD83C\uDDF9"),
        Triple("SYP", "Syrian Pound", "\uD83C\uDDF8\uD83C\uDDFE"),
        Triple("SZL", "Swazi Lilangeni", "\uD83C\uDDF8\uD83C\uDDFF"),
        Triple("THB", "Thai Baht", "\uD83C\uDDF9\uD83C\uDDED"),
        Triple("TJS", "Tajikistani Somoni", "\uD83C\uDDF9\uD83C\uDDEF"),
        Triple("TMT", "Turkmenistani Manat", "\uD83C\uDDF9\uD83C\uDDF2"),
        Triple("TND", "Tunisian Dinar", "\uD83C\uDDF9\uD83C\uDDF3"),
        Triple("TOP", "Tongan Pa'anga", "\uD83C\uDDF9\uD83C\uDDF4"),
        Triple("TRY", "Turkish Lira", "\uD83C\uDDF9\uD83C\uDDF7"),
        Triple("TTD", "Trinidad and Tobago Dollar", "\uD83C\uDDF9\uD83C\uDDF9"),
        Triple("TVD", "Tuvaluan Dollar", "\uD83C\uDDF9\uD83C\uDDFB"),
        Triple("TWD", "New Taiwan Dollar", "\uD83C\uDDF9\uD83C\uDDFC"),
        Triple("TZS", "Tanzanian Shilling", "\uD83C\uDDF9\uD83C\uDDFF"),
        Triple("UAH", "Ukrainian Hryvnia", "\uD83C\uDDFA\uD83C\uDDE6"),
        Triple("UGX", "Ugandan Shilling", "\uD83C\uDDFA\uD83C\uDDEC"),
        Triple("UYU", "Uruguayan Peso", "\uD83C\uDDFA\uD83C\uDDFE"),
        Triple("UZS", "Uzbekistan Som", "\uD83C\uDDFA\uD83C\uDDFF"),
        Triple("VES", "Venezuelan Bolívar", "\uD83C\uDDFB\uD83C\uDDEA"),
        Triple("VND", "Vietnamese Dong", "\uD83C\uDDFB\uD83C\uDDF3"),
        Triple("VUV", "Vanuatu Vatu", "\uD83C\uDDFB\uD83C\uDDFA"),
        Triple("WST", "Samoan Tala", "\uD83C\uDDFC\uD83C\uDDF8"),
        Triple("XAF", "CFA Franc BEAC", "\uD83C\uDDE8\uD83C\uDDEB"),
        Triple("XCD", "East Caribbean Dollar", "\uD83C\uDDE8\uD83C\uDDEC"),
        Triple("XDR", "Special Drawing Rights", "\uD83C\uDDE8\uD83C\uDDF7"),
        Triple("XOF", "CFA Franc BCEAO", "\uD83C\uDDE8\uD83C\uDDF3"),
        Triple("XPF", "CFP Franc", "\uD83C\uDDE8\uD83C\uDDF5"),
        Triple("YER", "Yemeni Rial", "\uD83C\uDDF2\uD83C\uDDEA"),
        Triple("ZAR", "South African Rand", "\uD83C\uDDFF\uD83C\uDDE6"),
        Triple("ZMW", "Zambian Kwacha", "\uD83C\uDDFF\uD83C\uDDF2"),
        Triple("ZWL", "Zimbabwean Dollar", "\uD83C\uDDFF\uD83C\uDDFC")
    )

}